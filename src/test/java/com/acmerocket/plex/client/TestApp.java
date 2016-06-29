package com.acmerocket.plex.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.acmerocket.plex.client.model.MediaContainer;

public class TestApp {
    private final static Logger LOGGER = Logger.getLogger(TestApp.class.getName()); 

    public static void main(String[] args) throws Exception {
        LOGGER.getParent().setLevel(Level.FINEST);
        String plexServer = args[0]; // silly, meaningless exceptions
        int plexPort = Configuration.DEFAULT_PORT;
        if (args.length > 1) {
            plexPort = Integer.parseInt(args[1]);
        }
        
        Configuration config = //new Configuration(plexServer, plexPort);
                new Configuration("192.168.1.107", 32500);
        PlexClient client = new PlexClient(config);
        
        client.pause();
        
        MediaContainer response = //client.retrieveSections();
                //client.retrieveSections("11/all");
                client.retrieveClients();
        
        LOGGER.log(Level.INFO, "Media: " + response);
        
    }
}
