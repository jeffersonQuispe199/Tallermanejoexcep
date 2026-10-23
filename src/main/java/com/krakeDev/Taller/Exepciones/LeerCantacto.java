package com.krakeDev.Taller.Exepciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeerCantacto {
    private static final Logger log = LoggerFactory.getLogger(LeerCantacto.class);

    public static void leer() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("contactos.txt"));
            List<String> lineas = new ArrayList<>();
            String linea;
            
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }

            // Recorrer las líneas usando un bucle for
            for (int i = 0; i < lineas.size(); i++) {
                System.out.println(lineas.get(i));
            }

            log.info("Archivo leido correctamente.");
        } catch (FileNotFoundException e) {
            log.error("Excepcion capturada (FileNotFound): El archivo no existe. {}", e.getMessage());
        } catch (IOException e) {
            log.error("Excepcion capturada (IOException): Error de lectura. {}", e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                log.error("Error al cerrar el BufferedReader: {}", e.getMessage());
            }
        }
    }
}