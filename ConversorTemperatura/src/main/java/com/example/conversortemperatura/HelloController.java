package com.example.conversortemperatura;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField txtValor;

    @FXML
    private Button btnParaF;

    @FXML
    private Button btnParaC;

    @FXML
    private Label lblResultado;

    @FXML
    public void initialize() {
        btnParaF.setOnAction(e -> converterParaF());
        btnParaC.setOnAction(e -> converterParaC());
    }

    private void converterParaF() {
        double c = Double.parseDouble(txtValor.getText());
        double f = (c * 9/5) + 32;
        lblResultado.setText(String.format("Resultado: %.2f°F", f));
    }

    private void converterParaC() {
        double f = Double.parseDouble(txtValor.getText());
        double c = (f - 32) * 5/9;
        lblResultado.setText(String.format("Resultado: %.2f°C", c));
    }
}
