package com.example.soundsystem;

/**
 * Created by anil on 3/6/17.
 */
public class CDPlayer implements MediaPlayer {
    private CompactDisc compactDisc;

    public CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public void play() {
        compactDisc.play();
    }
}
