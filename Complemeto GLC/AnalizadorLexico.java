/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luisa
 */
public class AnalizadorLexico {
     private List<Token> tokens;
    private List<Error> errores;
    private int linea;
    private int columna;
    private String buffer;
    private int estado;
    private int i;
    
    public AnalizadorLexico(){
        this.tokens = new ArrayList<>();
        this.errores = new ArrayList<>();
    }
    
    public void agregarToken(String caracter, String token, int linea, int columna){
        this.tokens.add(new Token(caracter, linea, columna, token));
        this.buffer = "";
    }
    
    public void agregarError(String caracter, int linea, int columna){
        this.errores.add(new Error(caracter, "Caracter "+caracter+" no reconocido en el lenguaje", linea, columna, "Lexico"));
        this.buffer = "";
    }
    
    public void analizar(StringBuilder cadena){
        this.tokens.clear();
        this.errores.clear();
        this.estado = 0;
        this.i = 0;
        this.buffer = "";
    
        this.agregarToken("world", "pr_world", linea, columna);
        this.agregarToken("\"Isla del mistico\"", "cadena", linea, columna);
        this.agregarToken("{", "llave_abre", linea, columna);
        //Place
        this.agregarToken("place", "pr_place", linea, columna);
        this.agregarToken("Playa", "identificador", linea, columna);
        this.agregarToken(":", "dos_puntos", linea, columna);
        this.agregarToken("playa", "pr_locacion", linea, columna);
        this.agregarToken("at", "pr_at", linea, columna);
        this.agregarToken("(", "parentesis_abre", linea, columna);
        this.agregarToken("0", "numero", linea, columna);
        this.agregarToken(",", "coma", linea, columna);
        this.agregarToken("0", "numero", linea, columna);
        this.agregarToken(")", "parentesis_cierra", linea, columna);
        //Place
        this.agregarToken("place", "pr_place", linea, columna);
        this.agregarToken("Playa", "identificador", linea, columna);
        this.agregarToken(":", "dos_puntos", linea, columna);
        this.agregarToken("playa", "pr_locacion", linea, columna);
        this.agregarToken("at", "pr_at", linea, columna);
        this.agregarToken("(", "parentesis_abre", linea, columna);
        this.agregarToken("0", "numero", linea, columna);
        this.agregarToken(",", "coma", linea, columna);
        this.agregarToken("0", "numero", linea, columna);
        this.agregarToken(")", "parentesis_cierra", linea, columna);
        
        this.agregarToken("}", "llave_cierra", linea, columna);
        
        this.agregarToken(",", "coma", linea, columna);
        
        this.agregarToken("world", "pr_world", linea, columna);
        this.agregarToken("\"Isla del mistico\"", "cadena", linea, columna);
        this.agregarToken("{", "llave_abre", linea, columna);
        //Place
        this.agregarToken("place", "pr_place", linea, columna);
        this.agregarToken("Playa", "identificador", linea, columna);
        this.agregarToken(":", "dos_puntos", linea, columna);
        this.agregarToken("playa", "pr_locacion", linea, columna);
        this.agregarToken("at", "pr_at", linea, columna);
        this.agregarToken("(", "parentesis_abre", linea, columna);
        this.agregarToken("0", "numero", linea, columna);
        this.agregarToken(",", "coma", linea, columna);
        this.agregarToken("0", "numero", linea, columna);
        this.agregarToken(")", "parentesis_cierra", linea, columna);
        //Place
        this.agregarToken("place", "pr_place", linea, columna);
        this.agregarToken("Playa", "identificador", linea, columna);
        this.agregarToken(":", "dos_puntos", linea, columna);
        this.agregarToken("playa", "pr_locacion", linea, columna);
        this.agregarToken("at", "pr_at", linea, columna);
        this.agregarToken("(", "parentesis_abre", linea, columna);
        this.agregarToken("0", "numero", linea, columna);
        this.agregarToken(",", "coma", linea, columna);
        this.agregarToken("0", "numero", linea, columna);
        this.agregarToken(")", "parentesis_cierra", linea, columna);
        
        this.agregarToken("}", "llave_cierra", linea, columna);
    }
    
    
    public List<Token> getTokens(){
        return this.tokens;
    }
    
}
