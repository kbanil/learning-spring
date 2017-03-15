package com.example.soundsystem;

import static org.junit.Assert.*;

import com.example.somepackage.SomeBean;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by anil on 3/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CDPlayerTest {
    @Autowired
    private MediaPlayer mediaPlayer;

    @Autowired
    private SomeBean someBean;

    @Rule
    public StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testMediaPlayerNotNull() {
        assertNotNull(mediaPlayer);
    }

    @Test
    public void testPlay() throws Exception {
        mediaPlayer.play();
        assertEquals("Playing Sgt Peppers by The Beatles\n", log.getLog());
    }

    @Test
    public void testSomeBean() throws Exception {

        assertNotNull(someBean);
    }
}
