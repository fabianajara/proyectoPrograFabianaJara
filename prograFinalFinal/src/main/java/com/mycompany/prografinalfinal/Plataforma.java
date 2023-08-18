package com.mycompany.prografinalfinal;

import java.util.Random;
import javax.swing.JOptionPane;

public class Plataforma {

    // Atributo reservaciones que contiene todas las reservas
    public Reserva[] reservaciones;

    // Inicializar el objeto horario
    Horario funHorarios = new Horario();

    // Constructor: inicializar array y hacer reserva predeterminada
    public Plataforma() {
        this.reservaciones = new Reserva[1];

        // Crear PREDETERMINADO un objeto Cliente y asignar valores apropiados
        this.reservaciones[0] = new Reserva(0, "deporte", "hora", "servicio", 1, "genero", 0, 0);
    }

    // Metodo para mostrar las reservaciones hechas
    public void mostrarReservaciones() {
        System.out.println("\nReservaciones realizadas:");
        for (int i = 0; i < this.reservaciones.length; i++) {
            Reserva cliente = this.reservaciones[i];
            System.out.println(cliente.mostrarCliente());
        }
    }

    // Metodo que genera un número de reserva aleatorio
    public int generarNumReserva() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100);
        return numeroAleatorio;
    }

    // Metodo para eliminar una reserva por su número de reserva
    public void eliminarReservaPorNumero(int numeroReserva) {
        int indexAEliminar = -1;

        for (int i = 0; i < this.reservaciones.length; i++) {
            if (this.reservaciones[i].getNumReservacion() == numeroReserva) {
                indexAEliminar = i;
                break;
            }
        }

        if (indexAEliminar != -1) {
            Reserva[] nuevasReservaciones = new Reserva[this.reservaciones.length - 1];

            int j = 0;
            for (int i = 0; i < this.reservaciones.length; i++) {
                if (i != indexAEliminar) {
                    nuevasReservaciones[j] = this.reservaciones[i];
                    j++;
                }
            }
            this.reservaciones = nuevasReservaciones;

            if (numeroReserva != 1) {
                System.out.println("La reserva con número " + numeroReserva + " ha sido eliminada correctamente.");
            }
        } else {
            System.out.println("No se encontró ninguna reserva con el número " + numeroReserva + ".");
        }
    }

    // Metodo para hacer reserva
    public void hacerReserva() {

        // Eliminar reserva predeterminada
        eliminarReservaPorNumero(1);

        // Crear nuevo arreglo con un espacio adicional para la nueva reserva
        Reserva[] nuevasReservaciones = new Reserva[this.reservaciones.length + 1];

        // Copiar las reservas existentes al nuevo arreglo
        for (int i = 0; i < this.reservaciones.length; i++) {
            nuevasReservaciones[i] = this.reservaciones[i];
        }

        // Solicitar datos al ususario
        int cantPersonas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas: "));

        int hora = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el horaio elegido: "
                + "\n0. 8am"
                + "\n1. 9am"
                + "\n2. 10am"
                + "\n3. 11am"
                + "\n4. 12pm"
                + "\n5. 1pm"
                + "\n6. 2pm"
                + "\n7. 3pm"
                + "\n8. 4pm"
                + "\n9. 5pm"));
        int numReserva = generarNumReserva();
        int deporte = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Deporte: "
                + "\n0. FUTBOL \n1. BALONCESTO \n2. TENIS"));

        // Contadores para poder traducir los valores
        int terapia = 0;
        int recuperacion = 0;

        int hombres = 0;
        int mujeres = 0;

        // Datos para guarda en Horario
        for (int i = 0; i < cantPersonas; i++) {
            //AgregarReserva(int hora, int numReserva, int servicio, int genero, int deporte)

            int servicio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese servicio de la persona #" + cantPersonas + ": "
                    + "\n1. Terapia \n2. Recuperacion"));
            if (servicio == 1) {
                terapia += 1;
            } else if (servicio == 2) {
                recuperacion += 1;
            }
            int genero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese genero de la persona #" + cantPersonas + ": "
                    + "\n0. Hombre \n1. Mujer"));
            if (genero == 0) {
                hombres += 1;
            } else if (genero == 1) {
                mujeres += 1;
            }

            funHorarios.agregarReserva(hora, numReserva, servicio, genero, deporte);
        }

        // Traducir datos para almacenarlos en el arreglo de reservas
        String horaArreglo = " ";
        if (hora == 0) {
            horaArreglo = "8";
        } else if (hora == 1) {
            horaArreglo = "9";
        } else if (hora == 2) {
            horaArreglo = "10";
        } else if (hora == 3) {
            horaArreglo = "11";
        } else if (hora == 4) {
            horaArreglo = "12";
        } else if (hora == 5) {
            horaArreglo = "1";
        } else if (hora == 6) {
            horaArreglo = "2";
        } else if (hora == 7) {
            horaArreglo = "3";
        } else if (hora == 8) {
            horaArreglo = "4";
        } else if (hora == 9) {
            horaArreglo = "5";
        }

        String deporteArreglo = "";
        if (deporte == 0) {
            deporteArreglo = "Futbol";
        } else if (deporte == 1) {
            deporteArreglo = "Baloncesto";
        } else if (deporte == 2) {
            deporteArreglo = "Tenis";
        }

        String servicioArreglo = "";
        if (terapia != 0 && recuperacion != 0) {
            servicioArreglo = "Servicio Mixto";
        } else if (terapia != 0) {
            servicioArreglo = "Terapia";
        } else if (recuperacion != 0) {
            servicioArreglo = "Recuperacion";
        }

        String generoArreglo = "";
        if (hombres != 0 && mujeres != 0) {
            generoArreglo = "Genero Mixto";
        } else if (hombres != 0) {
            generoArreglo = "Hombre";
        } else if (mujeres != 0) {
            generoArreglo = "Mujer";
        }

        // Agregar la nueva reserva al final del nuevo arreglo
        nuevasReservaciones[nuevasReservaciones.length - 1] = new Reserva(cantPersonas, deporteArreglo, horaArreglo,
                servicioArreglo, numReserva, generoArreglo, terapia, recuperacion);

        // Asignar el nuevo arreglo de reservaciones al atributo reservaciones
        this.reservaciones = nuevasReservaciones;

        // Mostrar las reservas actualizadas
        mostrarReservaciones();

        System.out.println("La reserva se ha realizado correctamente!");

        mostrarTodosHorarios();

    }

    // Metodo para mostrar todos los horarios
    public void mostrarTodosHorarios() {
        funHorarios.mostrarHorarios();
    }

    //     MODULO FACTURAS 
    // Metodo para calcular monto
    public double calcularMonto(int numReserva) {
        double precioTerapia = 100; // Precio de una terapia
        double precioRecuperacion = 50; // Precio de una recuperación
        double montoTotal = 0;

        for (int i = 0; i < this.reservaciones.length; i++) {
            if (this.reservaciones[i].getNumReservacion() == numReserva) {
                int cantTerapia = this.reservaciones[i].getCantTerapia();
                int cantRecup = this.reservaciones[i].getCantRecup();

                if (this.reservaciones[i].getCantTerapia() != 0) {
                    montoTotal += precioTerapia * cantTerapia;
                } else if (this.reservaciones[i].getCantRecup() != 0) {
                    montoTotal += precioRecuperacion * cantRecup;
                }

            }
        }
        return montoTotal;
    }

    // Metodo para revisar si existe un # de factura para hacer la factura
    public void generarFacturaPlataforma() {
        boolean numCorrecto = false;

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
        String id = JOptionPane.showInputDialog("Ingrese el id del cliente: ");

        while (!numCorrecto) {
            int numReserva = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de reserva: "));

            for (int i = 0; i < this.reservaciones.length; i++) {
                if (this.reservaciones[i].getNumReservacion() == numReserva) {
                    numCorrecto = true;
                    double monto = calcularMonto(numReserva);

                    Factura factura = new Factura(nombre, id, numReserva,
                            this.reservaciones[i].getDeporte(),
                            this.reservaciones[i].getNumPersonas(),
                            this.reservaciones[i].getServicio(),
                            this.reservaciones[i].getHorario(), monto);

                    factura.generarFactura();
                    return;
                }
            }

            System.out.println("No se encontró la reserva con el número " + numReserva);
        }
    }

    // Prueba para llamar metodos
    public void llamarMetodosHoraio(int opcion) {
        if (opcion == 1) {
            System.out.println("\n\nInforme de cantidad de personas atendidas");
            funHorarios.informePersonasAtendidas();
            funHorarios.informeDeporteMasElegido();
        } else if (opcion == 2) {
            System.out.println("\n\nInforme de horario con mayor cantidad de personas");
            funHorarios.informeHorarioMayorAfluencia();
        } else if (opcion == 3) {
            System.out.println("\n\nInforme de horario con menor cantidad de personas");
            funHorarios.informeHorarioMenorAfluencia();
        }
    }
}
