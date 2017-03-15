package com.example.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anil on 3/10/17.
 */
@Configuration
@EnableAspectJAutoProxy
public class SoundSystemConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        BlankDisc disc = new BlankDisc();
        disc.setArtist("The Beatles");
        disc.setTitle("Sgt Peppers");
        List<String> tracks = new ArrayList<String>();
        tracks.add("Track 1");
        tracks.add("Track 2");
        tracks.add("Track 3");
        tracks.add("Track 4");
        disc.setTracks(tracks);
        return disc;
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
