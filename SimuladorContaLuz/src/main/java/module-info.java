module com.example.simuladorcontaluz {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.simuladorcontaluz to javafx.fxml;
    exports com.example.simuladorcontaluz;
}