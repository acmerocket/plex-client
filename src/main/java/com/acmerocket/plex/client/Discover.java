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

import java.util.ArrayList;
import java.util.List;

import com.acmerocket.plex.client.model.Client;
import com.acmerocket.plex.client.model.PlexMediaServer;

/**
 * @author philion
 *
 */
public class Discover {
	
	public List<Client> getClients() {
		List<Client> clients = new ArrayList<>();
		
		// all servers
		
		
		// all clients per server
		
		// all GDM
		
		return clients;
	}
	
	public static List<PlexMediaServer> discoverServers() {
		return GdmHandler.getServers();
	}
}
