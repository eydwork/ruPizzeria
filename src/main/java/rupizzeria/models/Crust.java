package rupizzeria.models;

//Crust options

public enum Crust {
    DEEP_DISH,
    BROOKLYN,
    PAN,
    THIN,
    STUFFED,
    HAND_TOSSED;

    @Override
    public String toString() {
        return name().replace("_", " ").toLowerCase();
    }
}