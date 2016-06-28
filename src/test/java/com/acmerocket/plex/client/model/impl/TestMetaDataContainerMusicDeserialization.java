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

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.acmerocket.plex.client.model.MediaContainer;

/**
 * @author dcarver
 *
 */
public class TestMetaDataContainerMusicDeserialization {
	
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
		InputStream file = this.getClass().getResourceAsStream("/library/sections/3/all/index.xml");
		MediaContainer mediaContainer = serializer.read(MediaContainer.class, file, false);
		assertEquals(4, mediaContainer.getSize());
	}
}
