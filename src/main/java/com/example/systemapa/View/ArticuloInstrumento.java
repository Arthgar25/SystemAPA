package com.example.systemapa.View;

import com.example.systemapa.Controller.SystemAPAController;
import com.example.systemapa.Model.Instrumento;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/*
Esta clase representa la parte visual donde se representará cada instrumento en el UI
 */
public class ArticuloInstrumento extends HBox {
    private final Instrumento instrumento;
    private final Label id;
    private final Label nombre;
    private final Label autor;
    private final Label forma;
    private final Label validez;
    private final Label cita;
    private final Label proposito;
    private final Label condicion;
    private final QuickButton botonBorrar;

    public ArticuloInstrumento(Instrumento instrumento, SystemAPAController controller, ListaPrincipal listaPrincipal) {
        this.instrumento = instrumento;
        setAlignment(Pos.CENTER_LEFT);
        setSpacing(15);
        setPadding(new Insets(8, 12, 8, 12));
        getStyleClass().add("articulo-instrumento");

        nombre = new Label(instrumento.getNombre());
        id = new Label(String.valueOf(instrumento.getId()));
        autor = new Label(instrumento.getAutor());
        forma = new Label(instrumento.getTipo().toString());
        validez = new Label(instrumento.getValidez().toString());
        cita = new Label(instrumento.getCita().toString());
        proposito = new Label(instrumento.getProposito().toString());
        condicion = new Label(instrumento.getCondicion().toString());
        botonBorrar = new QuickButton("\u274C") {
            @Override
            protected void addAction() {
                controller.eliminar(instrumento.getId());
                listaPrincipal.mostrar(controller.getInstrumentos());
            }
        };
        getChildren().addAll(id, nombre, autor, forma, condicion, proposito, validez, cita, botonBorrar);

    }
}
