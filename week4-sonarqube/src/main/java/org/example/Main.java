package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        int result = addMe(12, 4);
        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format("Result of addMe(12, 4): %d", result));
        }
    }

    public static int addMe(int a, int b) {
        return a + b;
    }
}
