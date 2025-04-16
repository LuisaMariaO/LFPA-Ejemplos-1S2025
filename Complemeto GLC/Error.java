/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author luisa
 */
public class Error {
    private String caracter;
    private String descripcion;
    private int linea;
    private int columna;
    private String tipo; //Léxico o sintáctico
    
    public Error(String caracter, String descripcion, int linea, int columna, String tipo){
        this.caracter = caracter;
        this.descripcion= descripcion;
        this.linea = linea;
        this.columna = columna;
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return( this.descripcion+" Linea: "+linea+" Columna: "+columna);
    }
    
}
