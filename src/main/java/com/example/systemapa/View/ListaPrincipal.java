package com.example.systemapa.View;

import com.example.systemapa.Model.Instrumento;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ListaPrincipal extends ScrollPane {
    private VBox listaContenedor;
    private List<ArticuloInstrumento> articulos;

    public ListaPrincipal() {
        articulos = new ArrayList<>();
        listaContenedor = new VBox(10);
        listaContenedor.setPadding(new Insets(15));
        setContent(listaContenedor);
        setFitToWidth(true);
    }

    public void agregarArticulo(Instrumento nuevoArticulo) {
        ArticuloInstrumento articulo = new ArticuloInstrumento(nuevoArticulo);
        articulos.add(articulo);
        listaContenedor.getChildren().add(articulo);
    }

}
