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

    /**
     * @return the lexema
     */
    public String getLexema() {
        return lexema;
    }

    /**
     * @return the linea
     */
    public int getLinea() {
        return linea;
    }

    /**
     * @return the columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }
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
        return("Token: "+this.getTipo()+" Lexema: "+this.getLexema()+" Linea: "+getLinea()+" Columna: "+getColumna());
    }
    
}
