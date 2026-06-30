package com.mycompany.llanquihuetoursystem.util;

public class Validador {

    public static boolean validarRut(String rut) {
        if (rut == null || rut.isEmpty()) {
            return false;
        }
        return rut.matches("\\d{1,2}\\.\\d{3}\\.\\d{3}-[\\dkK]") || 
               rut.matches("\\d{7,8}-[\\dkK]");
    }

    public static boolean validarEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    public static boolean validarTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            return false;
        }
        return telefono.matches("\\+?[0-9]{9,12}");
    }
}