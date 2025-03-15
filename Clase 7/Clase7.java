/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author luisa
 */
public class Clase7 {

    public static void main(String[] args) {
       AnalizadorLexico analizador = new AnalizadorLexico();
       
       
       try {
    File archivo = new File("C:\\Users\\luisa\\OneDrive\\Documentos\\USAC\\Practicas finales\\LFP 2025\\EntradaProyecto1.txt");
    StringBuilder content = new StringBuilder();
    if (archivo.exists()) {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
            while ((linea = br.readLine()) != null) {
                content.append(linea).append("\n");
            }

        //System.out.println(content);
        analizador.analizar(content);
        
        analizador.imprimirTokens();
        System.out.println("");
        analizador.imprimirErrores();
    } else {
        System.out.println("El archivo no existe.");
    }
}
    catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
