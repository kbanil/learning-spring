package com.example.soundsystem;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by anil on 3/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoundSystemConfig.class)
public class TrackCounterTest {

    @Autowired
    private CompactDisc sgtPeppers;

    @Autowired
    private TrackCounter trackCounter;

    @Test
    public void testCounter() throws Exception {
        sgtPeppers.playTrack(1);
        sgtPeppers.playTrack(2);
        sgtPeppers.playTrack(3);
        sgtPeppers.playTrack(3);
        sgtPeppers.playTrack(3);
        sgtPeppers.playTrack(2);
        sgtPeppers.playTrack(1);
        sgtPeppers.playTrack(1);

        Assert.assertEquals(3,trackCounter.getPlayCount(1));
        Assert.assertEquals(2,trackCounter.getPlayCount(2));
        Assert.assertEquals(3,trackCounter.getPlayCount(3));
        Assert.assertEquals(0,trackCounter.getPlayCount(4));
    }
}
