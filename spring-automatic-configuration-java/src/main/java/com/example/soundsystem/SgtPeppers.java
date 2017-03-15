package com.example.soundsystem;

import org.springframework.stereotype.Component;

/**
 * Created by anil on 3/5/17.
 */
@Component
public class SgtPeppers implements CompactDisc {
    private final String title ="Sgt Peppers";
    private final String artist = "The Beatles";
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
