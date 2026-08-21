package com.example.systemapa.View;

import com.example.systemapa.Controller.SystemAPAController;
import com.example.systemapa.Model.CriterioBusqueda;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class NavBar extends HBox {
    private final Label name;
    private final TextField busqueda;
    private final QuickButton botonBusqueda;
    private final Label ordenadoPor;
    private final QuickButton clave;
    private final QuickButton autor;
    private final QuickButton mostrarTodos;
    private final CheckBox filtroValidez;
    private final RadioButton filtroEstres;
    private final RadioButton filtroAnsiedad;
    private final RadioButton filtroAmbos;
    private final ToggleGroup grupoFiltroCondicion;
    private final CheckBox filtroValidezCombinada;
    private final QuickButton botonBuscarCombinado;
    private final QuickButton buscarValidez;
    private final SystemAPAController controller;
    private final ListaPrincipal listaPrincipal;
    private final RadioButton porAutor;
    private final RadioButton porForma;
    private final RadioButton porCondicion;
    private final RadioButton porProposito;
    private final ToggleGroup grupoCriterio;

    public NavBar(SystemAPAController controller,ListaPrincipal listaPrincipal) {
        this.listaPrincipal=listaPrincipal;
        this.controller=controller;
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(15);
        this.getStyleClass().add("nav-bar");
        grupoCriterio = new ToggleGroup();
        porAutor = new RadioButton("Autor");
        porForma = new RadioButton("Forma");
        porCondicion = new RadioButton("Condición");
        porProposito = new RadioButton("Propósito");

        //Asignacion de los botones al ToggleGroup
        porAutor.setToggleGroup(grupoCriterio);
        porForma.setToggleGroup(grupoCriterio);
        porCondicion.setToggleGroup(grupoCriterio);
        porProposito.setToggleGroup(grupoCriterio);

        // Asignamos uno default para que no pueda buscar sin ni un criterio
        porAutor.setSelected(true);

        name = new Label("SistemaAPA");
        name.getStyleClass().add("header");

        busqueda = new TextField();
        busqueda.setPromptText("");

        filtroValidez = new CheckBox("Con validez");
        filtroValidez.setSelected(true);

        // Condicion y validez
        grupoFiltroCondicion = new ToggleGroup();
        filtroEstres = new RadioButton("Estrés");
        filtroAnsiedad = new RadioButton("Ansiedad");
        filtroAmbos = new RadioButton("Ambos");
        filtroEstres.setToggleGroup(grupoFiltroCondicion);
        filtroAnsiedad.setToggleGroup(grupoFiltroCondicion);
        filtroAmbos.setToggleGroup(grupoFiltroCondicion);
        filtroEstres.setSelected(true);

        filtroValidezCombinada = new CheckBox("Con validez(combinado)");
        filtroValidezCombinada.setSelected(true);

        //Asignacion de botones
        botonBusqueda = new QuickButton("Buscar") {
            @Override
            protected void addAction() {
                CriterioBusqueda criterio = obtenerCriterioSeleccionado();
                listaPrincipal.mostrar(controller.buscar(criterio, busqueda.getText()));
            }
        };

        ordenadoPor = new Label("Ordenar por:");
        ordenadoPor.getStyleClass().add("not-bold");

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
                        obtenerCondicionFiltro(), filtroValidezCombinada.isSelected()));
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
        this.getChildren().addAll(name, porAutor, porForma, porCondicion, porProposito,
                busqueda, botonBusqueda, new Separator(Orientation.VERTICAL),
                ordenadoPor, clave, autor, mostrarTodos,
                new Separator(Orientation.VERTICAL), filtroValidez, buscarValidez,
                new Separator(Orientation.VERTICAL), filtroEstres, filtroAnsiedad, filtroAmbos,
                filtroValidezCombinada, botonBuscarCombinado);
    }

    private CriterioBusqueda obtenerCriterioSeleccionado() {
        if (porAutor.isSelected()) {
            return CriterioBusqueda.AUTOR;
        } else if (porForma.isSelected()) {
            return CriterioBusqueda.FORMA;
        } else if (porCondicion.isSelected()) {
            return CriterioBusqueda.CONDICION;
        } else {
            return CriterioBusqueda.PROPOSITO;
        }
    }

    private String obtenerCondicionFiltro() {
        if (filtroEstres.isSelected()) {
            return "ESTRES";
        } else if (filtroAnsiedad.isSelected()) {
            return "ANSIEDAD";
        } else {
            return "AMBOS";
        }
    }
}
