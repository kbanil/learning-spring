package com.example.soundsystem;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by anil on 3/5/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CompactDiscTest {

    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void testCompactDiscIsNotNull() {
        assertNotNull(compactDisc);
    }
}
