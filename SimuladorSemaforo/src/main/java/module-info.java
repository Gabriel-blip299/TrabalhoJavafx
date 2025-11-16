module com.example.simuladorsemaforo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.simuladorsemaforo to javafx.fxml;
    exports com.example.simuladorsemaforo;
}