package rupizzeria.models;

public enum Size {
    SMALL(8.99),
    MEDIUM(10.99),
    LARGE(12.99);

    private final double basePrice;

    Size(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
