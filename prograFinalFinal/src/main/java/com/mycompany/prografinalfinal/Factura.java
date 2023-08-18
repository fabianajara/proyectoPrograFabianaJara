package com.mycompany.prografinalfinal;

public class Factura {

    // Atributos
    private final String nombreCliente;
    private final String idCliente;
    private final int numReservacion;
    private final String disciplinaAtleta;
    private final int cantidadPersonas;
    private final String condicionPersonas;
    private final String horario;
    private final double monto;

    // Constructor
    public Factura(String nombreCliente, String idCliente, int numReservacion, String disciplinaAtleta, int cantidadPersonas, String condicionPersonas, String horario, double monto) {
        this.nombreCliente = nombreCliente;
        this.idCliente = idCliente;
        this.numReservacion = numReservacion;
        this.disciplinaAtleta = disciplinaAtleta;
        this.cantidadPersonas = cantidadPersonas;
        this.condicionPersonas = condicionPersonas;
        this.horario = horario;
        this.monto = monto;
    }

    // Metodo para mostrar facturas
    public void generarFactura() {
        System.out.println("\nFactura:");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Número de Identificación: " + idCliente);
        System.out.println("Número de Reservación: " + numReservacion);
        System.out.println("Disciplina del Atleta: " + disciplinaAtleta);
        System.out.println("Cantidad de Personas: " + cantidadPersonas);
        System.out.println("Condición de Personas: " + condicionPersonas);
        System.out.println("Horario: " + horario + "am");
        System.out.println("Monto a Pagar: $" + monto);
    }
}
