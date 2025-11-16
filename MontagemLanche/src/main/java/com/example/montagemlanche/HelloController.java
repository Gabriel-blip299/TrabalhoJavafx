package com.example.montagemlanche;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private TextField txtNome;

    @FXML
    private ComboBox<String> cbPao;

    @FXML
    private RadioButton rbBovina, rbFrango, rbSoja;

    @FXML
    private CheckBox cbQueijo, cbBacon, cbSalada, cbMolho;

    @FXML
    private Label lblResumo;

    @FXML
    private void initialize() {
        // Inicializa ComboBox
        cbPao.getItems().addAll("francês", "integral", "australiano");
        cbPao.getSelectionModel().selectFirst();

        // Grupo de RadioButtons
        ToggleGroup grupoCarne = new ToggleGroup();
        rbBovina.setToggleGroup(grupoCarne);
        rbFrango.setToggleGroup(grupoCarne);
        rbSoja.setToggleGroup(grupoCarne);

        // Seleciona Bovina por padrão
        rbBovina.setSelected(true);
    }

    @FXML
    private void gerarPedido() {
        String nome = txtNome.getText().trim();
        if (nome.isEmpty()) {
            lblResumo.setText("Por favor, digite o nome do cliente.");
            return;
        }

        String pao = cbPao.getValue();

        String carne = "";
        if (rbBovina.isSelected()) carne = "bovina";
        else if (rbFrango.isSelected()) carne = "frango";
        else if (rbSoja.isSelected()) carne = "soja";

        String adicionais = "";
        if (cbQueijo.isSelected()) adicionais += "queijo, ";
        if (cbBacon.isSelected()) adicionais += "bacon, ";
        if (cbSalada.isSelected()) adicionais += "salada, ";
        if (cbMolho.isSelected()) adicionais += "molho, ";

        if (!adicionais.isEmpty()) {
            adicionais = adicionais.substring(0, adicionais.length() - 2);
            adicionais = ", com " + adicionais;
        }

        lblResumo.setText(String.format("Pedido de %s: pão %s com carne %s%s.", nome, pao, carne, adicionais));
    }
}
