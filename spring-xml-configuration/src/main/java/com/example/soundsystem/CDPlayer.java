package com.example.soundsystem;

/**
 * Created by anil on 3/7/17.
 */
public class CDPlayer implements MediaPlayer {

    public CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    private CompactDisc compactDisc;

    public void play() {
        compactDisc.play();
    }
}
