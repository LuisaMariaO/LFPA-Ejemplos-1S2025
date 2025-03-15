/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author luisa
 */
public class Token {
    private String lexema;
    private int linea;
    private int columna;
    private String tipo;
    
    public Token(String lexema, int linea, int columna, String tipo){
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return("Token: "+this.tipo+" Lexema: "+this.lexema+" Linea: "+linea+" Columna: "+columna);
    }
    
}
