package com.example.soundsystem;

/**
 * Created by anil on 3/7/17.
 */
public class SgtPeppers implements CompactDisc {
    private final String title = "Sgt Peppers";
    private final String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
