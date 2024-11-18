package rupizzeria.models;


public class NYPizza implements PizzaFactory {

    private Size size; // Dynamically determined size

    public NYPizza() {
    }

    public NYPizza(Size size) {
        this.size = size; // Set the size based on user input
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public Pizza createDeluxe() {return new Deluxe(Crust.BROOKLYN, size);}

    @Override
    public Pizza createMeatzza() {
        return new Meatzza(Crust.HAND_TOSSED, size);
    }

    @Override
    public Pizza createBBQChicken() {
        return new BBQChicken(Crust.THIN, size);
    }

    @Override
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Crust.HAND_TOSSED, size);
    }


}


