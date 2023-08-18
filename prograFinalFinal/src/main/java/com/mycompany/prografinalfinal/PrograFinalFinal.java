package com.mycompany.prografinalfinal;

import javax.swing.JOptionPane;

public class PrograFinalFinal {

    public static void main(String[] args) {

        Login log1 = new Login("usuario", "contra123");
        Plataforma plataforma1 = new Plataforma();

        /*
        // Parte para iniciar con login
        if (log1.verificarCredenciales()) {

        }
        */

        // MENU PRINCIPAL
        boolean salir = false;

        while (!salir) {
            int opPrincipal = Integer.parseInt(JOptionPane.showInputDialog("MENU PRINCIPAL"
                    + "\nIngrese una opcion: "
                    + "\n1. Modulo Reservas"
                    + "\n2. Modulo Facturas"
                    + "\n3. Modulo Registros"
                    + "\n0. SALIR"));

            if (opPrincipal == 1) {
                int opReservas = Integer.parseInt(JOptionPane.showInputDialog("MENU RESERVAS"
                        + "\n1. Mostrar todas las reservaciones realizadas"
                        + "\n2. Hacer una nueva reservacion"
                        + "\n3. Eliminar una reservacion (numero reserva)"
                        + "\n4. Mostrar todos los horarios"
                        + "\n0. SALIR al menu principal"));
                if (opReservas == 1) {
                    plataforma1.mostrarReservaciones();
                } else if (opReservas == 2) {
                    plataforma1.hacerReserva();
                } else if (opReservas == 3) {
                    int numReserva = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la reserva que desea eliminar: "));
                    plataforma1.eliminarReservaPorNumero(numReserva);
                } else if (opReservas == 4) {
                    plataforma1.mostrarTodosHorarios();
                } else if (opReservas == 0) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un numero correcto");
                    break;
                }

            } else if (opPrincipal == 2) {
                int opFactura = Integer.parseInt(JOptionPane.showInputDialog("MENU FACTURAS"
                        + "\n1. Generar facturas"
                        + "\n0. SALIR al menu principal"));
                if (opFactura == 1) {
                    plataforma1.generarFacturaPlataforma();
                } else {
                    break;
                }

            } else if (opPrincipal == 3) {
                int opInforme = Integer.parseInt(JOptionPane.showInputDialog("MENU INFORMES"
                        + "\n1. Informe de cantidad de personas atendidas"
                        + "\n2. Informe de horario con mayor cantidad de personas"
                        + "\n3. Informe de horario con menor cantidad de personas"
                        + "\n0. SALIR al menu principal"));
                if (opInforme == 1) {
                    plataforma1.llamarMetodosHoraio(opInforme);
                } else if (opInforme == 2) {
                    plataforma1.llamarMetodosHoraio(opInforme);
                } else if (opInforme == 3) {
                    plataforma1.llamarMetodosHoraio(opInforme);
                } else {
                    break;
                }
            } else if (opPrincipal == 0) {
                salir = true;
                break;
            } else {
                System.out.println("Ingrese una opcion valida");
            }
        }

        /*
        // Prueba clase Horario
        Horario horario = new Horario();

        // Agregar reservas de prueba
        // AgregarReserva(int hora, int numReserva, int servicio, int genero, int deporte)
        horario.agregarReserva(0, 101, 1, 0, 0);
        horario.agregarReserva(0, 102, 2, 1, 1);
        horario.agregarReserva(1, 103, 1, 0, 2);
        horario.agregarReserva(2, 104, 2, 1, 0);
        horario.agregarReserva(2, 105, 1, 0, 1);

        // Mostrar horarios y generar informes
        horario.mostrarHorarios();
        System.out.println();
        horario.informePersonasAtendidas();
        System.out.println();
        horario.informeHorarioMayorAfluencia();
        System.out.println();
        horario.informeHorarioMenorAfluencia();
        System.out.println();
        horario.informeDeporteMasElegido();
         */
        /*
        Plataforma plat = new Plataforma();
        
        plat.hacerReserva();
        plat.mostrarReservaciones();
         */
    }
}
