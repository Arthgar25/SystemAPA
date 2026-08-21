package com.example.systemapa.View;

import com.example.systemapa.Controller.SystemAPAController;
import com.example.systemapa.Model.Instrumento;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ListaPrincipal extends ScrollPane {
    private final VBox listaContenedor;
    private final List<ArticuloInstrumento> articulos;
    private final SystemAPAController controller;

    public ListaPrincipal(SystemAPAController controller) {
        this.controller = controller;
        articulos = new ArrayList<>();
        listaContenedor = new VBox(10);
        listaContenedor.setPadding(new Insets(15));
        setContent(listaContenedor);
        setFitToWidth(true);
        mostrar(controller.getInstrumentos());
    }

    public void mostrar(ArrayList<Instrumento> instrumentos) {
        listaContenedor.getChildren().clear();
        articulos.clear();
        for (Instrumento instrumento : instrumentos) {
            ArticuloInstrumento articulo = new ArticuloInstrumento(instrumento, controller, this);
            articulos.add(articulo);
            listaContenedor.getChildren().add(articulo);
        }
    }
}
