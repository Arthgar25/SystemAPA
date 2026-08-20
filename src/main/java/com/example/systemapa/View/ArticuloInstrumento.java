package com.example.systemapa.View;

import com.example.systemapa.Model.Instrumento;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/*
Esta clase representa la parte visual donde se representará cada instrumento en el UI
 */
public class ArticuloInstrumento extends HBox {
    private Instrumento instrumento;
    private final Label nombre;
    private final Label autor;
    private final Label validez;
    private final Label cita;
    private final Label proposito;
    private final Label condicion;
    private final QuickButton botonBorrar;

    public ArticuloInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
        setAlignment(Pos.CENTER_LEFT);
        setSpacing(15);
        setPadding(new Insets(8, 12, 8, 12));
        getStyleClass().add("articulo-instrumento");

        nombre = new Label(instrumento.getNombre());

        autor = new Label(instrumento.getAutor());
        validez = new Label(instrumento.getValidez().toString());
        cita = new Label(instrumento.getCita().toString());
        proposito = new Label(instrumento.getProposito().toString());
        condicion = new Label(instrumento.getCondicion().toString());
        botonBorrar = new QuickButton("\u274C") {
            @Override
            protected void addAction() {

            }
        };
        getChildren().addAll(nombre, autor, validez, cita, proposito, condicion, botonBorrar);

    }
}
