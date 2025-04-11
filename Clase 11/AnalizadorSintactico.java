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
public class AnalizadorSintactico {
    private List<Token> tokens;
    private List<Token> errores;
    
    public AnalizadorSintactico(List<Token> tokens){
        this.tokens = tokens;
        this.errores = new ArrayList<>();
    }
    
    public void agregarError(Token token){
        //this.errores.add(new Error(token.getLexema(), "No se esperaba el token "+token.getLexema(), token.getLinea(), token.getColumna(), "Sintáctico"));  
    }
    
    public void analizar(){
        this.INICIO();
    }
    
    public void INICIO(){
        System.out.println("INICIO");
        this.MUNDOS();
    }
    
    public void MUNDOS(){
        System.out.println("MUNDOS");
        this.MUNDO();
        this.MUNDOSP();
    }
    
    public void MUNDO(){
        System.out.println("MUNDO");
        Token tmp = this.tokens.removeFirst();
        
        if(tmp.getTipo().equals("pr_world")){
        //Continuamos
            tmp = this.tokens.removeFirst();
            
            if(tmp.getTipo().equals("cadena")){
                tmp = this.tokens.removeFirst();
                
                if(tmp.getTipo().equals("llave_abre")){
                    this.LOCACIONES();
                    this.CONEXIONES();
                    this.OBJETOS();
                    
                    tmp = this.tokens.removeFirst();
                    
                    if(tmp.getTipo().equals("llave_cierra")){
                        //Continuo
                        return;
                    }else{
                        //Agrego error
                    }
                }else{
                    //Agrego error
                }
            }else{
                //Agregar error
            }
        }else{
        //AGregar error
        }
    }
    
    public void MUNDOSP(){
        System.out.println("MUNDOSP");
        try{
            Token tmp = this.tokens.removeFirst();
            if(tmp.getTipo().equals("coma")){
                this.MUNDO();
                this.MUNDOSP();


            }else{
                //Agregar error
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        
        }
    }
    
    public void LOCACIONES(){
        this.LOCACION();
        this.LOCACIONESP();
    }
    
    public void LOCACION(){
        Token tmp = this.tokens.removeFirst();
        
        if(tmp.getTipo().equals("pr_place")){
            
            tmp = this.tokens.removeFirst();
            
            if(tmp.getTipo().equals("identificador")){
             
                tmp = this.tokens.removeFirst();
                if(tmp.getTipo().equals("dos_puntos")){
                
                }else{
                    //Error
                }
            }else{
                //Error
            }
        }else{
            //Error
        }
    }
    
    
    public void LOCACIONESP(){}

    public void CONEXIONES(){}
    public void OBJETOS(){}



    
}
