package rupizzeria.models;

public class BBQChicken extends Pizza {

    public BBQChicken(Crust crust, Size size) {
        super(crust, size);
        toppings.add(Topping.BBQ_CHICKEN);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.PROVOLONE);
        toppings.add(Topping.CHEDDAR);
    }

    @Override
    public double price() {
        switch (size) {
            case SMALL: return 14.99;
            case MEDIUM: return 16.99;
            case LARGE: return 19.99;
            default: return 0;
        }
    }
}
