package shopping;

import java.util.ArrayList;
import java.util.List;

public class CartCalculator {

    private List<Double> itemCosts = new ArrayList<>();

    public void addItem(double price, int qty) {
        itemCosts.add(price * qty);
    }

    public double getItemCost(double price, int qty) {
        return price * qty;
    }

    public double getTotal() {
        double total = 0;
        for (double cost : itemCosts) {
            total += cost;
        }
        return total;
    }

    public void clear() {
        itemCosts.clear();
    }
}
