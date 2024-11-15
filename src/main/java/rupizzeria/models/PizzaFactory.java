package rupizzeria.models;


public interface PizzaFactory {
    Pizza createDeluxe();
    Pizza createMeatzza();
    Pizza createBBQChicken();
    Pizza createBuildYourOwn();
}

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

public class NYPizza implements PizzaFactory {
    @Override
    public Pizza createDeluxe() {
        return new Deluxe(Crust.BROOKLYN, Size.SMALL);
    }

    @Override
    public Pizza createMeatzza() {
        return new Meatzza(Crust.HAND_TOSSED, Size.SMALL);
    }

    @Override
    public Pizza createBBQChicken() {
        return new BBQChicken(Crust.THIN, Size.SMALL);
    }

    @Override
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Crust.HAND_TOSSED, Size.SMALL);
    }
}
