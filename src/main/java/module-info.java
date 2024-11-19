module rupizzeria {
    requires javafx.controls;
    requires javafx.fxml;

    exports rupizzeria;
    opens rupizzeria to javafx.fxml, javafx.graphics;
    exports rupizzeria.controller;
    opens rupizzeria.controller to javafx.fxml, javafx.graphics;
    exports rupizzeria.models;
}