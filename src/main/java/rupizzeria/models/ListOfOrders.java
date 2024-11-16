package rupizzeria.models;

public class ListOfOrders {
    private List<Order> orders; // List to hold all the orders

    public ListOfOrders() {
        this.orders = new List<>();
    } //used to print list of orders

    /**
     * Adds a new order to the list of orders.
     * @param order the order to add
     */
    public void addOrder(Order order) {
        orders.add(order);
    } //submit order

    /**
     * Removes an order from the list of orders.
     * @param order the order to remove
     */
    public void removeOrder(Order order) {
        orders.remove(order);
    } //used to cancel order

    /**
     * Gets an order by its index.
     * @param index the index of the order
     * @return the order at the specified index
     */
    public Order getOrder(int index) {
        return orders.get(index);
    }

    /**
     * Gets the total number of orders.
     * @return the size of the orders list
     */
    public int size() {
        return orders.size();
    }

    /**
     * Finds an order by its order number.
     * @param orderNumber the unique order number
     * @return the order with the matching order number, or null if not found
     */
    public Order findOrderByNumber(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                return order;
            }
        }
        return null; // Not found
    }
}
