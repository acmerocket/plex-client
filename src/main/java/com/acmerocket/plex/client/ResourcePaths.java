/**
 * The MIT License (MIT)
 * Copyright (c) 2012 David Carver
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF
 * OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.acmerocket.plex.client;

import java.net.URLEncoder;


/**
 * @author dcarver
 *
 */
public class ResourcePaths {

	public static final String LIBRARY_PATH = "/library/";
	public static final String SECTIONS_PATH = LIBRARY_PATH + "sections/";
	public static final String ROOT_PATH = "/";
	
	private Configuration config;
	
	public ResourcePaths(Configuration configuration) {
		config = configuration;
	}
	
	public String getRoot() {
		return getHostPort() + ROOT_PATH;
	}
	
	public String getLibraryURL() {
		return getHostPort() + LIBRARY_PATH;
	}
	
	public String getSectionsURL() {
		return getHostPort() + SECTIONS_PATH;
	}
	
	public String getSectionsURL(String key) {
		return getHostPort() + SECTIONS_PATH + key + "/";
	}
	
	public String getSectionsURL(String key, String category) {
		return getHostPort() + SECTIONS_PATH + key + "/" + category + "/";
	}
	
	public String getSectionsURL(String key, String category, String secondaryCategory) {
		return getHostPort() + SECTIONS_PATH + key + "/" + category + "/";
	}
	
	protected String getHostPort() {
		return "http://" + config.getHost() + ":" + config.getPort();
	}
	
	public String getSeasonsURL(String key) {
		return getHostPort() + key; 
	}
	
	public String getEpisodesURL(String key) {
		return getHostPort() + key;
	}
	
	public String getMovieMetaDataURL(String key) {
		return getHostPort() + key;
	}
	
	public String getWatchedUrl(String key) {
		return getRoot() + ":/scrobble?key=" + key + "&identifier=com.plexapp.plugins.library";
	}
	
	public String getUnwatchedUrl(String key) {
		return getRoot() + ":/unscrobble?key=" + key + "&identifier=com.plexapp.plugins.library";
	}
	
	public String getProgressUrl(String key, String offset) {
		String offseturl = getRoot() + ":/progress?key=" + key + "&identifier=com.plexapp.plugins.library" + 
		        "&time=" + offset;
		return offseturl;
	}
	
	public String getMovieSearchURL(String key, String query) {
		String searchURL = getHostPort() + SECTIONS_PATH + key + "/search?type=1&query=" + query;
		return searchURL;
	}
	
	public String getTVShowSearchURL(String key, String query) {
		String searchURL = getSectionsURL(key) + "search?type=2&query=" + query;
		return searchURL;
	}
	
	public String getEpisodeSearchURL(String key, String query) {
		String searchURL = getSectionsURL(key) + "search?type=4&query=" + query;
		return searchURL;
	}
	
	public String getMediaTagURL(String resourceType, String resourceName, String identifier) {
		String encodedResourceName = resourceName;
		try {
			encodedResourceName = URLEncoder.encode(resourceName, "UTF-8");
		} catch (Exception ex) {
			
		}
		String mediaTagURL = getHostPort() + "/system/bundle/media/flags/" + resourceType + "/" + encodedResourceName + "?t=" + identifier;
		return mediaTagURL;
	}

    public String getImageURL(String url, int width, int height) {
    	String u = url;
    	String host = config.getHost();
    	if (u.contains(config.getHost())) {
    		u = u.replaceFirst(host, "127.0.0.1");
    	}
    	String encodedUrl = u;
    	try {
    		encodedUrl = URLEncoder.encode(u, "UTF-8");
    	} catch (Exception ex) {
    		// If there is an exception encoding the url just return the original url
    		return url;
    	}
        return getHostPort() + "/photo/:/transcode?url=" + encodedUrl + "&width=" + width + "&height=" + height;
    }
    
    public String getClientsUrl() {
        return this.getRoot() + "clients";
    }
}
