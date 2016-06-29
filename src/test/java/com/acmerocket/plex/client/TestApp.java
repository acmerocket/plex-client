package com.acmerocket.plex.client;

public class TestApp {
	static {
		// init simple logging
    	System.setProperty("org.slf4j.simpleLogger.logFile", "System.out");
    	System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
    	System.setProperty("org.slf4j.simpleLogger.log.com.acmerocket", "debug");
    	System.setProperty("org.slf4j.simpleLogger.showDateTime", "true");
    	System.setProperty("org.slf4j.simpleLogger.dateTimeFormat", "yyyy-MM-dd HH:mm:ss");
    	System.setProperty("org.slf4j.simpleLogger.showThreadName", "false");
	}
    private final static org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(TestApp.class); 

    public static void main(String[] args) throws Exception {
    	
    	Plex plex = new Plex();
    	plex.pause();
    	
//    	LOG.info("Discoving all clients...");
//    	
//    	for (Client client : Discover.clients()) {
//    		//LOG.info("Server: {}", server);
//    		
//    		//PlexClient pmsClient = server.getClient();
//    		//MediaContainer response = pmsClient.retrieveClients();
//    		LOG.info("Client: {}", client);
//    		
//    		//Client player = response.getClients().get(0);
//    		
//    		//LOG.info("Pausing client: {}", player.getName());
//    		//player.getPlexClient().pause();
//    		
//    	}
    }
}
