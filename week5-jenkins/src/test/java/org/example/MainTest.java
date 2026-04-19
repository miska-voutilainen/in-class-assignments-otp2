package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testAddMe() {
        assertEquals(16, Main.addMe(12, 4));
    }

    @Test
    void testAddMeNegative() {
        assertEquals(-1, Main.addMe(-3, 2));
    }

    @Test
    void testCalculateFuel() {
        FuelCalculator calculator = new FuelCalculator();
        CalculationRecord result = calculator.calculate(100, 10, 2.0);
        assertEquals(10.0, result.getTotalFuel(), 0.001);
        assertEquals(20.0, result.getTotalCost(), 0.001);
    }

    @Test
    void testCalculateRecordFields() {
        FuelCalculator calculator = new FuelCalculator();
        CalculationRecord result = calculator.calculate(500, 7.5, 1.85);
        assertEquals(500, result.getDistance(), 0.001);
        assertEquals(7.5, result.getConsumption(), 0.001);
        assertEquals(1.85, result.getPrice(), 0.001);
        assertEquals(37.5, result.getTotalFuel(), 0.001);
        assertEquals(69.375, result.getTotalCost(), 0.001);
    }

    @Test
    void testCalculateZeroDistanceThrows() {
        FuelCalculator calculator = new FuelCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(0, 7.5, 1.85));
    }

    @Test
    void testCalculateNegativeConsumptionThrows() {
        FuelCalculator calculator = new FuelCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(100, -1, 1.85));
    }

    @Test
    void testCalculateNegativePriceThrows() {
        FuelCalculator calculator = new FuelCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(100, 7.5, -1));
    }

    @Test
    void testAddMeZero() {
        assertEquals(0, Main.addMe(0, 0));
    }

    @Test
    void testMainMethodRuns() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }

    @Test
    void testCalculateNegativeDistanceThrows() {
        FuelCalculator calculator = new FuelCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(-50, 7.5, 1.85));
    }

    @Test
    void testCalculateZeroConsumptionThrows() {
        FuelCalculator calculator = new FuelCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(100, 0, 1.85));
    }

    @Test
    void testCalculateZeroPriceThrows() {
        FuelCalculator calculator = new FuelCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(100, 7.5, 0));
    }

    @Test
    void testCalculationRecordToString() {
        CalculationRecord record = new CalculationRecord(100, 10, 2.0, 10.0, 20.0);
        String result = record.toString();
        assertTrue(result.contains("100.0 km"));
        assertTrue(result.contains("10.0 L/100km"));
        assertTrue(result.contains("2.00 EUR/L"));
        assertTrue(result.contains("10.00 L"));
        assertTrue(result.contains("20.00 EUR"));
    }

    @Test
    void testSmallDistance() {
        FuelCalculator calculator = new FuelCalculator();
        CalculationRecord result = calculator.calculate(1, 5, 1.5);
        assertEquals(0.05, result.getTotalFuel(), 0.001);
        assertEquals(0.075, result.getTotalCost(), 0.001);
    }
}
