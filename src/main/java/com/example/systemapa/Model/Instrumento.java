package com.example.systemapa.Model;


public class Instrumento implements Comparable {
    // Nombre del instrumento y su autor.
    private String nombre;
    private String autor;
    /*
    Enumeraciones para la condición y el tipo.
    Tengo la sospecha de que la profe nos va a poner a hacer un programa con javaFX
    y hay un dropbox del javaFX que nomas le pones la enumeración que usas y
    llena las opciones de la enumeración.
     */
    private Condicion condicion;    // Ansiedad, estrés o ambos.
    private Tipo tipo;              // Escala, cuestionario, test.
    private Proposito proposito;

    private Boolean validez;
    private String cita;
    private int id;

    /*
    Podríamos escribir un constructor que genere objetos con valores aleatorios
    predeterminados para facilitar llenar la lista principal y probar los métodos.
     */
    public Instrumento() {
        this.nombre = "";
        this.autor = "";
        this.condicion = null;
        this.tipo = null;
        this.validez = false;
        this.proposito = null;
        this.cita = null;
        this.id = 0;
    }

    public Instrumento(String nombre, String autor, Condicion condicion, Tipo tipo,Proposito proposito, Boolean validez, String cita) {
        this.nombre = nombre;
        this.autor = autor;
        this.condicion = condicion;
        this.tipo = tipo;
        this.proposito = proposito;

        /*
        Aqui puede ir una condición dependiente de validez, si no se cumple la cita
        se pone en null por default.
         */
        this.validez = validez;
        this.cita = cita;

        /* Podriamos escribir una manera de generar un id unico aqui
            por el momento, default a 0.
         */
        this.id = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Boolean getValidez() {
        return validez;
    }

    public void setValidez(Boolean validez) {
        this.validez = validez;
    }

    public Proposito getProposito(){
        return proposito;
    }

    public void setProposito(Proposito proposito) {
        this.proposito = proposito;
    }

    public String getCita() {
        return cita;
    }

    public void setCita(String cita) {
        this.cita = cita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public int compareTo(Object o) {
        Instrumento otro = (Instrumento) o;
        if (otro.getId() < id) {
            return 1;
        } else if (otro.getId() > id) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Autor: " + autor + " | Condición: " + condicion + " | Forma: " + tipo + " | Validez: " + validez + " | Cita: " + cita;
    }
}
