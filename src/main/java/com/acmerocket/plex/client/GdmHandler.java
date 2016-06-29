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

/**
 * @author philion
 *
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;


public class GdmHandler {
	public static final String MSG_RECEIVED = ".GDMService.MESSAGE_RECEIVED";
	public static final String SOCKET_CLOSED = ".GDMService.SOCKET_CLOSED";
	private static final String multicast = "239.0.0.250";

	public static void handle() {
		try {
			DatagramSocket socket = new DatagramSocket(32414);
			socket.setBroadcast(true);
			String data = "M-SEARCH * HTTP/1.1\r\n\r\n";
			DatagramPacket packet = new DatagramPacket(data.getBytes(), data.length(), InetAddress.getByName(multicast), 32414);
			
			socket.send(packet);
			//Log.d("GDMService", "Search Packet Broadcasted");

			byte[] buf = new byte[256];
			packet = new DatagramPacket(buf, buf.length);
			socket.setSoTimeout(2000);
			boolean listening = true;
			while (listening) {
				try {
					socket.receive(packet);
					String packetData = new String(packet.getData());
					if (packetData.contains("HTTP/1.0 200 OK")) {
						System.out.println(packetData);
					}
				} 
				catch (SocketTimeoutException e) {
					System.err.println(e);
					listening = false;
				}

			}
		} 
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		handle();
	}
}

