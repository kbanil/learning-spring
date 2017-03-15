package com.example.soundsystem;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by anil on 3/10/17.
 */
@Aspect
public class TrackCounter {
    private static final Logger logger = Logger.getLogger(TrackCounter.class.getName());
    private Map<Integer, Integer> trackCounter = new HashMap<Integer, Integer>();

    @Pointcut("execution(* com.example.soundsystem.*.playTrack(..)) " +
            " && args(trackNumber)")
    public void playTrack(int trackNumber) {

    }

    @Before("playTrack(trackNumber)")
    public void countPlayTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounter.put(trackNumber, currentCount + 1);
//        logger.log(Level.INFO, "Track Number #: " + trackNumber + " played " + (currentCount + 1) + " times");
    }

    public int getPlayCount(int trackNumber) {
        return trackCounter.containsKey(trackNumber)
                ? trackCounter.get(trackNumber) : 0;
    }
}
