package org.example;

public class FuelCalculator {

    public CalculationRecord calculate(double distance, double consumption, double price) {
        if (distance <= 0 || consumption <= 0 || price <= 0) {
            throw new IllegalArgumentException("Distance, consumption and price must all be positive.");
        }
        double totalFuel = (consumption / 100.0) * distance;
        double totalCost = totalFuel * price;
        return new CalculationRecord(distance, consumption, price, totalFuel, totalCost);
    }
}
