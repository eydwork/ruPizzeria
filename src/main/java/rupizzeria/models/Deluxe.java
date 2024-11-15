package rupizzeria.models;

public class Deluxe extends Pizza {

    public Deluxe(Crust crust, Size size) {
        super(crust, size);
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.MUSHROOM);
    }

    @Override
    public double price() {
        switch (size) {
            case SMALL: return 16.99;
            case MEDIUM: return 18.99;
            case LARGE: return 20.99;
            default: return 0;
        }
    }
}