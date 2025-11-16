package com.example.simuladorsemaforo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class HelloController {

    @FXML
    private Circle circleVermelho, circleAmarelo, circleVerde;

    private Timeline timeline;
    private int estado = 0; // 0 = vermelho, 1 = amarelo, 2 = verde

    @FXML
    private void initialize() {
        resetCores();
    }

    @FXML
    private void iniciar() {
        if (timeline != null && timeline.getStatus() == Timeline.Status.RUNNING) {
            return; // Já está rodando
        }

        timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> mudarCor()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    private void parar() {
        if (timeline != null) {
            timeline.stop();
        }
        resetCores();
        estado = 0;
    }

    private void mudarCor() {
        resetCores();
        switch (estado) {
            case 0 -> circleVermelho.setFill(javafx.scene.paint.Color.RED);
            case 1 -> circleAmarelo.setFill(javafx.scene.paint.Color.YELLOW);
            case 2 -> circleVerde.setFill(javafx.scene.paint.Color.GREEN);
        }
        estado = (estado + 1) % 3; // ciclo 0 → 1 → 2 → 0
    }

    private void resetCores() {
        circleVermelho.setFill(javafx.scene.paint.Color.GRAY);
        circleAmarelo.setFill(javafx.scene.paint.Color.GRAY);
        circleVerde.setFill(javafx.scene.paint.Color.GRAY);
    }
}
