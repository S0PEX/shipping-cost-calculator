import ak.softwarequality.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {
    @Test
    @DisplayName("calculateOrderCost with standard shipping")
    void calculateOrderCostStandardShipping() {
        var orderAmount = 10;
        var orderCost = Main.calculateOrderCost(orderAmount, "standard");

        // Standard shipping is +10€ and no discount
        assertEquals(20, orderCost);
    }

    @Test
    @DisplayName("calculateOrderCost with standard shipping and discount for order >= 100€")
    void calculateOrderCostStandardShippingAndDiscount() {
        var orderAmount = 100;
        var orderCost = Main.calculateOrderCost(orderAmount, "standard");

        // Standard shipping is +10€, 100€ so discount of -10€, so still 100€
        assertEquals(100, orderCost);
    }

    @Test
    @DisplayName("calculateOrderCost with express shipping")
    void calculateOrderCostExpressShipping() {
        var orderAmount = 10;
        var orderCost = Main.calculateOrderCost(orderAmount, "express");

        // Standard shipping is +20€ and no discount
        assertEquals(30, orderCost);
    }

    @Test
    @DisplayName("calculateOrderCost with express shipping and discount for order >= 100€")
    void calculateOrderCostExpressShippingAndDiscount() {
        var orderAmount = 100;
        var orderCost = Main.calculateOrderCost(orderAmount, "express");

        // Standard shipping is +20€, 100€ so discount of -10€, so 110€
        assertEquals(110, orderCost);
    }

    @Test
    @DisplayName("calculateOrderCost of orders that would result in a negative orderCost")
    void calculateOrderCostWithNegativeOrderAmount() {
        var orderAmount = -20;
        var orderCost = Main.calculateOrderCost(orderAmount, "standard");
        assertEquals(0, orderCost);
    }

    @Test
    @DisplayName("calculateOrderCost with invalid shipping option")
    void calculateOrderCostWithInvalidShippingOption() {
        var orderAmount = 10;
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Main.calculateOrderCost(orderAmount, "some_random_text");
        });
        assertEquals(e.getMessage(), "Invalid shipping option.");
    }
}
