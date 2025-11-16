package com.example.cadastrosimples;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private TextField txtNome, txtIdade;

    @FXML
    private ComboBox<String> cbCurso;

    @FXML
    private TableView<ObservableList<String>> tabelaAlunos;

    @FXML
    private TableColumn<ObservableList<String>, String> colNome, colIdade, colCurso;

    private ObservableList<ObservableList<String>> listaAlunos = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Inicializa ComboBox
        cbCurso.getItems().addAll("Matemática", "Física", "Química", "Biologia", "Informática");
        cbCurso.getSelectionModel().selectFirst();

        // Configura TableColumns
        colNome.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(0)));
        colIdade.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(1)));
        colCurso.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(2)));

        tabelaAlunos.setItems(listaAlunos);
    }

    @FXML
    private void adicionarAluno() {
        String nome = txtNome.getText().trim();
        String idade = txtIdade.getText().trim();
        String curso = cbCurso.getValue();

        if (nome.isEmpty() || idade.isEmpty()) {
            showAlert("Preencha todos os campos.");
            return;
        }

        try {
            int idadeInt = Integer.parseInt(idade);
            if (idadeInt <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            showAlert("Digite uma idade válida.");
            return;
        }

        ObservableList<String> linha = FXCollections.observableArrayList(nome, idade, curso);
        listaAlunos.add(linha);

        txtNome.clear();
        txtIdade.clear();
        cbCurso.getSelectionModel().selectFirst();
    }

    @FXML
    private void excluirAluno() {
        ObservableList<String> selecionado = tabelaAlunos.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            listaAlunos.remove(selecionado);
        } else {
            showAlert("Selecione um aluno para excluir.");
        }
    }

    private void showAlert(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
