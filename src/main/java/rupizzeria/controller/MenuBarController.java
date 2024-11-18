package rupizzeria.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuBarController {

    @FXML
    public MenuItem homeWindow;

   @FXML
    public MenuItem selectionWindow;

    @FXML
    public MenuItem summaryWindow;

    @FXML
    public MenuItem staffOverviewWindow;

    @FXML
    private void loadPage(String fxmlPath, MenuItem menuItem) {
        try {
            FXMLLoader sceneLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent newRoot = sceneLoader.load();
            Scene scene = new Scene(newRoot);
            Stage stage = (Stage) menuItem.getParentPopup().getOwnerWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void goToHome() {
        loadPage("/rupizzeria/opening-view.fxml", homeWindow);
    }

    @FXML
    public void goToSelection() {
        loadPage("/rupizzeria/pizza-view.fxml", selectionWindow);
    }

    @FXML
    public void goToOrderSummary() {
        loadPage("/rupizzeria/finalize-view.fxml", summaryWindow);
    }

    @FXML
    public void goToStaffOverview() {
        loadPage("/rupizzeria/allOrders-view.fxml", staffOverviewWindow);
    }

}
