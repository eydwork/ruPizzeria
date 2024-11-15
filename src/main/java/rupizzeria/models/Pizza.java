package rupizzeria.models;

public abstract class Pizza {
    protected List<Topping> toppings; // List of toppings for the pizza
    protected Crust crust;                 // Crust type
    protected Size size;                   // Pizza size
    public abstract double price();

    public Pizza(Crust crust, Size size) {
        this.crust = crust;
        this.size = size;
        this.toppings = new List<>();
    }

}

