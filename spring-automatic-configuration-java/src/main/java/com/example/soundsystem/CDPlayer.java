package com.example.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by anil on 3/6/17.
 */
@Component
/*
@ComponentScan works even from here, i.e a simple bean
It need not be necessarily used on a @Configuration
Although using it on @Configuration makes the code much more easy to understand
 */
@ComponentScan(basePackages = "com.example.somepackage")
public class CDPlayer implements MediaPlayer{
    private CompactDisc compactDisc;

    @Autowired
    public CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }


    public void play() {
        compactDisc.play();
    }
}
