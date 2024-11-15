package rupizzeria.models;

public class Order {
    private static int orderCounter = 1; // Static counter to generate unique order numbers
    private int number;                  // Unique order number
    private List<Pizza> pizzas;          // List of pizzas in this order
    private static final double TAX_RATE = 0.06625; // New Jersey sales tax rate

    public Order() {
        this.number = orderCounter++;    // Assign unique order number and increment counter
        this.pizzas = new List<>();
    }

    public int getOrderNumber() {
        return number;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (Pizza pizza : pizzas) {
            subtotal += pizza.price();
        }
        return subtotal;
    }

    public double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(number).append("\n");
        for (Pizza pizza : pizzas) {
            sb.append(pizza).append("\n");
        }
        sb.append("Subtotal: $").append(String.format("%.2f", calculateSubtotal())).append("\n");
        sb.append("Tax: $").append(String.format("%.2f", calculateTax())).append("\n");
        sb.append("Total: $").append(String.format("%.2f", calculateTotal())).append("\n");
        return sb.toString();
    }
}
