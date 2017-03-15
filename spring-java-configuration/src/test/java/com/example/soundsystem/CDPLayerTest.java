package com.example.soundsystem;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by anil on 3/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPLayerTest {

    @Rule
    public StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private MediaPlayer mediaPlayer;

    @Test
    public void testCDPlayerIsNotNull() throws Exception {
        assertNotNull(mediaPlayer);
    }
}
