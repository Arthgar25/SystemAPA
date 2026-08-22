package com.example.systemapa.View;

import com.example.systemapa.Controller.SystemAPAController;
import com.example.systemapa.Model.Condicion;
import com.example.systemapa.Model.CriterioBusqueda;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class NavBar extends HBox {
//     Título de la aplicacion
    private final Label name;
    // Campo de búsqueda para introducir el término
    private final TextField busqueda;

    private final Label ordenadoPor;

    private final CheckBox filtroValidez;

    private final QuickButton botonBusqueda;
    private final QuickButton clave;
    private final QuickButton autor;
    private final QuickButton mostrarTodos;

    // Botones de Radio a cambiar por botones regulares
    private final RadioButton filtroEstres;
    private final RadioButton filtroAnsiedad;
    private final RadioButton filtroAmbos;

    private final QuickButton botonBuscarCombinado;
    private final QuickButton buscarValidez;

    private final SystemAPAController controller;
    private final ListaPrincipal listaPrincipal;


    public NavBar(SystemAPAController controller,ListaPrincipal listaPrincipal) {
        this.listaPrincipal=listaPrincipal;
        this.controller=controller;
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(15);
        this.getStyleClass().add("nav-bar");

        name = new Label("SistemaAPA");
        name.getStyleClass().add("header");

        busqueda = new TextField();
        busqueda.setPromptText("");

        filtroValidez = new CheckBox("Con validez");
        filtroValidez.setSelected(true);

        filtroEstres = new RadioButton("Estrés");
        filtroAnsiedad = new RadioButton("Ansiedad");
        filtroAmbos = new RadioButton("Ambos");
        filtroEstres.setSelected(true);


        ordenadoPor = new Label("Ordenar por:");
        ordenadoPor.getStyleClass().add("not-bold");

        //Asignacion de botones
        botonBusqueda = new QuickButton("Buscar") {
            @Override
            protected void addAction() {
                listaPrincipal.mostrar(controller.terminoDeBusqueda(busqueda.getText()));
            }
        };

        mostrarTodos = new QuickButton("Mostrar todos") {
            @Override
            protected void addAction() {
                listaPrincipal.mostrar(controller.getInstrumentos());
            }
        };

        buscarValidez = new QuickButton("Validez") {
            @Override
            protected void addAction() {
                listaPrincipal.mostrar(controller.buscarPorValidez(filtroValidez.isSelected()));
            }
        };

        botonBuscarCombinado = new QuickButton("Condición + Validez") {
            @Override
            protected void addAction() {
                listaPrincipal.mostrar(controller.buscarPorCondicionYValidez(
                        obtenerCondicionFiltro(busqueda.getText()), filtroValidez.isSelected()));
            }
        };

        clave = new QuickButton("Clave") {
            @Override
            protected void addAction() {
                listaPrincipal.mostrar(controller.ordenarPorId());
            }
        };

        autor = new QuickButton("Autor") {
            @Override
            protected void addAction() {
                listaPrincipal.mostrar(controller.ordenarPorAutor());
            }
        };

        this.getChildren().addAll(name, mostrarTodos,
                busqueda, botonBusqueda, new Separator(Orientation.VERTICAL),
                ordenadoPor, clave, autor,
                new Separator(Orientation.VERTICAL), filtroValidez, buscarValidez,
                botonBuscarCombinado);
    }

    private String obtenerCondicionFiltro(String texto) {
        if (texto.equalsIgnoreCase(Condicion.ESTRES.name())) {
            return "ESTRES";
        } else if (texto.equalsIgnoreCase(Condicion.ANSIEDAD.name())) {
            return "ANSIEDAD";
        } else {
            return "AMBOS";
        }
    }
}
