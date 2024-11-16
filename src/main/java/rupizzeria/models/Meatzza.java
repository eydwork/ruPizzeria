package rupizzeria.models;

//meatzza pizza making and pricing

public class Meatzza extends Pizza {

    public Meatzza(Crust crust, Size size) {
        super(crust, size);
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.BEEF);
        toppings.add(Topping.HAM);
    }

    @Override
    public double price() {
        double subtotal = switch(size) {
            case SMALL -> 17.99;
            case MEDIUM -> 19.99;
            case LARGE -> 21.99;
        };

        return subtotal;
    }

    @Override
    public String toString() {
        return "Meatzza Pizza";
    }
}

