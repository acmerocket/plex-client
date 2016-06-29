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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acmerocket.plex.client.model.PlexMediaServer;

public class GdmHandler {
	private static final Logger LOG = LoggerFactory.getLogger(GdmHandler.class);
	
	public static final String MSG_RECEIVED = ".GDMService.MESSAGE_RECEIVED";
	public static final String SOCKET_CLOSED = ".GDMService.SOCKET_CLOSED";
	private static final String multicast = "239.0.0.250";

	public static List<PlexMediaServer> getServers() {
		List<PlexMediaServer> servers = new ArrayList<>();
		
		try (
				DatagramSocket socket = new DatagramSocket(32414);
			){
			socket.setBroadcast(true);
			String data = "M-SEARCH * HTTP/1.1\r\n\r\n";
			DatagramPacket packet = new DatagramPacket(data.getBytes(), data.length(), InetAddress.getByName(multicast), 32414);
			
			socket.send(packet);

			byte[] buf = new byte[512];
			packet = new DatagramPacket(buf, buf.length);
			socket.setSoTimeout(1000);
			boolean listening = true;
			while (listening) {
				try {
					socket.receive(packet);
					String packetData = new String(packet.getData());
					if (packetData.contains("HTTP/1.0 200 OK")) {
						servers.add(parseGdmResponse(packetData));
					}
				} 
				catch (SocketTimeoutException e) {
					//System.err.println(e);
					listening = false;
				}
			}
		} 
		catch (IOException e) {
			System.err.println(e);
		}
		
		return servers;
	}
	
	private static PlexMediaServer parseGdmResponse(String packet) {
		LOG.debug("Parsing: {}", packet);
		PlexMediaServer server = new PlexMediaServer();
		
		try {
			BufferedReader in = new BufferedReader(new StringReader(packet));
			String line = null;
			while ((line = in.readLine()) != null) {
				String[] args = line.split(":");
				if (args.length == 2) {
					String key = args[0].trim();
					String value = args[1].trim();
					
					switch (key) {
						case "Host": server.setHost(value); break;
						case "Name": server.setName(value); break;
						case "Port": server.setPort(Integer.parseInt(value)); break;
						case "Resource-Identifier": server.setResourceId(value); break;
						case "Updated-At": server.setUpdatedAt(new Date(Long.parseLong(value))); break;
						case "Version": server.setVersion(value); break;
					}
					
					//LOG.info("{}={}, server: {}", key, value, server);
				}
			}
		} 
		catch (IOException e) {
			LOG.error("Error parsing", e);
			LOG.debug("Error packet: {}", packet);
		}
		
		return server;
	}
	
	public static void main(String[] args) {
		LOG.info("Servers: {}", GdmHandler.getServers());
	}
}

