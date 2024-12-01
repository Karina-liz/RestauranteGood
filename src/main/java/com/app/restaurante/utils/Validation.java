package com.app.restaurante.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase de utilidad para validaciones
 */
public class Validation {

    /**
     * Método que genera un hash MD5 de una contraseña
     */
    public static String md5(String contrasena) throws NoSuchAlgorithmException {
        // Obtiene una instancia del algoritmo MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        
        // Convierte la contraseña a bytes y genera el digest
        byte[] messageDigest = md.digest(contrasena.getBytes());
        
        // Convierte el array de bytes a representación hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            String hex = Integer.toHexString(0xFF & b);
            // Añade un 0 si el hex es de un solo dígito
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
