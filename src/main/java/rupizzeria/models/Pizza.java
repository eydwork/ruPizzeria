package rupizzeria.models;

public abstract class Pizza {
    protected List<Topping> toppings; // List of toppings for the pizza
    protected Crust crust;            // Crust type
    protected static Size size;              // Pizza size

    // Constructor
    public Pizza(Crust crust, Size size) {
        this.crust = crust;
        this.size = size;
        this.toppings = new List<>();
    }

    // Abstract method to calculate price
    public abstract double price();

    // Method to add a topping
    public void addTopping(Topping topping) {
        if (!toppings.contains(topping)) {
            toppings.add(topping);
        }
    }

    // Method to remove a topping
    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    // Getters for crust, size, and toppings
    public Crust getCrust() {
        return crust;
    }

    public static Size getSize() {
        return size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    // toString method for easy description
    @Override
    public String toString() {
        return "Pizza {" +
                "size=" + size +
                ", crust=" + crust +
                ", toppings=" + toppings +
                '}';
    }

    public void setSize(Size selectedSize) {
        size = selectedSize;
    }
}

