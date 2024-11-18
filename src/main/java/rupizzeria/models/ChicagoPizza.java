package rupizzeria.models;


public class ChicagoPizza implements PizzaFactory {

    private Size size; // Dynamically determined size

    public ChicagoPizza() {
    }

    public ChicagoPizza(Size size) {
        this.size = size; // Set the size based on user input
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public Pizza createDeluxe() {
        return new Deluxe(Crust.DEEP_DISH, size); // Use the selected size
    }

    @Override
    public Pizza createMeatzza() {
        return new Meatzza(Crust.STUFFED, size); // Use the selected size
    }

    @Override
    public Pizza createBBQChicken() {
        return new BBQChicken(Crust.PAN, size); // Use the selected size
    }

    @Override
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Crust.PAN, size); // Use the selected size
    }
}


