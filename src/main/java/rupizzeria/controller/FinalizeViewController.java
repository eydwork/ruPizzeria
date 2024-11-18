package rupizzeria.controller;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import rupizzeria.models.List;
import rupizzeria.models.Order;
import rupizzeria.models.OrderItem;

public class FinalizeViewController {

    public Button removePizzaButton;
    public ListView pizzaListView;
    public Button clearOrderButton;
    public Button placeOrderButton;
    public TextArea subtotalTextArea;
    public TextArea taxTextArea;
    public TextArea totalTextArea;
    public TextArea orderNumberTextArea;

    @FXML
    private ListView<OrderItem> orderListView; // Bind this in your FXML

    private ObservableList<OrderItem> observableOrderItems;

    public void initialize() {
        observableOrderItems = FXCollections.observableArrayList();
        orderListView.setItems(observableOrderItems);
    }

    private void refreshOrderListView(Order order) {
        observableOrderItems.setAll((OrderItem) FXCollections.observableArrayList(order.getItems()));
    }

    public void removePizzaButton(ActionEvent actionEvent) {
    }

    public void clearOrderButton(ActionEvent actionEvent) {
    }

    public void placeOrderButton(ActionEvent actionEvent) {
    }
}
