package com.krakeDev.Taller.Exepciones;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    private static final Logger log = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        
        // ---------------------------------------------------------
        // PRUEBA 1: Teléfono inválido ("123")
        // Debe entrar al catch, registrar el error y no guardar nada
        // ---------------------------------------------------------
        System.out.println("=== PRUEBA 1: Teléfono \"123\" ===");
        try {
            ValidarContacto.validarTelefono("123");
            
            // Estas líneas no deberían ejecutarse si el teléfono no es válido
            GuardarContacto.guardar();
            LeerCantacto.leer();
            
        } catch (IllegalArgumentException e) {
            // Usar log.error si el teléfono es inválido[cite: 4]
            log.error("Error capturado: {}", e.getMessage());
        }

        System.out.println("\n--------------------------------------------------\n");

        // ---------------------------------------------------------
        // PRUEBA 2: Teléfono válido ("0981234567")
        // Debe validar, guardar y leer correctamente[cite: 4]
        // ---------------------------------------------------------
        System.out.println("=== PRUEBA 2: Teléfono \"0981234567\" ===");
        try {
            ValidarContacto.validarTelefono("0981234567");
            
            // Llamar a GuardarContacto para guardar en el archivo[cite: 4]
            GuardarContacto.guardar();
            
            // Luego llamar a LeerContacto para leer el archivo[cite: 4]
            LeerCantacto.leer();
            
            // Usar log.info si todo salió bien[cite: 4]
            log.info("Todo salió bien en la ejecución.");
            
        } catch (IllegalArgumentException e) {
            log.error("Error capturado: {}", e.getMessage());
        }
    }
}