package rupizzeria.models;

//deluxe pizza making and pricing

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
        double subtotal = switch(size) {
            case SMALL -> 16.99;
            case MEDIUM -> 18.99;
            case LARGE -> 20.99;
        };

        return subtotal;
    }

    @Override
    public String toString() {
        return "Deluxe Pizza";
    }

}