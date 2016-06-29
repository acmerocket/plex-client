/**
 * Copyright 2016 Acme Rocket Company [acmerocket.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.acmerocket.plex.client;

import java.util.HashMap;
import java.util.Map;

import com.acmerocket.plex.client.model.Client;
import com.acmerocket.plex.client.model.PlexMediaServer;

/**
 * This class is intended to model the top-level Plex network on the local network,
 * with certain default behaviors (based on simple assumptions)
 * @author philion
 *
 */
public class Plex {
    private final static org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Plex.class); 
    
    private final Map<String,PlexMediaServer> servers = new HashMap<>();
    private final Map<String,Client> players = new HashMap<>();
    private final Map<String,PlexClient> clients = new HashMap<>();

	// a main client with a few default behaviors.
    
    public Plex() {
    	for (PlexMediaServer server : Discover.servers()) {
    		this.servers.put(server.getResourceId(), server);
    		PlexClient plex = server.plexClient();
    		this.clients.put(server.getResourceId(), server.plexClient());
    		
    		for (Client player : plex.retrieveClients().getClients()) {
				players.put(player.getMachineId(), player);
	    		this.clients.put(player.getMachineId(), player.plexClient());
			}
    	}

    	LOG.info("Discovered {} server[s], {} player[s]", servers.size(), players.size());
    }
    
    public void pause() {
    	PlexClient client = defaultPlayer();
    	if (client != null) {
    		LOG.info("Pausing {}", client);
    		client.pause();
    	}
    	else {
    		LOG.warn("Unable to find player.");
    	}
    }
    
    protected PlexClient defaultPlayer() {
    	if (this.players.size() == 1) {
    		return this.players.values().iterator().next().plexClient();
    	}
    	else {
    		return null;
    	}
    }
    
    public void dump() {
    	for (PlexClient plex : this.clients.values()) {
    		LOG.info("--- {}", plex);
    	}
    }
	
//	protected static PlexClient defaultPlayer() {
//		// what's playing?
//		for (PlexMediaServer server : Discover.servers()) {
//			PlexClient plex = server.plexClient();
//			MediaContainer container = plex.retrieveSessions();
//			
//			//LOG.info("SESSIONS: {}", container);
//			
//			if (container.getTracks() != null) {
//				for (Track track : container.getTracks()) {
//					if (track.isPlaying()) {
//						//LOG.info("Playing right now: {}", track);
//						return track.getPlayer().getPlexClient();
//					}
//
//				}
//			}
//			if (container.getVideos() != null) {
//				for (Video video : container.getVideos()) {
//					if (video.isPlaying()) {
//						LOG.info("Playing right now: {}", video);
//					}
//				}
//			}
//		}
//		
//		// or, is there only one available?
//		
//		return null;
//	}
}
