/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author luisa
 */
public class Place {
    String identificador;
    String tipo; //volcan, templo, jungla, etc.
    String x;
    String y;
    
    public Place(String identificador, String tipo, String x, String y){
        this.identificador = identificador;
        this.tipo = tipo;
        this.x = x;
        this.y = y;
    }
    
}
