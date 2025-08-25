package com.example.bank;

public class Utils {

    /**
     * “Sanitizer” casero. Sonar no lo conoce por defecto.
     * Modificaremos la regla S2077 para **añadir** este método como sanitizador permitido.
     */
    public static String sanitize(String input) {
        if (input == null) return null;
        // Simulación: reemplazar comillas simples por comillas dobles (no es un sanitizer real)
        return input.replace("'", "\"");
    }
}
