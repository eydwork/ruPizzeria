package rupizzeria.models;

//sizes and prices for BYO pizza

public enum Size {
    SMALL, MEDIUM, LARGE;

    public Object getBasePriceOrSize(String pizzaType) {
        switch (pizzaType.toLowerCase()) {
            case "deluxe":
            case "bbq chicken":
            case "meatzza":
                // Return size as a String for these types
                return this.toString();

            case "build your own":
                // Return price for Build Your Own
                switch (this) {
                    case SMALL: return 8.99;
                    case MEDIUM: return 10.99;
                    case LARGE: return 12.99;
                }
                break;

            default:
                throw new IllegalArgumentException("Unknown pizza type: " + pizzaType);
        }
        return null; // Default case if something goes wrong
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
