package com.example.jogoadivinhacao;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class HelloController {
    @FXML
    private TextField txtNumero;

    @FXML
    private Label lblResultado;

    private int numeroSorteado;
    private Random random = new Random();

    @FXML
    private void initialize() {
        gerarNumero();
    }

    private void gerarNumero() {
        numeroSorteado = random.nextInt(10) + 1; // 1 a 10
        lblResultado.setText(""); // limpa resultado
    }

    @FXML
    private void verificar() {
        String entrada = txtNumero.getText().trim();

        if (entrada.isEmpty()) {
            lblResultado.setText("Digite um número válido.");
            return;
        }

        int valor;
        try {
            valor = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            lblResultado.setText("Digite um número válido.");
            return;
        }

        if (valor < 1 || valor > 10) {
            lblResultado.setText("Digite um número entre 1 e 10.");
            return;
        }

        if (valor == numeroSorteado) {
            lblResultado.setText("Acertou!");
        } else {
            lblResultado.setText("Errou! O número era " + numeroSorteado);
        }
    }

    @FXML
    private void novoNumero() {
        gerarNumero();
        txtNumero.clear();
        lblResultado.setText("");
    }
}
