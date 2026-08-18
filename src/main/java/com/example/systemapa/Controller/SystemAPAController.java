package com.example.systemapa.Controller;

import com.example.systemapa.Model.*;

import java.util.ArrayList;
import java.util.Comparator;

public class SystemAPAController {

    private StorageManager storageManager;

    public SystemAPAController() {
        storageManager = new StorageManager();
    }

    public ArrayList<Instrumento> getInstrumentos() {
        return storageManager.getInstrumentos();
    }

    // Registrar y eliminar simplemente delegan al StorageManager
    public void registrar(String nombre, String autor, Condicion condicion, Tipo tipo,
                          Proposito proposito, Boolean validez, String cita) {
        Instrumento nuevo = new Instrumento(nombre, autor, condicion, tipo, proposito, validez, cita);
        storageManager.registrarInstrumento(nuevo);
    }

    public void eliminar(int id) {
        storageManager.eliminarInstrumento(id);
    }

    // Introduce un autor y muestra todos los instrumentos de dicho autor
    public ArrayList<Instrumento> buscarPorAutor(String autor) {
        ArrayList<Instrumento> resultado = new ArrayList<>();
        storageManager.getInstrumentos().stream()
                .filter(instrumento -> instrumento.getAutor().equalsIgnoreCase(autor))
                .forEach(resultado::add);
        return resultado;
    }

    // Por propósito, por ejemplo "identificar" o "manejar"
    public ArrayList<Instrumento> buscarPorProposito(String proposito) {
        ArrayList<Instrumento> resultado = new ArrayList<>();
        storageManager.getInstrumentos().stream()
                .filter(instrumento -> instrumento.getProposito() != null
                        && instrumento.getProposito().name().equalsIgnoreCase(proposito))
                .forEach(resultado::add);
        return resultado;
    }

    // Por forma de instrumento: escala, cuestionario o test
    public ArrayList<Instrumento> buscarPorForma(String forma) {
        ArrayList<Instrumento> resultado = new ArrayList<>();
        storageManager.getInstrumentos().stream()
                .filter(instrumento -> instrumento.getTipo() != null
                        && instrumento.getTipo().name().equalsIgnoreCase(forma))
                .forEach(resultado::add);
        return resultado;
    }

    // Por condición: estrés, ansiedad o ambos
    public ArrayList<Instrumento> buscarPorCondicion(String condicion) {
        ArrayList<Instrumento> resultado = new ArrayList<>();
        storageManager.getInstrumentos().stream()
                .filter(instrumento -> instrumento.getCondicion() != null
                        && instrumento.getCondicion().name().equalsIgnoreCase(condicion))
                .forEach(resultado::add);
        return resultado;
    }

    // Por evaluación de validez y confiabilidad
    public ArrayList<Instrumento> buscarPorValidez(Boolean validez) {
        ArrayList<Instrumento> resultado = new ArrayList<>();
        storageManager.getInstrumentos().stream()
                .filter(instrumento -> instrumento.getValidez() != null
                        && instrumento.getValidez().equals(validez))
                .forEach(resultado::add);
        return resultado;
    }

    // Consultar los instrumentos de acuerdo a la condición y si están evaluados
    public ArrayList<Instrumento> buscarPorCondicionYValidez(String condicion, Boolean validez) {
        ArrayList<Instrumento> resultado = new ArrayList<>();
        storageManager.getInstrumentos().stream()
                .filter(instrumento -> instrumento.getCondicion() != null
                        && instrumento.getCondicion().name().equalsIgnoreCase(condicion)
                        && instrumento.getValidez() != null
                        && instrumento.getValidez().equals(validez))
                .forEach(resultado::add);
        return resultado;
    }

    // Todos ordenados por clave (id)
    public ArrayList<Instrumento> ordenarPorId() {
        ArrayList<Instrumento> resultado = new ArrayList<>();
        storageManager.getInstrumentos().stream()
                .sorted()
                .forEach(resultado::add);
        return resultado;
    }

    // Todos ordenados por primer autor
    public ArrayList<Instrumento> ordenarPorAutor() {
        ArrayList<Instrumento> resultado = new ArrayList<>();
        storageManager.getInstrumentos().stream()
                .sorted(Comparator.comparing(Instrumento::getAutor, String.CASE_INSENSITIVE_ORDER))
                .forEach(resultado::add);
        return resultado;
    }
}
