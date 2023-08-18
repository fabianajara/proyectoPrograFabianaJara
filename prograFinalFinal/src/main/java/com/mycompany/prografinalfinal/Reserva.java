package com.mycompany.prografinalfinal;

public class Reserva {

    // Atributos
    private final int numPersonas;
    private final String deporte;
    private final String horario;
    private final String servicio;
    private final int numReservacion;
    private final String genero;

    // Atributos Extra
    private int cantTerapia;
    private int cantRecup;

    // Constructor
    public Reserva(int numPersonas, String deporte, String horario, String servicio, int numReservacion, String genero, int cantTerapia, int cantRecup) {
        this.numPersonas = numPersonas;
        this.deporte = deporte;
        this.horario = horario;
        this.servicio = servicio;
        this.numReservacion = numReservacion;
        this.genero = genero;
        this.cantTerapia = cantTerapia;
        this.cantRecup = cantRecup;
    }

    // Getters
    public int getNumPersonas() {
        return numPersonas;
    }

    public String getDeporte() {
        return deporte;
    }

    public String getHorario() {
        return horario;
    }

    public String getServicio() {
        return servicio;
    }

    public int getNumReservacion() {
        return numReservacion;
    }

    public String getGenero() {
        return genero;
    }

    public int getCantTerapia() {
        return cantTerapia;
    }

    public int getCantRecup() {
        return cantRecup;
    }

    // Metodo para mostrar datos de la reserva 
    public String mostrarCliente() {
        return "\nNúmero de reservación: " + numReservacion
                + "\nNúmero de personas: " + numPersonas
                + "\nDisciplina deportiva: " + deporte
                + "\nHorario: " + horario
                + "\nServicio: " + servicio
                + "\nGénero: " + genero + "\n";
    }
}
