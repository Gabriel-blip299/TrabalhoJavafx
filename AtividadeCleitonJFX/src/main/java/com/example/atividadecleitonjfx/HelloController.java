package com.example.atividadecleitonjfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField txtNum1;

    @FXML
    private TextField txtNum2;

    @FXML
    private Label lblResultado;

    @FXML
    private Button btnSoma;

    @FXML
    private Button btnSub;

    @FXML
    private Button btnMult;

    @FXML
    private Button btnDiv;

    @FXML
    public void initialize() {
        btnSoma.setOnAction(e -> soma());
        btnSub.setOnAction(e -> sub());
        btnMult.setOnAction(e -> mult());
        btnDiv.setOnAction(e -> div());
    }

    private void soma() {
        double n1 = Double.parseDouble(txtNum1.getText());
        double n2 = Double.parseDouble(txtNum2.getText());
        lblResultado.setText("Resultado: " + (n1 + n2));
    }

    private void sub() {
        double n1 = Double.parseDouble(txtNum1.getText());
        double n2 = Double.parseDouble(txtNum2.getText());
        lblResultado.setText("Resultado: " + (n1 - n2));
    }

    private void mult() {
        double n1 = Double.parseDouble(txtNum1.getText());
        double n2 = Double.parseDouble(txtNum2.getText());
        lblResultado.setText("Resultado: " + (n1 * n2));
    }

    private void div() {
        double n1 = Double.parseDouble(txtNum1.getText());
        double n2 = Double.parseDouble(txtNum2.getText());

        if (n2 == 0) {
            lblResultado.setText("Erro: divisão por zero!");
        } else {
            lblResultado.setText("Resultado: " + (n1 / n2));
        }
    }

}
