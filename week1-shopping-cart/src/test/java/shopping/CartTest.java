package shopping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private CartCalculator cart;

    @BeforeEach
    void setUp() {
        cart = new CartCalculator();
    }

    @Test
    void testSingleItemCost() {
        double result = cart.getItemCost(5.0, 3);
        assertEquals(15.0, result);
    }

    @Test
    void testTotalWithMultipleItems() {
        cart.addItem(10.0, 2);
        cart.addItem(5.0, 3);
        assertEquals(35.0, cart.getTotal());
    }

    @Test
    void testEmptyCartTotal() {
        assertEquals(0.0, cart.getTotal());
    }

    @Test
    void testSingleItemAdded() {
        cart.addItem(9.99, 1);
        assertEquals(9.99, cart.getTotal(), 0.001);
    }

    @Test
    void testClearResetsTotal() {
        cart.addItem(10.0, 5);
        cart.clear();
        assertEquals(0.0, cart.getTotal());
    }

    @Test
    void testItemCostWithDecimalPrice() {
        double result = cart.getItemCost(2.50, 4);
        assertEquals(10.0, result, 0.001);
    }
}
