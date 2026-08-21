package com.example.systemapa.View;

import com.example.systemapa.Controller.SystemAPAController;
import com.example.systemapa.Model.Instrumento;
import javafx.scene.layout.BorderPane;

public class MainScreen extends BorderPane {
    SideBar sideBar;
    NavBar navBar;
    ListaPrincipal listaPrincipal;

    public MainScreen(SystemAPAController controller) {
        listaPrincipal = new ListaPrincipal(controller);
        sideBar = new SideBar(controller, listaPrincipal);
        navBar = new NavBar(controller, listaPrincipal);
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
