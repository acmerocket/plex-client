package com.acmerocket.plex.client;

public class TestApp {

    public static void main(String[] args) {
        String plexServer = args[0]; // silly, meaningless exceptions
        int plexPort = Configuration.DEFAULT_PORT;
        if (args.length > 1) {
            plexPort = Integer.parseInt(args[1]);
        }
        
        Configuration config = new Configuration(plexServer, plexPort);
        PlexappFactory.getInstance(config).getSectionsURL();
    }
}
