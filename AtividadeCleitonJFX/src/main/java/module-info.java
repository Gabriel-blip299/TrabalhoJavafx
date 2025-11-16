module com.example.atividadecleitonjfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atividadecleitonjfx to javafx.fxml;
    exports com.example.atividadecleitonjfx;
}