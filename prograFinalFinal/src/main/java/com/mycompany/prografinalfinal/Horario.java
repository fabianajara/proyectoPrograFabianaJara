package com.mycompany.prografinalfinal;

import java.util.Arrays;

public class Horario {

    private Integer[][] horarios = new Integer[10][4]; // 10 Horarios con 4 espacios cada uno
    //  [0] -> 8am, [1] -> 9am...
    private int[][] contadores = new int[10][2]; // 10 Horarios con 2 tipos de servicio disponible
    //  [1] -> Terapia, [2] -> Recuperacion
    private int contHombres;
    private int contMujeres;
    private int[] deporteContadores = new int[3]; // [0] -> FUTBOL, [1] -> BALONCESTO, [2] -> TENIS

    // Contadores Extra
    private int contTerapiaTotal = 0;
    private int contRecupTotal = 0;

    //  inicializar la instancia de la clase Horario
    public Horario() {
        for (int i = 0; i < 10; i++) {
            horarios[i] = new Integer[4]; // 4 espacios diosponibles
            contadores[i] = new int[2]; //2 servicios
        }
    }

    // Metodo para guardar la cita en el horario
    public void agregarReserva(int hora, int numReserva, int servicio, int genero, int deporte) {
        if (hora < 0 || hora >= 10) { // Verifica si la hora es valida
            System.out.println("Hora inválida.");
            return;
        }

        // Accede al horario y contador correspondientes a la hora especificada
        Integer[] horario = horarios[hora];
        int[] contador = contadores[hora];
        int terapia = contador[0]; // Cantidad de reservas de terapia
        int recuperacion = contador[1]; // Cantidad de reservas de recuperacion

        // Verifica si hay espacio disponible para el servicio en la hora elegida
        if (espacioServicio(terapia, recuperacion, servicio)) {
            // Recorre los espacios en el horario para encontrar un lugar disponible
            for (int i = 0; i < horario.length; i++) {
                // Si el espacio esta vacio guarda la reserva en el horario
                if (horario[i] == null) {
                    horario[i] = numReserva;
                    contador[servicio - 1]++; // Aumenta el contador correspondiente al servicio
                    
                    // Actualiza contadores según el género de la persona que reserva
                    if (genero == 0) {
                        contHombres++;
                    } else if (genero == 1) {
                        contMujeres++;
                    }
                    // Incrementa el contador del deporte elegido
                    deporteContadores[deporte]++;
                    break;
                }
            }
        } else {
            System.out.println("No hay espacio para realizar este servicio en este horario.");
        }
    }

    // Metodo para revisar espacio por servicios
    public boolean espacioServicio(int terapia, int recuperacion, int servicio) {
        if (servicio == 1) { // Verifica si el servicio es Terapia
        // Devuelve true si hay menos de 3 reservas de terapia y menos de 1 reserva de recuperacion
            return (terapia < 3 && recuperacion < 1);
        } else if (servicio == 2) { // Verifica si el servicio es Recuperación
        // Devuelve true si hay menos de 4 reservas de recuperacion
            return (recuperacion < 4);
        }
        // Si el servicio no es Terapia ni Recuperacion devuelve false
        return false;
    }

    // Metodo para actualizar los contadores globales según el servicio
    public void actualizarContadores(int servicio) {
        if (servicio == 1) {
            contTerapiaTotal++;
        } else if (servicio == 2) {
            contRecupTotal++;
        }
    }

    // Metodo para mostrar todos los horarios 
    public void mostrarHorarios() {
        String[] horas = {"8AM", "9AM", "10AM", "11AM", "12PM", "1PM", "2PM", "3PM", "4PM", "5PM"};
        System.out.println("Horarios:");
        for (int i = 0; i < 10; i++) {
            System.out.println(horas[i] + ": " + Arrays.toString(horarios[i]));
        }
    }

    //     MODULO INFORME
    // Metodo para mostrar imforme de personas atendidas
    public void informePersonasAtendidas() {
        int totalPersonas = 0;
        for (int i = 0; i < 10; i++) {
            totalPersonas += contadores[i][0] + contadores[i][1];
        }
        System.out.println("Informe de Personas Atendidas:");
        System.out.println("Total de personas atendidas: " + totalPersonas);
        System.out.println("Hombres atendidos: " + contHombres);
        System.out.println("Mujeres atendidas: " + contMujeres);
    }

    // Metodo para calcular el horario con mayoe afluencia
    public void informeHorarioMayorAfluencia() {
        int maxAfluencia = 0;
        String horarioMaxAfluencia = "";

        // Arreglo  horas que contiene una lista de las horas del día 
        String[] horas = {"8AM", "9AM", "10AM", "11AM", "12PM", "1PM", "2PM", "3PM", "4PM", "5PM"};

        // Recorre las horas del día para encontrar el horario con mas citas guardadas
        for (int i = 0; i < 10; i++) {
            // Calcula la afluencia + los contadores de terapia y recuperacion
            int afluencia = contadores[i][0] + contadores[i][1];
            // Compara la afluencia actual con el maximo encontrado hasta el momento
            if (afluencia > maxAfluencia) {
                // Si la afluencia actual es mayor actualiza el maximo y el horario
                maxAfluencia = afluencia;
                horarioMaxAfluencia = horas[i];
            }
        }

        System.out.println("Informe de Horario con Mayor Afluencia:");
        System.out.println("Horario con mayor afluencia: " + horarioMaxAfluencia);
        System.out.println("Cantidad de personas atendidas: " + maxAfluencia);
    }

    // Metodo para calcular el horario con menor afluencia
    public void informeHorarioMenorAfluencia() {
        int minAfluencia = Integer.MAX_VALUE;
        String horarioMinAfluencia = "";

        // Arreglo  horas que contiene una lista de las horas del día 
        String[] horas = {"8AM", "9AM", "10AM", "11AM", "12PM", "1PM", "2PM", "3PM", "4PM", "5PM"};

        // Recorre las horas del día para encontrar el horario con menos citas guardadas
        for (int i = 0; i < 10; i++) {
            // Calcula la afluencia + los contadores de terapia y recuperacion
            int afluencia = contadores[i][0] + contadores[i][1];
            // Compara la afluencia actual con el minimo encontrado hasta el momento
            if (afluencia < minAfluencia) {
                // Si la afluencia actual es menor actualiza el minimo y el horario
                minAfluencia = afluencia;
                horarioMinAfluencia = horas[i];
            }
        }

        System.out.println("Informe de Horario con Menor Afluencia:");
        System.out.println("Horario con menor afluencia: " + horarioMinAfluencia);
        System.out.println("Cantidad de personas atendidas: " + minAfluencia);
    }

    // Metodo que calcula el deporte mas elegido
    public void informeDeporteMasElegido() {
        String[] deportes = {"FUTBOL", "BALONCESTO", "TENIS"};
        int maxElegido = 0;
        String deporteMasElegido = "";

        for (int i = 0; i < 3; i++) {
            // Compara la cantidad de veces que se ha elegido un deporte con el máximo elegido hasta ahora
            if (deporteContadores[i] > maxElegido) {
                // Actualiza el máximo elegido y el deporte más elegido
                maxElegido = deporteContadores[i];
                deporteMasElegido = deportes[i];
            }
        }

        System.out.println("Deporte más elegido: " + deporteMasElegido);
        System.out.println("Cantidad de veces elegido: " + maxElegido);
    }
}
