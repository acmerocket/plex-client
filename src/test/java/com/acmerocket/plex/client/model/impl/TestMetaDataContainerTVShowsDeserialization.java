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

package com.acmerocket.plex.client.model.impl;

import java.io.InputStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.acmerocket.plex.client.model.Directory;
import com.acmerocket.plex.client.model.Genre;
import com.acmerocket.plex.client.model.MediaContainer;

import static org.junit.Assert.*;

/**
 * @author dcarver
 *
 */
public class TestMetaDataContainerTVShowsDeserialization {
	
	private Serializer serializer;
	
	@Before
	public void setUp() throws Exception {
		serializer = new Persister();
	}
	
	@After
	public void tearDown() throws Exception {
		serializer = null;
	}
	
	@Test
	public void testSimpleDeserialization() throws Exception {
		InputStream file = this.getClass().getResourceAsStream("/library/sections/6/all/index.xml");
		MediaContainer mediaContainer = serializer.read(MediaContainer.class, file, false);
		assertEquals(6, mediaContainer.getSize());
	}
	
	@Test
	public void testDirectoryTVShow() throws Exception {
		InputStream file = this.getClass().getResourceAsStream("/library/sections/6/all/index.xml");
		MediaContainer mediaContainer = serializer.read(MediaContainer.class, file, false);
		List<Directory> directories = mediaContainer.getDirectories();
		assertEquals(6, directories.size());
		
		Directory tvShow = directories.get(0);
		assertEquals("TV-MA", tvShow.getContentRating());
		assertEquals("2001", tvShow.getYear());
		assertEquals("show", tvShow.getType());
		
	}
	
	@Test
	public void testTVShowGenre() throws Exception {
		InputStream file = this.getClass().getResourceAsStream("/library/sections/6/all/index.xml");
		MediaContainer mediaContainer = serializer.read(MediaContainer.class, file, false);
		List<Directory> directories = mediaContainer.getDirectories();		
		Directory tvShow = directories.get(0);
		List<Genre> genres = tvShow.getGenres();
		assertEquals(2, genres.size());
		Genre genre = genres.get(0);
		assertEquals("Action and Adventure", genre.getTag());
	}
	
	
}
