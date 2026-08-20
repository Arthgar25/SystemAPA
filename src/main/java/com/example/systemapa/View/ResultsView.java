package com.example.systemapa.View;

import com.example.systemapa.Model.Instrumento;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ResultsView extends VBox {
    private final ListView<Instrumento> lista;

    public ResultsView() {
        lista = new ListView<>();
        this.getChildren().add(lista);
    }

    public void mostrar(ArrayList<Instrumento> instrumentos) {
        lista.getItems().setAll(instrumentos);
    }
}