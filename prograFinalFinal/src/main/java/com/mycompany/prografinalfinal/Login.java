package com.mycompany.prografinalfinal;

import javax.swing.JOptionPane;

public class Login {

    // Atributos
    private String usuario;
    private String contrasena;

    // Constructor
    public Login(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // Metodo para pedir el usuario y la contrasena y verificar si son válidos
    public boolean verificarCredenciales() {
        boolean inicioValido = false;

        while (!inicioValido) {
            String userIngresado = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
            String contraIngresada = JOptionPane.showInputDialog("Ingrese su contraseña:");

            if (usuario.equals(userIngresado) && contrasena.equals(contraIngresada)) {
                JOptionPane.showMessageDialog(null, "Credenciales correctas. Inicio de sesión exitoso.");
                inicioValido = true;
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Intente nuevamente.");
            }
        }
        return inicioValido;
    }
}
