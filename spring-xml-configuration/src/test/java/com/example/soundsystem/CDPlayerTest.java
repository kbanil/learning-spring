package com.example.soundsystem;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by anil on 3/7/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cd-config.xml")
public class CDPlayerTest {

    @Autowired
    @Qualifier("sgtPeppers")
    private CompactDisc compactDisc;

    @Autowired
    private MediaPlayer cdPlayer;

    @Autowired
    @Qualifier("blankDisc")
    private CompactDisc blankDisc;

    @Autowired
    @Qualifier("anotherBlankDisc")
    private CompactDisc anotherBlankDisc;

    @Test
    public void testCompactDiscIsNotNull() throws Exception {
        assertNotNull(compactDisc);
    }

    @Test
    public void testCDPlayerNotNull() throws Exception {
        assertNotNull(cdPlayer);
    }

    @Test
    public void testBlankDiscNotNull() throws Exception {
        assertNotNull(blankDisc);
    }

    @Test
    public void testBlankDiscProperties() throws Exception {
        BlankDisc bd = (BlankDisc) blankDisc;
        assertNotNull(bd.getArtist());
        assertNotNull(bd.getTitle());
        assertNotNull(bd.getTracks());
    }

    @Test
    public void testBlankDiscWithCNamespace() throws Exception {
        BlankDisc abd = (BlankDisc) anotherBlankDisc;
        assertNotNull(abd);
        assertNotNull(abd.getTitle());
        assertNotNull(abd.getArtist());
        assertNotNull(abd.getTracks());
    }
}
