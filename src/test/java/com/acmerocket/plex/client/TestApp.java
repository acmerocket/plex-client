package com.acmerocket.plex.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acmerocket.plex.client.model.Client;
import com.acmerocket.plex.client.model.MediaContainer;
import com.acmerocket.plex.client.model.PlexMediaServer;

public class TestApp {
    private final static Logger LOG = LoggerFactory.getLogger(TestApp.class); 

    public static void main(String[] args) throws Exception {
        //String plexServer = args[0]; // silly, meaningless exceptions
        //int plexPort = Configuration.DEFAULT_PORT;
        //if (args.length > 1) {
        //    plexPort = Integer.parseInt(args[1]);
        //}
        
        //Configuration config = new Configuration(plexServer, plexPort);
        //PlexClient client = new PlexClient(config);
        //MediaContainer response = //client.retrieveSections();
                //client.retrieveSections("11/all");
        //        client.retrieveClients();
        //
    	
    	LOG.info("Discoving all clients...");
    	
    	for (PlexMediaServer server : Discover.discoverServers()) {
    		//LOG.info("Server: {}", server);
    		
    		PlexClient pmsClient = server.getClient();
    		MediaContainer response = pmsClient.retrieveClients();
    		//LOG.info(".. Clients: {}", response);
    		
    		Client player = response.getClients().get(0);
    		LOG.info("Pausing client: {}", player.getName());

    		//player.getPlexClient().pause();
    		
    		
    	}
    }
}
