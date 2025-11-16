package com.example.simuladorcontaluz;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField txtNome, txtConsumo;

    @FXML
    private ComboBox<String> cbTipo;

    @FXML
    private Label lblResultado;

    @FXML
    private void initialize() {
        // Inicializa ComboBox com tipos de residência
        cbTipo.getItems().addAll("Residencial", "Comercial", "Industrial");
        cbTipo.getSelectionModel().selectFirst(); // seleciona Residencial por padrão
    }

    @FXML
    private void calcular() {
        String nome = txtNome.getText().trim();
        String consumoStr = txtConsumo.getText().trim();
        String tipo = cbTipo.getValue();

        if (nome.isEmpty()) {
            lblResultado.setText("Digite o nome do cliente.");
            return;
        }

        double consumo;
        try {
            consumo = Double.parseDouble(consumoStr);
            if (consumo < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            lblResultado.setText("Digite um consumo válido.");
            return;
        }

        double valor = 0;
        switch (tipo) {
            case "Residencial" -> valor = consumo * 0.60;
            case "Comercial" -> valor = consumo * 0.48;
            case "Industrial" -> valor = consumo * 0.75;
        }

        lblResultado.setText(String.format(
                "Cliente: %s — Tipo: %s — Consumo: %.2f kWh — Valor: R$%.2f",
                nome, tipo, consumo, valor
        ));
    }
}
