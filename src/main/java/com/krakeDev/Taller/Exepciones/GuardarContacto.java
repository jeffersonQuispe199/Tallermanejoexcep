package com.krakeDev.Taller.Exepciones;

import java.io.FileWriter;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuardarContacto {
    private static final Logger log = LoggerFactory.getLogger(GuardarContacto.class);

    public static void guardar() {
        FileWriter fw = null; // Declarado fuera del try
        try {
            fw = new FileWriter("contactos.txt", true);
            fw.write("Nombre: Maria\n");
            fw.write("Apellido: Gomez\n");
            fw.write("Telefono: 0981234567\n");
            log.info("Contacto guardado exitosamente en contactos.txt");
        } catch (IOException e) {
            log.error("Error al escribir en el archivo: {}", e.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                log.error("Error al cerrar el FileWriter: {}", e.getMessage());
            }
        }
    }
}