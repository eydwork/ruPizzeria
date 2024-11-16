package rupizzeria.models;

//sizes and prices for BYO pizza

public enum Size {
    SMALL(8.99),
    MEDIUM(10.99),
    LARGE(12.99);

    private final double basePriceSize; //base price for size without any toppings

    Size(double basePriceSize) {
        this.basePriceSize = basePriceSize;
    }

    public double getBasePriceSize() {

        return basePriceSize;
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
