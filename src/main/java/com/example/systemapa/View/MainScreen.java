package com.example.systemapa.View;

import javafx.scene.layout.BorderPane;

public class MainScreen extends BorderPane {
    SideBar sideBar;
    NavBar navBar;
    public MainScreen() {
        sideBar = new SideBar();
        navBar = new NavBar();
        this.setStyle("-fx-background-color: white;");
        this.setTop(navBar);
        this.setLeft(sideBar);
    }

    public SideBar getSideBar() {
        return sideBar;
    }
    public NavBar getNavBar() {
        return navBar;
    }
}
