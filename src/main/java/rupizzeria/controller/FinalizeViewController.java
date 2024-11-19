package rupizzeria.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import rupizzeria.models.Order;
import rupizzeria.models.Pizza;

import java.io.IOException;

public class FinalizeViewController {

    @FXML
    private TextArea orderNumberTextArea;

    @FXML
    private ListView<Pizza> pizzaListView;

    @FXML
    private TextArea subtotalTextArea;

    @FXML
    private TextArea taxTextArea;

    @FXML
    private TextArea totalTextArea;

    private Order order;
    private ObservableList<Pizza> pizzas; // Observable list to dynamically reflect changes

    public void initialize() {
        pizzas = FXCollections.observableArrayList(); // Initialize the ObservableList
        pizzaListView.setItems(pizzas); // Set the list to the ListView
        if (order != null) {
            updateUI();
        }
    }

    public void removePizzaButton(ActionEvent actionEvent) {
        Pizza selectedPizza = pizzaListView.getSelectionModel().getSelectedItem();
        if (selectedPizza != null) {
            order.getPizzas().remove(selectedPizza); // Remove from the order
            updateUI(); // Update UI elements to reflect changes
        }
    }

    public void clearOrderButton(ActionEvent actionEvent) {
        order.getPizzas().clear(); // Clear all pizzas from the order
        updateUI(); // Update UI elements to reflect changes
    }

    public void placeOrderButton(ActionEvent actionEvent) {
        try {
            // Ensure the correct path to the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/rupizzeria/allOrders-view.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Get the controller for the All Orders scene and pass necessary data
            AllOrdersViewController allOrdersViewController = loader.getController();
            allOrdersViewController.initialize(); // Ensure it loads the updated global orders

            // Set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setOrder(Order order) {
        this.order = order;
        updateUI(); // Update UI whenever a new order is set
    }

    private void updateUI() {
        if (order != null) {
            orderNumberTextArea.setText(order.getFormattedOrderNumber());
            pizzas.clear(); // Clear the existing ObservableList

            for (Pizza pizza : order.getPizzas()) {
                pizzas.add(pizza); // Add the pizzas from the Order to the ObservableList
            }

            subtotalTextArea.setText(String.format("$%.2f", order.calculateSubtotal()));
            taxTextArea.setText(String.format("$%.2f", order.calculateTax()));
            totalTextArea.setText(String.format("$%.2f", order.calculateTotal()));
        }
    }
}

