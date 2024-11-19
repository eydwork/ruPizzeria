package rupizzeria.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import rupizzeria.models.ListOfOrders;
import rupizzeria.models.Order;
import rupizzeria.models.Pizza;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AllOrdersViewController {

    @FXML
    public ComboBox<Integer> orderNumberComboBox; // Order numbers only
    @FXML
    public TextArea orderTotalTextArea;
    @FXML
    public Button cancelOrderButton;
    @FXML
    public Button exportTextButton;
    public TextArea outputTextArea;
    @FXML
    private ListView<Pizza> allOrdersListView;

    private ObservableList<Pizza> pizzas; // To hold pizzas for the ListView
    private ListOfOrders listOfOrders; // Instance of ListOfOrders
    private Order currentOrder; // Currently selected order

    public void initialize() {
        pizzas = FXCollections.observableArrayList();
        allOrdersListView.setItems(pizzas);

        listOfOrders = new ListOfOrders(); // Initialize the list of orders

        orderNumberComboBox.setOnAction(event -> {
            Integer selectedOrderNumber = orderNumberComboBox.getValue();
            if (selectedOrderNumber != null) {
                currentOrder = listOfOrders.findOrderByNumber(selectedOrderNumber);
                updateUI();
            }
        });

        loadOrderNumbers();
    }

    public void setListOfOrders(ListOfOrders listOfOrders) {
        this.listOfOrders = listOfOrders;
        loadOrderNumbers();
    }

    private void loadOrderNumbers() {
        ObservableList<Integer> orderNumbers = FXCollections.observableArrayList();
        for (int i = 0; i < listOfOrders.size(); i++) {
            orderNumbers.add(listOfOrders.getOrder(i).getOrderNumber());
        }
        orderNumberComboBox.setItems(orderNumbers);
    }

    private void updateUI() {
        if (currentOrder != null) {
            pizzas.clear();
            orderTotalTextArea.setText(String.format("$%.2f", currentOrder.calculateTotal()));
        } else {
            pizzas.clear();
            orderTotalTextArea.clear();
        }
    }

    @FXML
    public void cancelOrderButton(ActionEvent actionEvent) {
        if (currentOrder != null) {
            listOfOrders.removeOrder(currentOrder); // Remove from ListOfOrders
            loadOrderNumbers(); // Refresh the ComboBox
            pizzas.clear(); // Clear ListView
            orderTotalTextArea.clear(); // Clear total text area
            outputTextArea.setText("Order canceled successfully.");
        } else {
            outputTextArea.setText("No order selected to cancel.");
        }
    }

    @FXML
    public void exportTextButton(ActionEvent actionEvent) {
        if (listOfOrders.size() == 0) {
            outputTextArea.setText("No orders available to export.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt"))) {
            for (int i = 0; i < listOfOrders.size(); i++) {
                writer.write(listOfOrders.getOrder(i).toString());
                writer.newLine();
            }
            outputTextArea.setText("Orders exported successfully to 'orders.txt'.");
        } catch (IOException e) {
            outputTextArea.setText("Error while exporting orders: " + e.getMessage());
        }
    }
}
