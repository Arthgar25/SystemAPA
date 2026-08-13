package com.example.systemapa;

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

    public StorageManager() {
        instrumentos = new ArrayList<>();
    }

    public ArrayList<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    public void registrarInstrumento(Instrumento instrumento) {
        instrumentos.add(instrumento);
    }

    public void eliminarInstrumento(int id) {
        for (Instrumento instrumento : instrumentos) {
            if (instrumento.getId() == id) {
                instrumentos.remove(instrumento);
            }
        };
    }

    /*
    TO-DO: Escribir los métodos relacionados a la escritura, lectura y actualizacion
    del archivo csv.

    Las acciones necesarias serían metodos para agregar un instrumento, eliminar un
    instrumento, leer (y guardar en la lista) el archivo completo en cada nueva sesión
    y actualizar la lista dentro del archivo en cada modificación para que los datos
    sean correctos en cada nuevo inicio de sesión.
     */

}
