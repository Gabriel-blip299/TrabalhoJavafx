module com.example.cadastropessoa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cadastropessoa to javafx.fxml;
    exports com.example.cadastropessoa;
}