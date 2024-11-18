module rupizzeria.rupizzeria {
    requires javafx.controls;
    requires javafx.fxml;


    opens rupizzeria to javafx.fxml, javafx.graphics;
    exports rupizzeria.controller;
    opens rupizzeria.controller to javafx.fxml, javafx.graphics;
    exports rupizzeria;
}