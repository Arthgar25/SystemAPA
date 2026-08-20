package com.example.systemapa.View;

import com.example.systemapa.Model.Instrumento;
import javafx.scene.layout.BorderPane;

public class MainScreen extends BorderPane {
    SideBar sideBar;
    NavBar navBar;
    ListaPrincipal listaPrincipal;

    public MainScreen() {
        sideBar = new SideBar();
        navBar = new NavBar();
        listaPrincipal = new ListaPrincipal();
        listaPrincipal.agregarArticulo(new Instrumento());
        this.setStyle("-fx-background-color: white;");
        this.setTop(navBar);
        this.setLeft(sideBar);
        this.setCenter(listaPrincipal);
    }

    public SideBar getSideBar() {
        return sideBar;
    }
    public NavBar getNavBar() {
        return navBar;
    }
}
