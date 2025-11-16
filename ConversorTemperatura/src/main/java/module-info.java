module com.example.conversortemperatura {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.conversortemperatura to javafx.fxml;
    exports com.example.conversortemperatura;
}