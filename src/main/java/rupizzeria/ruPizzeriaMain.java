package rupizzeria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ruPizzeriaMain extends Application {

    private static final int HEIGHT = 600;
    private static final int WIDTH = 900;

    @Override
    public void start(Stage homeStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/rupizzeria/opening-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, WIDTH, HEIGHT); // Set preferred width and height


        homeStage.setTitle("ruPizzeria Application");
        homeStage.setScene(scene);
        homeStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
