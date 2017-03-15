package com.example.concert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by anil on 3/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class ConcertTest {

    @Rule
    public StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Autowired
    @Qualifier("goodStagePerformance")
    private Performance goodStagePerformance;

    @Autowired
    @Qualifier("badStagePerformance")
    private Performance badStagePerformance;

    @Autowired
    @Qualifier("outsidePerformance")
    private Performance outsidePerformance;

    @Test
    public void testGoodStagePerformance() throws Exception {
        goodStagePerformance.perform();
        assertEquals("Opening doors\n" +
                "Silencing phones\n" +
                "Taking seats\n" +
                "Good stage performance\n" +
                "Clap clap\n", log.getLog());
    }

    @Test
    public void testBadStagePerformance() throws Exception {
        exception.expect(RuntimeException.class);
        try {
            badStagePerformance.perform();
        } catch (Exception e) {
            assertEquals("Opening doors\n" +
                    "Silencing phones\n" +
                    "Taking seats\n" +
                    "Bad stage performance\n" +
                    "Give me my money back\n", log.getLog());
            throw e;
        }

    }

    @Test
    public void testOutsidePerformance() throws Exception {
        outsidePerformance.perform();
        assertEquals("Opening doors\n" +
                "Silencing phones\n" +
                "Taking seats\n" +
                "Outside performance\n" +
                "Clap clap\n", log.getLog());
    }
}
