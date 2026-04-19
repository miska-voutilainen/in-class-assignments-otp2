package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        FuelCalculator calculator = new FuelCalculator();
        CalculationRecord result = calculator.calculate(500, 7.5, 1.85);
        if (logger.isLoggable(Level.INFO)) {
            logger.info("=== Fuel Calculator | Miska Voutilainen ===");
            logger.info(result.toString());
            logger.info(String.format(
                "Distance: %.1f km | Fuel used: %.2f L | Total cost: %.2f EUR",
                result.getDistance(), result.getTotalFuel(), result.getTotalCost()
            ));
        }
    }

    public static int addMe(int a, int b) {
        return a + b;
    }
}
