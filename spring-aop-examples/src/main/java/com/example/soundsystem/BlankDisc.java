package com.example.soundsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by anil on 3/10/17.
 */
public class BlankDisc implements CompactDisc {
    private static final Logger logger = Logger.getLogger(BlankDisc.class.getName());

    private String title;
    private String artist;
    private List<String> tracks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public void playAll() {
        for(int i=0; i<tracks.size(); i++) {
            playTrack(i + 1);
        }
    }

    public void playTrack(int trackNumber) {
        logger.log(Level.INFO, "Playing " + tracks.get(trackNumber - 1) + " by " + getArtist());
    }
}
