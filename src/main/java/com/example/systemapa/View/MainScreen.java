package com.example.systemapa.View;

import com.example.systemapa.Controller.SystemAPAController;
import javafx.scene.layout.BorderPane;

public class MainScreen extends BorderPane {
    SideBar sideBar;
    NavBar navBar;
    ResultsView resultsView;

    public MainScreen(SystemAPAController controller) {
        resultsView = new ResultsView();
        sideBar = new SideBar(controller, resultsView);
        navBar = new NavBar(controller, resultsView);
        this.setStyle("-fx-background-color: white;");
        this.setTop(navBar);
        this.setLeft(sideBar);
        this.setCenter(resultsView);
    }

    public SideBar getSideBar() {
        return sideBar;
    }
    public NavBar getNavBar() {
        return navBar;
    }
    public  ResultsView getResultsView(){return resultsView;}
}
