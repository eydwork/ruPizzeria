package rupizzeria.models;

public class Order {
    private static int orderCounter = 1; // Static counter to generate unique order numbers
    private int number;                  // Unique order number
    private List<OrderItem> items;           // List of OrderItem objects
    private static final double TAX_RATE = 0.06625; // New Jersey sales tax rate

    public Order() {
        this.number = orderCounter++;    // Assign unique order number and increment counter
        this.items = new List<>();
    }

    public int getOrderNumber() { //used to get order number
        return number;
    }

    /**
     * Returns the order number formatted as a 4-digit string with leading zeros.
     * For example, 1 -> "0001", 42 -> "0042".
     */
    public String getFormattedOrderNumber() {
        return String.format("%04d", this.number);
    }

    public void addPizza(Pizza pizza, int quantity) {
        // Check if the same pizza already exists in the order
        for (OrderItem item : items) {
            if (item.getPizza().equals(pizza)) {
                item.incrementQuantity(quantity); // Increase quantity if pizza is already in the order
                return;
            }
        }
        // Otherwise, create a new OrderItem
        OrderItem newItem = new OrderItem(pizza);
        newItem.incrementQuantity(quantity - 1); // Adjust quantity (already starts at 1)
        items.add(newItem);
    }

    public void removePizza(Pizza pizza) {
        items.remove(new OrderItem(pizza));
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (OrderItem item : items) {
            subtotal += item.calculateSubtotal();
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
        for (OrderItem item : items) {
            sb.append(item).append("\n");
        }
        sb.append("Subtotal: $").append(String.format("%.2f", calculateSubtotal())).append("\n");
        sb.append("Tax: $").append(String.format("%.2f", calculateTax())).append("\n");
        sb.append("Total: $").append(String.format("%.2f", calculateTotal())).append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.addPizza(new Deluxe(Crust.DEEP_DISH, Size.LARGE), 2);
        order.addPizza(new Meatzza(Crust.STUFFED, Size.SMALL), 1);
        System.out.println(order);

        Order order2 = new Order();
        order2.addPizza(new BBQChicken(Crust.PAN, Size.MEDIUM), 3);
        order2.addPizza(new BuildYourOwn(Crust.HAND_TOSSED, Size.LARGE), 1);
        System.out.println(order2);
    }
}
