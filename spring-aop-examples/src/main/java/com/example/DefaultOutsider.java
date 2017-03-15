package com.example;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by anil on 3/10/17.
 */
public class DefaultOutsider implements Outsider {
    private static final Logger LOGGER = Logger.getLogger(DefaultOutsider.class.getName());
    public void announce() {
        LOGGER.log(Level.INFO, "I am in com.example package");
    }
}
