package com.example.systemapa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StorageManager {

    /*
    Esta clase se encargaría de registrar o eliminar instrumentos de la
    lista principal de instrumentos. Tambien expone la lista principal
    para que la clase principal tenga acceso y pueda llamar los demás
    métodos.

    Este diseño podría mejorar porque creo que esta clase terminaría
    teniendo muchas responsabilidades, pero supongo que eso lo podemos
    ver después.
     */

    private ArrayList<Instrumento> instrumentos;

    //contador para la asignacion de clave
    private int contadorId;
    //Archivo donde se guardaran y leeran los instrumentos
    private static final String ARCHIVO_CSV = "instrumentos.csv";

    public StorageManager() {
        instrumentos = new ArrayList<>();
    }

    public ArrayList<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    public void registrarInstrumento(Instrumento instrumento) {
        instrumento.setId(contadorId);
        contadorId++;
        instrumentos.add(instrumento);
        guardarArchivo();
    }

    public void eliminarInstrumento(int id) {
        for (Instrumento instrumento : instrumentos) {
            if (instrumento.getId() == id) {
                instrumentos.remove(instrumento);
            }
        };
        guardarArchivo();
    }

    /*
    TO-DO: Escribir los métodos relacionados a la escritura, lectura y actualizacion
    del archivo csv.

    Las acciones necesarias serían metodos para agregar un instrumento, eliminar un
    instrumento, leer (y guardar en la lista) el archivo completo en cada nueva sesión
    y actualizar la lista dentro del archivo en cada modificación para que los datos
    sean correctos en cada nuevo inicio de sesión.
     */

    //Se escribe la lista completa de instrumentos en el archivo
    public void guardarArchivo(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_CSV))) {
            for (Instrumento instrumento : instrumentos) {
                //para escribir en el archivo primero se tiene
                //que convertir el instrumento a una linea de texto
                writer.write(convertirALinea(instrumento));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo" + e.getMessage());
        }
    }

    //Leera el archivo y llenará la lista de instrumentos
    public void leerArchivo(){}

    public String convertirALinea(Instrumento instrumento){
        return instrumento.toString();
    }
}
