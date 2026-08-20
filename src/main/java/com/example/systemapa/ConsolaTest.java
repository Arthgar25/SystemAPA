package com.example.systemapa;

import com.example.systemapa.Controller.SystemAPAController;
import com.example.systemapa.Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsolaTest {

    static SystemAPAController controller = new SystemAPAController();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1 -> registrar();
                case 2 -> mostrarLista(controller.getInstrumentos());
                case 3 -> buscarPorAutor();
                case 4 -> buscarPorProposito();
                case 5 -> buscarPorForma();
                case 6 -> buscarPorCondicion();
                case 7 -> buscarPorValidez();
                case 8 -> buscarPorCondicionYValidez();
                case 9 -> mostrarLista(controller.ordenarPorId());
                case 10 -> mostrarLista(controller.ordenarPorAutor());
                case 11 -> eliminar();
                case 0 -> System.out.println("Saliendo del sistema APA...");
                default -> System.out.println("Opción no válida, intenta de nuevo.");
            }

        } while (opcion != 0);
    }

    public static void mostrarMenu() {
        System.out.println("\n===== SISTEMA APA - INSTRUMENTOS =====");
        System.out.println("1. Registrar instrumento");
        System.out.println("2. Mostrar todos los instrumentos");
        System.out.println("3. Buscar por autor");
        System.out.println("4. Buscar por propósito (identificar/manejar)");
        System.out.println("5. Buscar por forma (escala/cuestionario/test)");
        System.out.println("6. Buscar por condición (estrés/ansiedad/ambos)");
        System.out.println("7. Buscar por validez");
        System.out.println("8. Buscar por condición y validez");
        System.out.println("9. Mostrar ordenados por clave (id)");
        System.out.println("10. Mostrar ordenados por autor");
        System.out.println("11. Eliminar instrumento por clave");
        System.out.println("0. Salir");
    }

    public static void registrar() {
        System.out.print("Nombre del instrumento: ");
        String nombre = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        Condicion condicion = leerCondicion();
        Tipo tipo = leerTipo();
        Proposito proposito = leerProposito();

        System.out.print("¿Tiene evaluación de validez y confiabilidad? (s/n): ");
        boolean validez = scanner.nextLine().trim().equalsIgnoreCase("s");

        String cita = null;
        if (validez) {
            System.out.print("Cita de la evaluación (DD/MM/AAAA): ");
            cita = scanner.nextLine();
        }

        controller.registrar(nombre, autor, condicion, tipo, proposito, validez, cita);
        System.out.println("Instrumento registrado.");
    }

    public static void eliminar() {
        int id = leerEntero("Clave del instrumento a eliminar: ");
        controller.eliminar(id);
        System.out.println("Instrumento eliminado (si existía).");
    }

    public static void buscarPorAutor() {
        System.out.print("Autor a buscar: ");
        mostrarLista(controller.buscarPorAutor(scanner.nextLine()));
    }

    public static void buscarPorProposito() {
        System.out.print("Propósito (IDENTIFICAR/MANEJAR): ");
        mostrarLista(controller.buscarPorProposito(scanner.nextLine()));
    }

    public static void buscarPorForma() {
        System.out.print("Forma (ESCALA/CUESTIONARIO/TEST): ");
        mostrarLista(controller.buscarPorForma(scanner.nextLine()));
    }

    public static void buscarPorCondicion() {
        System.out.print("Condición (ESTRES/ANSIEDAD/AMBOS): ");
        mostrarLista(controller.buscarPorCondicion(scanner.nextLine()));
    }

    public static void buscarPorValidez() {
        System.out.print("¿Buscar con validez? (s/n): ");
        boolean validez = scanner.nextLine().trim().equalsIgnoreCase("s");
        mostrarLista(controller.buscarPorValidez(validez));
    }

    public static void buscarPorCondicionYValidez() {
        System.out.print("Condición (ESTRES/ANSIEDAD/AMBOS): ");
        String condicion = scanner.nextLine();

        System.out.print("¿Con validez? (s/n): ");
        boolean validez = scanner.nextLine().trim().equalsIgnoreCase("s");

        mostrarLista(controller.buscarPorCondicionYValidez(condicion, validez));
    }

    public static void mostrarLista(ArrayList<Instrumento> lista) {
        if (lista.isEmpty()) {
            System.out.println("No se encontraron instrumentos.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Ingresa un número válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    public static Condicion leerCondicion() {
        System.out.println("Condición:");
        System.out.println("1. Estrés");
        System.out.println("2. Ansiedad");
        System.out.println("3. Ambos");

        int opcion = leerEntero("Elige una opción: ");
        while (opcion < 1 || opcion > 3) {
            opcion = leerEntero("Opción no válida, intenta de nuevo: ");
        }

        switch (opcion) {
            case 1: return Condicion.ESTRES;
            case 2: return Condicion.ANSIEDAD;
            default: return Condicion.AMBOS;
        }
    }

    public static Tipo leerTipo() {
        System.out.println("Forma del instrumento:");
        System.out.println("1. Escala");
        System.out.println("2. Cuestionario");
        System.out.println("3. Test");

        int opcion = leerEntero("Elige una opción: ");
        while (opcion < 1 || opcion > 3) {
            opcion = leerEntero("Opción no válida, intenta de nuevo: ");
        }

        switch (opcion) {
            case 1: return Tipo.ESCALA;
            case 2: return Tipo.CUESTIONARIO;
            default: return Tipo.TEST;
        }
    }

    public static Proposito leerProposito() {
        System.out.println("Propósito:");
        System.out.println("1. Identificar");
        System.out.println("2. Manejar");

        int opcion = leerEntero("Elige una opción: ");
        while (opcion < 1 || opcion > 2) {
            opcion = leerEntero("Opción no válida, intenta de nuevo: ");
        }

        return (opcion == 1) ? Proposito.IDENTIFICAR : Proposito.MANEJAR;
    }
}