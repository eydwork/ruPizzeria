package rupizzeria.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class OpeningViewController {

    public void placeAnOrderButton(ActionEvent actionEvent) {
        try {
            // Ensure the correct path to the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/rupizzeria/pizza-view.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void employeeOverviewButton(ActionEvent actionEvent) {
        try {
            // Ensure the correct path to the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/rupizzeria/allOrders-view.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
