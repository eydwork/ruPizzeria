package rupizzeria.models;

//bbq chicken making and pricing

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
        double subtotal = switch(size) {
            case SMALL -> 14.99;
            case MEDIUM -> 16.99;
            case LARGE -> 19.99;
        };

        return subtotal;
    }

    @Override
    public String toString() {
        return "BBQ Chicken Pizza";
    }


}
