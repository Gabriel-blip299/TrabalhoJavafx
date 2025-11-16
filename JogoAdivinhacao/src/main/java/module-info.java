module com.example.jogoadivinhacao {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jogoadivinhacao to javafx.fxml;
    exports com.example.jogoadivinhacao;
}