package rupizzeria.models;

//????????????


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

//????????????
