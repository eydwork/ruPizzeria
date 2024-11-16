module rupizzeria.rupizzeria {
    requires javafx.controls;
    requires javafx.fxml;


    opens rupizzeria.rupizzeria to javafx.fxml;
    exports rupizzeria;
    opens rupizzeria to javafx.fxml;
}