package rupizzeria.models;

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
        switch (size) {
            case SMALL: return 17.99;
            case MEDIUM: return 19.99;
            case LARGE: return 21.99;
            default: return 0;
        }
    }
}

