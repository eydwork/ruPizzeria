package rupizzeria.models;

public class Order {
    private static final double TAX_RATE = 0.06625;

    private int number; // Order number
    private List<Pizza> pizzas; // List of pizzas in the order


    public Order(int number) {
        this.number = number; // Set the order number
        this.pizzas = new List<>(); // Initialize the list of pizzas
    }

    public int getOrderNumber() { //used to get order number
        return number;
    }

    public List<Pizza> getPizzas() { //used to get list of pizzas
        return pizzas;
    }


    /**
     * Returns the order number formatted as a 4-digit string with leading zeros.
     * For example, 1 -> "0001", 42 -> "0042".
     */
    public String getFormattedOrderNumber() {
        return String.format("%04d", this.number);
    }

    // Method to add a pizza to the order
    public void addPizza(Pizza pizza) {
        if (pizza != null) {
            pizzas.add(pizza);
        }
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
    } //tax calculation

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    } //total calculation


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(getFormattedOrderNumber()).append("\n");
        for (Pizza pizza : pizzas) {
            sb.append(pizza).append("\n");
        }
        sb.append("Subtotal: $").append(String.format("%.2f", calculateSubtotal())).append("\n");
        sb.append("Tax: $").append(String.format("%.2f", calculateTax())).append("\n");
        sb.append("Total: $").append(String.format("%.2f", calculateTotal())).append("\n");
        return sb.toString();
    }

}
