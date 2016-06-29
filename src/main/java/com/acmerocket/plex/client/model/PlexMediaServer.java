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
package com.acmerocket.plex.client.model;

import java.util.Date;

import com.acmerocket.plex.client.Configuration;
import com.acmerocket.plex.client.PlexClient;

/**
 * @author philion
 *
 */
public class PlexMediaServer {

	private String host;
	private String name;
	private int port;
	private String resourceId;
	private Date updatedAt;
	private String version;
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public String getResourceId() {
		return resourceId;
	}
	
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "PlexMediaServer [" + (host != null ? "host=" + host + ", " : "")
				+ (name != null ? "name=" + name + ", " : "") + "port=" + port + ", "
				+ (resourceId != null ? "resourceId=" + resourceId + ", " : "")
				+ (updatedAt != null ? "updatedAt=" + updatedAt + ", " : "")
				+ (version != null ? "version=" + version : "") + "]";
	}
	
	public PlexClient plexClient() {
		return new PlexClient(new Configuration(this.name, this.port, this.resourceId));
	}
}

/* 
 * HTTP/1.0 200 OK
 * Content-Type: plex/media-server
Host: c01fdbbe60544af7af0d032a6cd62ee2.plex.direct
Name: mercury
Port: 32400
Resource-Identifier: e239e59fb3005da6199c853f9af9307e96e59edd
Updated-At: 1467168737
Version: 1.0.0.2261-a17e99e
*/
