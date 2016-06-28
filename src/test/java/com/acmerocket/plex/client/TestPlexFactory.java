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

import java.io.File;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.acmerocket.plex.client.PlexappFactory;
import com.acmerocket.plex.client.model.Directory;
import com.acmerocket.plex.client.model.MediaContainer;
import com.acmerocket.plex.client.model.Track;
import com.acmerocket.plex.client.utils.NanoHTTPD;

import static org.junit.Assert.*;


/**
 * @author dcarver
 *
 */
public class TestPlexFactory {
	
	NanoHTTPD server = null;
	Configuration config = null;
	
	@Before
	public void setUp() throws Exception {
		config = new Configuration("localhost");
		URL url = this.getClass().getResource("/");
		File rootfile = new File(url.getPath());
		server = new NanoHTTPD(config.getPort(), rootfile);
	}
	
	@After
	public void tearDown() throws Exception {
		server.stop();
	}
	
	@Test
	public void testRetrieveLibrary() throws Exception {
		PlexappFactory factory = PlexappFactory.getInstance(config);
		MediaContainer mediaContainer = factory.retrieveLibrary();
		assertNotNull(mediaContainer);
		assertEquals(3, mediaContainer.getSize());
		assertEquals(3, mediaContainer.getDirectories().size());
	}
	
	@Test
	public void testRetrieveRoot() throws Exception {
		PlexappFactory factory = PlexappFactory.getInstance(config);
		MediaContainer mediaContainer = factory.retrieveRootData();
		assertNotNull(mediaContainer);
		assertEquals(10, mediaContainer.getSize());
	}
	
	@Test
	public void testRetrieveSections() throws Exception {
		PlexappFactory factory = PlexappFactory.getInstance(config);
		MediaContainer mediaContainer = factory.retrieveSections();
		assertNotNull(mediaContainer);
		assertEquals(2, mediaContainer.getSize());
	}
	
	@Test
	public void testRetrieveSectionByKeyMissing() throws Exception {
		PlexappFactory factory = PlexappFactory.getInstance(config);
		try {
			factory.retrieveSections("5");
			fail("Should not get to this point");
		} catch (Exception ex) {
			
		}		
	}
	
	@Test
	public void testRetrieveSectionByKeyMovies() throws Exception {
		PlexappFactory factory = PlexappFactory.getInstance(config);
		MediaContainer mediaContainer = factory.retrieveSections("4");
		assertNotNull(mediaContainer);
		assertEquals(19, mediaContainer.getSize());
	}
	
	@Test
	public void testRetrieveSectionByKeyTVShows() throws Exception {
		PlexappFactory factory = PlexappFactory.getInstance(config);
		MediaContainer mediaContainer = factory.retrieveSections("6");
		assertNotNull(mediaContainer);
		assertEquals(15, mediaContainer.getSize());
	}
	
	@Test
	public void testRetrieveSectionByKeyMusic() throws Exception {
		PlexappFactory factory = PlexappFactory.getInstance(config);
		MediaContainer mediaContainer = factory.retrieveSections("3");
		assertNotNull(mediaContainer);
		assertEquals(11, mediaContainer.getSize());
	}
	
	
	@Test
	public void testRetrieveAllTVShows() throws Exception {
		PlexappFactory factory = PlexappFactory.getInstance(config);
		MediaContainer mediaContainer = factory.retrieveSections("6", "all");
		List<Directory> directories = mediaContainer.getDirectories();
		assertEquals(6, directories.size());
	}
	
	@Test
	public void testRetrieveAllMusic() throws Exception {
		PlexappFactory factory = PlexappFactory.getInstance(config);
		MediaContainer mediaContainer = factory.retrieveSections("3", "all");
		List<Directory> directories = mediaContainer.getDirectories();
		assertEquals(4, directories.size());
	}
	
	
	@Test
	public void testRetrieveSeasonsForTVShow() throws Exception {
		PlexappFactory factory = PlexappFactory.getInstance(config);
		MediaContainer mediaContainer = factory.retrieveSeasons("/library/metadata/209/children/");
		assertEquals(5, mediaContainer.getSize());
	}
	
	@Test
	public void testRetrieveMusicMetaData() throws Exception {
		PlexappFactory factory = PlexappFactory.getInstance(config);
		MediaContainer mediaContainer = factory.retrieveSeasons("/library/metadata/101/children/");
		assertEquals(1, mediaContainer.getSize());
	}
	
	@Test
	public void testRetrieveMusicTrackMetaData() throws Exception {
		PlexappFactory factory = PlexappFactory.getInstance(config);
		MediaContainer mediaContainer = factory.retrieveSeasons("/library/metadata/102/children/");
		assertEquals(21, mediaContainer.getSize());
		assertNotNull(mediaContainer.getTracks());
		Track track = mediaContainer.getTracks().get(0);
		assertNotNull(track);
		assertEquals("Arabian Nights", track.getTitle());
	}

	@Test
	public void testRetrieveSeasonsForTVShowBackgroundArt() throws Exception {
		PlexappFactory factory = PlexappFactory.getInstance(config);
		MediaContainer mediaContainer = factory.retrieveSeasons("/library/metadata/209/children/");
		assertEquals("/library/metadata/209/art/1354460830",mediaContainer.getArt());
	}
}
