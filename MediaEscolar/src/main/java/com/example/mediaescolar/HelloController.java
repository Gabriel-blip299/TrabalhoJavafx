package com.example.mediaescolar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtN1;

    @FXML
    private TextField txtN2;

    @FXML
    private TextField txtN3;

    @FXML
    private Button btnCalcular;

    @FXML
    private Label lblResultado;

    @FXML
    public void initialize() {
        btnCalcular.setOnAction(e -> calcularMedia());
    }

    private void calcularMedia() {
        String nome = txtNome.getText();

        double n1 = Double.parseDouble(txtN1.getText());
        double n2 = Double.parseDouble(txtN2.getText());
        double n3 = Double.parseDouble(txtN3.getText());

        double media = (n1 + n2 + n3) / 3.0;

        String situacao;

        if (media >= 7) {
            situacao = "Aprovado";
        } else if (media >= 4) {
            situacao = "Recuperação";
        } else {
            situacao = "Reprovado";
        }

        lblResultado.setText(
                String.format("Aluno %s — média: %.1f — %s.", nome, media, situacao)
        );
    }
}
