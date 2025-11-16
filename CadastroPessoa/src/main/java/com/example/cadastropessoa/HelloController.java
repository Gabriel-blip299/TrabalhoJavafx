package com.example.cadastropessoa;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtIdade;

    @FXML
    private RadioButton rbMasc;

    @FXML
    private RadioButton rbFem;

    @FXML
    private CheckBox chkEsportes;

    @FXML
    private Button btnAnalisar;

    @FXML
    private Label lblResultado;

    private ToggleGroup grupoSexo;

    @FXML
    public void initialize() {

        // Grupo de rádio
        grupoSexo = new ToggleGroup();
        rbMasc.setToggleGroup(grupoSexo);
        rbFem.setToggleGroup(grupoSexo);

        btnAnalisar.setOnAction(e -> analisar());
    }

    private void analisar() {
        String nome = txtNome.getText();
        int idade = Integer.parseInt(txtIdade.getText());

        String sexo = rbMasc.isSelected() ? "masculino" : "feminino";
        String esportes = chkEsportes.isSelected() ? "gosta de esportes" : "não gosta de esportes";

        String maioridade = idade < 18 ? "Menor de idade." : "Maior de idade.";

        String resultado = String.format(
                "%s, %d anos, do sexo %s, %s.\n%s",
                nome, idade, sexo, esportes, maioridade
        );

        lblResultado.setText(resultado);
    }
}
