package com.example.systemapa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    StorageManager storageManager = new StorageManager();
    ArrayList<Instrumento> instrumentos = storageManager.getInstrumentos();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    /*
    Esta sería la clase principal con acceso a un Storage manager y la lista completa.
    El storageManager sería para registrar y eliminar los nuevos instrumentos. Los
    métodos de la clase storageManager se encargarían de actualizar el archivo csv
    internamente. Los métodos de busqueda no supe si sería mejor implementarlos aqui
    o en la clase StorageManager o en alguna otra clase.
     */

    public ArrayList<Instrumento> instrumentosDelAutor(String autor) {
        ArrayList<Instrumento> instrumentosDelAutor = new ArrayList<>();
        for (Instrumento instrumento : instrumentos){
            if(instrumento.getAutor().equals(autor)){
                instrumentosDelAutor.add(instrumento);
            }
        }
        return instrumentosDelAutor;
    }

    // Este puede necesitar una revisión, no entendí muy bien la instrucción.
    public ArrayList<Instrumento> instrumentosIdentificar() {
        return instrumentos;
    }
    
}
