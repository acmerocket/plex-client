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

/**
 * @author philion
 *
 */
public class Session {

}

/*
<MediaContainer size="1">
  <Track addedAt="1247184624" art="/library/metadata/84115/art/1437562316" chapterSource="" duration="228052" grandparentArt="/library/metadata/84115/art/1437562316" grandparentKey="/library/metadata/84115" grandparentRatingKey="84115" grandparentThumb="/library/metadata/84115/thumb/1437562316" grandparentTitle="Colin Hay" guid="local://84116/2" index="2" key="/library/metadata/84117" lastViewedAt="1467053060" librarySectionID="12" parentIndex="1" parentKey="/library/metadata/84116" parentRatingKey="84116" parentTitle="Scrubs Season 2" ratingKey="84117" sessionKey="41" summary="" title="Overkill" type="track" updatedAt="1431108264" userRating="8.0" viewCount="154" viewOffset="205717">
    <Media audioChannels="2" audioCodec="mp3" bitrate="128" container="mp3" duration="228052" id="75151">
      <Part container="mp3" duration="228052" file="/Volumes/Media/iTunes/Music/Colin Hay/Scrubs Season 2/02 Overkill.mp3" id="76463" key="/library/parts/76463/1298833106/file.mp3" size="3649536">
        <Stream audioChannelLayout="stereo" bitrate="128" bitrateMode="cbr" channels="2" codec="mp3" duration="228048" id="158453" index="0" samplingRate="44100" selected="1" streamType="2"/>
      </Part>
    </Media>
    <User id="1" thumb="https://plex.tv/users/bd524f47c92187f2/avatar" title="philion"/>
    <Player address="::ffff:192.168.1.29" device="RaspberryPi" machineIdentifier="fda839cf-c8f7-4bd9-98bc-0b4f037c163d" model="RaspberryPi" platform="Plex Home Theater" platformVersion="" product="Plex Home Theater" profile="Raspberry PI" state="playing" title="RasPlex" vendor="" version="1.6.2.123-e23a7eef"/>
  </Track>

<MediaContainer size="1">
  <Video addedAt="1459215487" art="/library/metadata/111448/art/1459215779" audienceRating="9.0" audienceRatingImage="rottentomatoes://image.rating.upright" chapterSource="mixed" contentRating="PG-13" duration="8286703" guid="com.plexapp.agents.imdb://tt2488496?lang=en" key="/library/metadata/111448" lastViewedAt="1467215429" librarySectionID="10" originallyAvailableAt="2015-12-14" primaryExtraKey="/library/metadata/111483" rating="9.2" ratingImage="rottentomatoes://image.rating.certified" ratingKey="111448" sessionKey="45" studio="Lucasfilm" summary="Thirty years after defeating the Galactic Empire, Han Solo and his allies face a new threat from the evil Kylo Ren and his army of Stormtroopers." tagline="Every generation has a story." thumb="/library/metadata/111448/thumb/1459215779" title="Star Wars: Episode VII - The Force Awakens" type="movie" updatedAt="1459215779" viewCount="1" viewOffset="6577491" year="2015">
    <Media aspectRatio="2.35" audioChannels="6" audioCodec="dca" audioProfile="dts" bitrate="3607" container="mkv" duration="8286703" height="800" id="117336" videoCodec="h264" videoFrameRate="24p" videoProfile="high" videoResolution="1080" width="1920">
      <Part audioProfile="dts" container="mkv" duration="8286703" file="/Volumes/Media/Movies/Star Wars Episode VII The Force Awakens (2015)/Star Wars Episode VII The Force Awakens (2015).mkv" id="118781" key="/library/parts/118781/1459214799/file.mkv" size="3735920155" videoProfile="high">
        <Stream bitDepth="8" bitrate="2850" cabac="1" chromaSubsampling="4:2:0" codec="h264" codecID="V_MPEG4/ISO/AVC" default="1" duration="8286703" frameRate="23.976" frameRateMode="cfr" hasScalingMatrix="0" height="800" id="229931" index="0" language="English" languageCode="eng" level="41" pixelFormat="yuv420p" profile="high" refFrames="5" scanType="progressive" streamType="1" width="1920"/>
        <Stream audioChannelLayout="5.1(side)" bitDepth="24" bitrate="755" bitrateMode="cbr" channels="6" codec="dca" codecID="A_DTS" default="1" duration="8286699" id="229932" index="1" language="English" languageCode="eng" profile="dts" samplingRate="48000" selected="1" streamType="2"/>
        <Stream codec="srt" format="" id="229930" key="/library/streams/229930" language="English" languageCode="eng" streamType="3"/>
      </Part>
    </Media>
    <Genre count="9" id="19438" tag="Sci-Fi"/>
    <Genre count="48" id="51" tag="Adventure"/>
    <Genre count="52" id="49" tag="Action"/>
    <Genre count="253" id="193" tag="Fantasy"/>
    <Writer count="3" id="8247" tag="J.J. Abrams"/>
    <Writer count="6" id="2934" tag="Lawrence Kasdan"/>
    <Writer count="5" id="5551" tag="Michael Arndt"/>
    <Director count="5" id="5111" tag="J.J. Abrams"/>
    <Producer count="5" id="12407" tag="Bryan Burk"/>
    <Producer count="8" id="12406" tag="J.J. Abrams"/>
    <Producer count="9" id="12608" tag="Kathleen Kennedy"/>
    <Country count="1101" id="29" tag="USA"/>
    <Role count="2" id="42639" role="Rey" tag="Daisy Ridley"/>
    <Role count="2" id="8269" role="Finn" tag="John Boyega"/>
    <Role count="9" id="864" role="Poe Dameron" tag="Oscar Isaac"/>
    <Role count="7" id="5704" role="General Hux" tag="Domhnall Gleeson"/>
    <Role count="3" id="29842" role="Kylo Ren" tag="Adam Driver"/>
    <Role count="16" id="795" role="Han Solo" tag="Harrison Ford"/>
    <Role count="6" id="3959" role="Luke Skywalker" tag="Mark Hamill"/>
    <Role count="9" id="838" role="Princess Leia" tag="Carrie Fisher"/>
    <Role id="61352" role="Maz Kanata" tag="Lupita Nyong'o"/>
    <Role count="14" id="2903" role="Supreme Leader Snoke" tag="Andy Serkis"/>
    <Collection count="7" id="8303" tag="Star Wars"/>
    <User id="1" thumb="https://plex.tv/users/bd524f47c92187f2/avatar" title="philion"/>
    <Player address="::ffff:192.168.1.29" device="RaspberryPi" machineIdentifier="fda839cf-c8f7-4bd9-98bc-0b4f037c163d" model="RaspberryPi" platform="Plex Home Theater" platformVersion="" product="Plex Home Theater" profile="Raspberry PI" state="playing" title="RasPlex" vendor="" version="1.6.2.123-e23a7eef"/>
  </Video>
</MediaContainer>                                                                                                                                                                                                                                                Wed Jun 29 09:03
*/
