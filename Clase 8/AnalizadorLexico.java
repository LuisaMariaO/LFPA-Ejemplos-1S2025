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
        this.errores.add(new Error(caracter, "Caracter "+caracter+" no reconocido en el lenguaje", linea, columna));
        this.buffer = "";
    }
    
    public void analizar(StringBuilder cadena){
        this.tokens.clear();
        this.errores.clear();
        this.estado = 0;
        this.i = 0;
        this.buffer = "";
        
        while(this.i < cadena.length()){
            if(this.estado == 0){
                S0(cadena.charAt(this.i));
            }
            else if(this.estado == 1){
                S1(cadena.charAt(this.i));
            }
            
            else if(this.estado == 3){
                S3(cadena.charAt(this.i));
            }
            else if(this.estado == 4){
                S4(cadena.charAt(this.i));
            }
            
            i = i+1;
        }
    }
    
    public void S0(char caracter){
        //Reconocimiento de símbolos (S2)
        
        if(caracter == '{'){
            this.agregarToken(String.valueOf(caracter), "llaveApertura", this.linea, this.columna);
            this.columna+=1;
        }
        else if(caracter == '}'){
            this.agregarToken(String.valueOf(caracter), "llaveCierre", this.linea, this.columna);
            this.columna+=1;
        }
        else if(caracter == ':'){
            this.agregarToken(String.valueOf(caracter), "dosPuntos", this.linea, this.columna);
            this.columna+=1;
        }
        else if(caracter == ','){
            this.agregarToken(String.valueOf(caracter), "coma", this.linea, this.columna);
            this.columna+=1;
        }
        else if(caracter == '='){
            this.agregarToken(String.valueOf(caracter), "igual", this.linea, this.columna);
            this.columna+=1;
        }
        else if(caracter == '('){
            this.agregarToken(String.valueOf(caracter), "parentesisAbre", this.linea, this.columna);
            this.columna+=1;
        }
        else if(caracter == ')'){
            this.agregarToken(String.valueOf(caracter), "parentesisCierra", this.linea, this.columna);
            this.columna+=1;
        }
        
        
        else if(Character.isLetter(caracter)){
            this.buffer+=caracter;
            this.columna+=1;
            this.estado = 1;
        }
        
        else if(caracter == '"'){
            this.buffer+=caracter;
            this.columna+=1;
            this.estado = 3;
        }
        
        else if(caracter == '-'){
            this.buffer+=caracter;
            this.columna+=1;
            this.estado = 4;
        }
        
        //Zona de caracteres especiales
        
        else if(caracter == '\n'){
            this.linea+=1;
            this.columna = 0;
        }
        else if(caracter == ' '){
            this.columna+=1;
        }
        else if(caracter == '\t'){
            this.columna += 4;                          
        }
        
        //Zona de errores
        else{
            this.buffer+= caracter;
            this.agregarError(String.valueOf(caracter), linea, columna);
            this.buffer ="";
            this.columna+=1;
        }
       
    }
    
    public void S1(char caracter){
        if(Character.isLetter(caracter) || Character.isDigit(caracter)){
            this.buffer+= caracter;
            this.columna+=1;
        }else{
          
            if(this.buffer.equals("descripcion") || this.buffer.equals("estados") || this.buffer.equals("inicial") || this.buffer.equals("finales") || this.buffer.equals("transiciones")){ //Todas las palabras reservadas
                this.agregarToken(this.buffer, "palabraReservada",linea, columna);
            }else{
                this.agregarToken(this.buffer, "identificador",linea, columna);
            }
        
            //this.agregarToken(this.buffer, "identificador",linea, columna);
            this.estado = 0;
            this.columna+=1;
            this.i -= 1; //Regreso el índice pues ya terminé de reconocer el identificador
        }
    }
    
    public void S3(char caracter){
        if(caracter != '"'){
            this.buffer+=caracter;
            this.columna+=1;
        }else{
            //Aceptación
            this.buffer+=caracter;
            this.agregarToken(this.buffer,"cadena",linea, columna);
            this.estado = 0;
            this.columna+=1;
        
        }
    }
    
    public void S4(char caracter){
        if(caracter == '>'){
            this.buffer+=caracter;
            this.agregarToken(buffer, "flecha", this.linea, this.columna);
            this.columna+=1;
            this.estado = 0;
        }
        
        else{
            this.buffer += caracter;
            this.agregarError(String.valueOf(caracter), linea, columna);
            this.columna+=1;
            this.estado = 0;
        }
    }
    
    
    public void imprimirTokens(){
        for(Token token: this.tokens){
            System.out.println(token);
        }
    }
    
    public void imprimirErrores(){
        for(Error error: this.errores){
            System.out.println(error);
        }
    }
    
    public List<Token> getTokens(){
        return this.tokens;
    }
    
    
}
