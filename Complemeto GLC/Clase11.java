/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

/**
 *
 * @author luisa
 */
public class Clase11 {

    public static void main(String[] args) {
        AnalizadorLexico analizadorLexico = new AnalizadorLexico();
        analizadorLexico.analizar(new StringBuilder());
        
        AnalizadorSintactico analizadorSintactico = new AnalizadorSintactico(analizadorLexico.getTokens());
        analizadorSintactico.analizar();
    
    }
}
