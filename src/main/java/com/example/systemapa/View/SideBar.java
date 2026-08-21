package com.example.systemapa.View;

import com.example.systemapa.Controller.SystemAPAController;
import com.example.systemapa.Model.Condicion;
import com.example.systemapa.Model.Proposito;
import com.example.systemapa.Model.Tipo;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SideBar extends VBox {
    private ComboBox<Proposito> proposito;
    private ComboBox<Condicion> condicion;
    private HBox contenedorValidez;
    private Label labelValidez;
    private CheckBox validez;
    private TextField nombre;
    private TextField autor;
    private TextField cita;
    private QuickButton botonRegistrar;
    private ComboBox<Tipo> tipo;
    private SystemAPAController controller;
    private ListaPrincipal listaPrincipal;

    public SideBar(SystemAPAController controller,ListaPrincipal listaPrincipal) {
        this.controller=controller;
        this.listaPrincipal = listaPrincipal;
        // Estilos y dimensiones
        double sideBarWidth = 200;
        this.setPrefWidth(Double.valueOf(sideBarWidth));
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(15);
        this.getStyleClass().add("side-bar");


        // Nombre
        nombre = new TextField();
        nombre.setPromptText("Nombre");
        // Autor
        autor = new TextField();
        autor.setPromptText("Autor");
        // Validez
        contenedorValidez = new HBox();
        labelValidez = new Label("Validez");
        ;labelValidez.getStyleClass().add("not-bold");
        validez = new CheckBox();
        validez.setSelected(true);
        contenedorValidez.setSpacing(15);
        contenedorValidez.getChildren().addAll(labelValidez, validez);
        // Cita
        cita = new TextField();
        cita.setPromptText("Cita");

        // Proposito
        proposito = new ComboBox<>();
        proposito.getItems().addAll(Proposito.values());
        proposito.setPromptText("Proposito");
        proposito.setMaxWidth(Double.MAX_VALUE);

        // Condicion
        condicion = new ComboBox<>();
        condicion.getItems().addAll(Condicion.values());
        condicion.setPromptText("Condicion");
        condicion.setMaxWidth(Double.MAX_VALUE);

        //Tipo
        tipo = new ComboBox<>();
        tipo.getItems().addAll(Tipo.values());
        tipo.setPromptText("Forma");
        tipo.setMaxWidth(Double.MAX_VALUE);

        // Boton para registrar
        botonRegistrar = new QuickButton("Registrar") {
            @Override
            protected void addAction() {
                controller.registrar(nombre.getText(), autor.getText(), condicion.getValue(), tipo.getValue(),
                        proposito.getValue(), validez.isSelected(), cita.getText());
                listaPrincipal.mostrar(controller.getInstrumentos());
            }
        };

        this.getChildren().addAll(nombre, autor, contenedorValidez, cita, proposito, condicion, tipo, botonRegistrar);

    }


}
