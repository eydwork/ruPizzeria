package rupizzeria.models;

public enum Topping {
    SAUSAGE,
    PEPPERONI,
    GREEN_PEPPER,
    ONION,
    MUSHROOM,
    BBQ_CHICKEN,
    PROVOLONE,
    CHEDDAR,
    BEEF,
    HAM,
    BACON,
    OLIVE,
    PINEAPPLE;

    @Override
    public String toString() {
        // Optionally override toString if a more user-friendly display of each topping is needed
        return name().replace("_", " ").toLowerCase();
    }
}
