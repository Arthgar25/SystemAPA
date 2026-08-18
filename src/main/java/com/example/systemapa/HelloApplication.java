package com.example.systemapa;

import com.example.systemapa.Controller.SystemAPAController;
import com.example.systemapa.View.MainScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    SystemAPAController controller = new SystemAPAController();

    @Override
    public void start(Stage stage) throws IOException {
        MainScreen root = new MainScreen();


        Scene scene = new Scene(root, 720, 480);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    /*
    Ahora HelloApplication solo se encarga de crear el controlador y
    lanzar la ventana. Toda la lógica de búsqueda y registro vive en
    SystemAPAController, así que cuando conectemos los botones de
    SideBar (por ejemplo botonRegistrar), deberán llamar a los métodos
    de controller en vez de tener su propia lógica.
     */

}
