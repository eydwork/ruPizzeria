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
        double sizePrice = size.getBasePriceOrSize("build your own") instanceof Double
                ? (double) size.getBasePriceOrSize("build your own")
                : 0.0;

        // Add the price of toppings
        double subtotal = sizePrice + (TOPPING_PRICE * toppings.size());
        return subtotal;
    }

    @Override
    public String toString() {
        return "Build Your Own Pizza with " + toppings.size() + " toppings.";
    }
}



  /*  public static void main(String[] args) { //testing the class
        BuildYourOwn byo = new BuildYourOwn(Crust.PAN, Size.MEDIUM);
        byo.addTopping(Topping.SAUSAGE);
        byo.addTopping(Topping.PEPPERONI);
        byo.addTopping(Topping.GREEN_PEPPER);
        byo.addTopping(Topping.ONION);
        byo.addTopping(Topping.MUSHROOM);
        byo.addTopping(Topping.OLIVE);
        byo.addTopping(Topping.PINEAPPLE);
        System.out.println(byo.price());
    }

   */

