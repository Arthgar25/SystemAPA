package com.example.systemapa.View;

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

    public NavBar() {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(15);
        this.getStyleClass().add("nav-bar");

        name = new Label("SistemaAPA");
        name.getStyleClass().add("header");

        busqueda = new TextField();
        busqueda.setPromptText("");

        botonBusqueda = new QuickButton("Buscar") {
            @Override
            protected void addAction() {

            }
        };

        ordenadoPor = new Label("Ordenar por:");
        ordenadoPor.getStyleClass().add("not-bold");

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
