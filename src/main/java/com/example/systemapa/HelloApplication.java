package com.example.systemapa;

import com.example.systemapa.Model.Instrumento;
import com.example.systemapa.Model.StorageManager;
import com.example.systemapa.View.MainScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class HelloApplication extends Application {
    StorageManager storageManager = new StorageManager();
    ArrayList<Instrumento> instrumentos = storageManager.getInstrumentos();

    @Override
    public void start(Stage stage) throws IOException {
        MainScreen root = new MainScreen();


        Scene scene = new Scene(root, 720, 480);
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

    // Introduce un autor y muestra todos los instrumentos de dicho autor
    public ArrayList<Instrumento> instrumentosDelAutor(String autor) {
        ArrayList<Instrumento> resultado = new ArrayList<>();
        instrumentos.forEach(instrumento -> {
            if (instrumento.getAutor().equalsIgnoreCase(autor)){
                resultado.add(instrumento);
            }
        });
        return resultado;
    }

    // Este puede necesitar una revisión, no entendí muy bien la instrucción.
    // Introduce por ejemplo "identificar" (por tipo) y muestra todos los instrumentos que identifican una condición
    public ArrayList<Instrumento> instrumentosIdentificar(String proposito) {
        ArrayList<Instrumento> resultado = new ArrayList<>();
        instrumentos.forEach(instrumento -> {
            if (instrumento.getProposito().name().equalsIgnoreCase(proposito)) {
                resultado.add(instrumento);
            }
        });
        return resultado;
    }

    // Por forma de instrumento, por ejemplo introduce "test" y mostrará los nombres de los instrumentos que son tests.
    public ArrayList<Instrumento> instrumentosDeForma(String forma) {
        ArrayList<Instrumento> resultado = new ArrayList<>();
        instrumentos.forEach(instrumento -> {
            if (instrumento.getTipo().name().equalsIgnoreCase(forma)){
                resultado.add(instrumento);
            }
        });
        return resultado;
    }

    // Por condición, introduce "estrés" y muestra todos los instrumentos referentes al estrés
    public ArrayList<Instrumento> instrumentosDeCondicion(String condicion) {
        ArrayList<Instrumento> resultado = new ArrayList<>();
        instrumentos.forEach(instrumento -> {
            if (instrumento.getCondicion().name().equalsIgnoreCase(condicion)){
                resultado.add(instrumento);
            }
        });
        return resultado;
    }

    // Por evaluación de validez y confiabilidad
    public ArrayList<Instrumento> instrumentosDeValidez(Boolean validez) {
        ArrayList<Instrumento> resultado = new ArrayList<>();
        instrumentos.forEach(instrumento -> {
            if (instrumento.getValidez()==validez){
                resultado.add(instrumento);
            }
        });
        return resultado;
    }

    /*
        TO-DO: ordenar la lista de los siguientes metodos con su parametro
         correspondiente para comparar.
        La neta llevo un chorro sin implementar un comparador, lo investigare y
        terminare el método, o si alguien se acuerda pues se lo avientan.
         */
    // Todos ordenados por clave
    public ArrayList<Instrumento> instrumentosOrdenadosPorId() {
        ArrayList<Instrumento> resultado = new ArrayList<>();
        instrumentos.stream().sorted().forEach(instrumento -> resultado.add(instrumento));
        return resultado;
    }

    // Todos ordenados por primer autor.
    public ArrayList<Instrumento> instrumentosOrdenadosPorAutor() {
        ArrayList<Instrumento> resultado = new ArrayList<>();

        instrumentos.stream()
                .sorted(Comparator.comparing(Instrumento::getAutor))
                .forEach(instrumento -> resultado.add(instrumento));

        return resultado;
    }

    /*
    TO-DO:
    Consultar los instrumentos de acuerdo a la condición y si estan evaluados
     */
    public ArrayList<Instrumento> instrumentosPorCondicionYValidez(String condicion, Boolean validez) {
        ArrayList<Instrumento> resultado = new ArrayList<>();
        instrumentos.forEach(instrumento -> {
            if (instrumento.getCondicion().name().equalsIgnoreCase(condicion)
                    && instrumento.getValidez().equals(validez)) {
                resultado.add(instrumento);
            }
        });
        return resultado;
    }
}
