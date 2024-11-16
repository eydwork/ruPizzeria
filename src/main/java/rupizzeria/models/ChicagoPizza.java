package rupizzeria.models;

//????????????

public class ChicagoPizza implements PizzaFactory {
    @Override
    public Pizza createDeluxe() {
        return new Deluxe(Crust.DEEP_DISH, Size.SMALL);  // Specify crust and size
    }

    @Override
    public Pizza createMeatzza() {
        return new Meatzza(Crust.STUFFED, Size.SMALL);
    }

    @Override
    public Pizza createBBQChicken() {
        return new BBQChicken(Crust.PAN, Size.SMALL);
    }

    @Override
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Crust.PAN, Size.SMALL);
    }
}

//????????????

