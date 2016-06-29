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

package com.acmerocket.plex.client.model;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="MediaContainer")
public class MediaContainer {

	@Attribute(required=false)
	private int size;
	
	@Attribute(required=false)
	private int allowSync;
	
	@Attribute(required=false)
	private String art;
	
	@Attribute(required=false)
	private String identifier;
	
	@Attribute(required=false)
	private String mediaTagPrefix;
	
	@Attribute(required=false)
	private long mediaTagVersion;
	
	@Attribute(required=false)
	private String title1;
	
	@Attribute(required=false)
	private String title2;
	
	@ElementList(inline=true,required=false)
	private List<Client> clients;
	
	public String getTitle2() {
		return title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	@Attribute(required=false)
	private int sortAsc;
	
	@Attribute(required=false)
	private String content;
	
	@Attribute(required=false)
	private String viewGroup;
	
	@Attribute(required=false)
	private int viewMode;
	
	@Attribute(name="thumb",required=false)
	private String parentPosterURL;
	
	@Attribute(name="parentIndex",required=false)
	private String parentIndex;
	
	@ElementList(inline=true,required=false)
	private List<Directory> directories;
	
	@ElementList(inline=true,required=false)
	private List<Video> videos;
	
	@ElementList(inline=true,required=false)
	private List<Track> tracks;
	
	
	public List<Directory> getDirectories() {
		return directories;
	}

	public void setDirectories(List<Directory> directory) {
		this.directories = directory;
	}
	

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getAllowSync() {
		return allowSync;
	}

	public void setAllowSync(int allowSync) {
		this.allowSync = allowSync;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getMediaTagPrefix() {
		return mediaTagPrefix;
	}

	public void setMediaTagPrefix(String mediaTagPrefix) {
		this.mediaTagPrefix = mediaTagPrefix;
	}

	public long getMediaTagVersion() {
		return mediaTagVersion;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public int getSortAsc() {
		return sortAsc;
	}

	public void setSortAsc(int sortAsc) {
		this.sortAsc = sortAsc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getViewGroup() {
		return viewGroup;
	}

	public void setViewGroup(String viewGroup) {
		this.viewGroup = viewGroup;
	}

	public int getViewMode() {
		return viewMode;
	}

	public void setViewMode(int viewMode) {
		this.viewMode = viewMode;
	}

	public void setMediaTagVersion(long mediaTagVersion) {
		this.mediaTagVersion = mediaTagVersion;
	}

	public void setMediaTagVersion(int mediaTagVersion) {
		this.mediaTagVersion = mediaTagVersion;
	}

	public String getTitle1() {
		return title1;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	/**
	 * @return the videos
	 */
	public List<Video> getVideos() {
		return videos;
	}

	/**
	 * @param videos the videos to set
	 */
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public String getParentPosterURL() {
		return parentPosterURL;
	}

	public void setParentPosterURL(String parentPosterURL) {
		this.parentPosterURL = parentPosterURL;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	/**
	 * Contains information like Season information for episodes
	 * This needs to be checked if the video elements parentIndex
	 * doesn't exist.
	 * 
	 * @return
	 */
	public String getParentIndex() {
		return parentIndex;
	}

	/**
	 * Set the parentIndex (i.e. Season number).
	 * @param parentIndex
	 */
	public void setParentIndex(String parentIndex) {
		this.parentIndex = parentIndex;
	}

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final int maxLen = 10;
        return "MediaContainer [size=" + this.size + ", allowSync=" + this.allowSync + ", " + (this.art != null ? "art=" + this.art + ", " : "")
                + (this.identifier != null ? "identifier=" + this.identifier + ", " : "")
                + (this.mediaTagPrefix != null ? "mediaTagPrefix=" + this.mediaTagPrefix + ", " : "") + "mediaTagVersion=" + this.mediaTagVersion + ", "
                + (this.title1 != null ? "title1=" + this.title1 + ", " : "") + (this.title2 != null ? "title2=" + this.title2 + ", " : "")
                + (this.clients != null ? "clients=" + this.clients.subList(0, Math.min(this.clients.size(), maxLen)) + ", " : "") + "sortAsc=" + this.sortAsc
                + ", " + (this.content != null ? "content=" + this.content + ", " : "") + (this.viewGroup != null ? "viewGroup=" + this.viewGroup + ", " : "")
                + "viewMode=" + this.viewMode + ", " + (this.parentPosterURL != null ? "parentPosterURL=" + this.parentPosterURL + ", " : "")
                + (this.parentIndex != null ? "parentIndex=" + this.parentIndex + ", " : "")
                + (this.directories != null ? "directories=" + this.directories.subList(0, Math.min(this.directories.size(), maxLen)) + ", " : "")
                + (this.videos != null ? "videos=" + this.videos.subList(0, Math.min(this.videos.size(), maxLen)) + ", " : "")
                + (this.tracks != null ? "tracks=" + this.tracks.subList(0, Math.min(this.tracks.size(), maxLen)) : "") + "]";
    }

    /**
     * @return the clients
     */
    public List<Client> getClients() {
        return this.clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

}
