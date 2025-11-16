module com.example.montagemlanche {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.montagemlanche to javafx.fxml;
    exports com.example.montagemlanche;
}