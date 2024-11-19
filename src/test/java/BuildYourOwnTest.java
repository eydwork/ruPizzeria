import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rupizzeria.models.BuildYourOwn;
import rupizzeria.models.Crust;
import rupizzeria.models.Size;
import rupizzeria.models.Topping;

import static org.junit.jupiter.api.Assertions.*;

class BuildYourOwnPriceTest {

    private BuildYourOwn pizza;

    @BeforeEach
    void setUp() {
        pizza = new BuildYourOwn(Crust.HAND_TOSSED, Size.MEDIUM);
    }

    @Test
    void testPriceWithNoToppings() {
        // Verify base price with no toppings
        double expectedBasePrice = (double) Size.MEDIUM.getBasePriceOrSize("build your own");
        assertEquals(expectedBasePrice, pizza.price(), 0.01, "Price should match the base price for medium size with no toppings.");
    }

    @Test
    void testPriceWithOneTopping() {
        // Add one topping
        pizza.addTopping(Topping.PEPPERONI);
        double expectedPrice = (double) Size.MEDIUM.getBasePriceOrSize("build your own") + 1.69; // One topping
        assertEquals(expectedPrice, pizza.price(), 0.01, "Price should include base price and the cost of one topping.");
    }

    @Test
    void testPriceWithMultipleToppings() {
        // Add three toppings
        pizza.addTopping(Topping.PEPPERONI);
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.BACON);
        double expectedPrice = (double)  Size.MEDIUM.getBasePriceOrSize("build your own") + (3 * 1.69); // Three toppings
        assertEquals(expectedPrice, pizza.price(), 0.01, "Price should include base price and the cost of three toppings.");
    }

    @Test
    void testPriceWithMaximumToppings() {
        // Add maximum of 7 toppings
        pizza.addTopping(Topping.PEPPERONI);
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.OLIVE);
        pizza.addTopping(Topping.ONION);
        pizza.addTopping(Topping.BACON);
        pizza.addTopping(Topping.CHEDDAR);
        pizza.addTopping(Topping.GREEN_PEPPER);

        double expectedPrice = (double) Size.MEDIUM.getBasePriceOrSize("build your own") + (7 * 1.69); // Seven toppings
        assertEquals(expectedPrice, pizza.price(), 0.01, "Price should include base price and the cost of seven toppings.");
    }

    @Test
    void testPriceExceedingMaximumToppings() {
        // Add 7 toppings
        pizza.addTopping(Topping.PEPPERONI);
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.OLIVE);
        pizza.addTopping(Topping.ONION);
        pizza.addTopping(Topping.BACON);
        pizza.addTopping(Topping.CHEDDAR);
        pizza.addTopping(Topping.GREEN_PEPPER);

        // Try adding an 8th topping
        pizza.addTopping(Topping.BEEF);

        double expectedPrice = (double) Size.MEDIUM.getBasePriceOrSize("build your own") + (7 * 1.69); // Still seven toppings
        assertEquals(expectedPrice, pizza.price(), 0.01, "Price should not include additional topping beyond the limit.");
    }
}
