package rupizzeria.models;

public class BuildYourOwn extends Pizza {
    private static final double TOPPING_PRICE = 1.69;

    public BuildYourOwn(Crust crust, Size size) {
        super(crust, size);
    }

    public void addTopping(Topping topping) {
        if (toppings.size() < 7) {
            toppings.add(topping);
        } else {
            System.out.println("You can only add up to 7 toppings.");
        }
    }

    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    @Override
    public double price() {
        // Get the base price from the Size enum for "build your own" pizzas
        double sizePrice = size.getBasePriceOrSize("build your own")
                != null ? (double) size.getBasePriceOrSize("build your own") : 0;

        // Add the price of toppings
        double subtotal = sizePrice + (TOPPING_PRICE * toppings.size());
        return subtotal;
    }

    @Override
    public String toString() {
        return "Build Your Own Pizza with " + toppings.size() + " toppings.";
    }
}


