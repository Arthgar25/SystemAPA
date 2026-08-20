package com.example.systemapa.View;

import com.example.systemapa.Controller.SystemAPAController;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class NavBar extends HBox {
    private final Label name;
    private final TextField busqueda;
    private final QuickButton botonBusqueda;
    private final Label ordenadoPor;
    private final QuickButton clave;
    private final QuickButton autor;
    private final SystemAPAController controller;
    private final ResultsView resultsView;

    public NavBar(SystemAPAController controller,ResultsView resultsView) {
        this.resultsView=resultsView;
        this.controller=controller;
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(15);
        this.setStyle("-fx-background-color: #252526; -fx-padding: 10px 20px; -fx-border-color: #333333; -fx-border-width: 0 0 1 0;");

        name = new Label("SistemaAPA");
        name.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 16px; -fx-font-weight: bold;");

        busqueda = new TextField();
        busqueda.setPromptText("");

        botonBusqueda = new QuickButton("Buscar") {
            @Override
            protected void addAction() {

            }
        };

        ordenadoPor = new Label("Ordenar por:");

        ordenadoPor.setStyle("-fx-text-fill: white;");
        clave = new QuickButton("Clave") {
            @Override
            protected void addAction() {

            }
        };

        autor = new QuickButton("Autor") {
            @Override
            protected void addAction() {

            }
        };

        this.getChildren().addAll(name, busqueda, botonBusqueda, new Separator(Orientation.VERTICAL), ordenadoPor, clave, autor);
    }

}
