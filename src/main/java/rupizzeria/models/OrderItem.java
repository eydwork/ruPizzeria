package rupizzeria.models;

public class OrderItem {
    private Pizza pizza;
    private int quantity;

    public OrderItem(Pizza pizza) {
        this.pizza = pizza;
        this.quantity = 1; // Default quantity is 1
    }

    public Pizza getPizza() {
        return pizza;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity(int count) {
        this.quantity += count;
    }

    public void decrementQuantity(int count) {
        this.quantity -= count;
        if (this.quantity < 0) {
            this.quantity = 0; // Prevent negative quantities
        }
    }

    public double calculateSubtotal() {
        return pizza.price() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s x%d - $%.2f", pizza, quantity, calculateSubtotal());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        OrderItem orderItem = (OrderItem) obj;
        // Equality is based on the pizza (ignores quantity)
        return pizza.equals(orderItem.pizza);
    }

    @Override
    public int hashCode() {
        return pizza.hashCode();
    }
}
