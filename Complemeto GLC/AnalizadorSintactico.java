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
    
    /*
    SUGERENCIAS: Un hashMap que guarde los mundos <String,Mundo> <"Isla del mistico",Mundo>
                    Una clase Mundo que tenga una lista de locaciones y una lista de objetos
                   Una clase Locacion que guarde los atributos de las locaciones
                   Una clase Objeto que guarde los atributos de los objetos
    */
    
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
            if(this.tokens.get(0).getTipo().equals("coma")){
                this.tokens.removeFirst();
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
        System.out.println("LOCACIONES");
        this.LOCACION();
        this.LOCACIONESP();
    }
    
    public void LOCACION(){
        System.out.println("LOCACION");
        Token tmp = this.tokens.removeFirst();
        
        if(tmp.getTipo().equals("pr_place")){
            
            tmp = this.tokens.removeFirst();
            
            if(tmp.getTipo().equals("identificador")){
             //El nombre de la locacion
                tmp = this.tokens.removeFirst();
                if(tmp.getTipo().equals("dos_puntos")){
                   tmp = this.tokens.removeFirst();
                   if(tmp.getTipo().equals("pr_locacion")){
                       tmp = this.tokens.removeFirst();
                       if(tmp.getTipo().equals("pr_at")){
                           tmp = this.tokens.removeFirst();
                           if(tmp.getTipo().equals("parentesis_abre")){
                               tmp = this.tokens.removeFirst();
                               if(tmp.getTipo().equals("numero")){
                                   //Coordenada x
                                   tmp = this.tokens.removeFirst();
                                   if(tmp.getTipo().equals("coma")){
                                       tmp = this.tokens.removeFirst();
                                       if(tmp.getTipo().equals("numero")){
                                           //Coordenada y
                                           tmp = this.tokens.removeFirst();
                                           
                                           if(tmp.getTipo().equals("parentesis_cierra")){
                                               return;
                                               //Crear una nueva locacion
                                           }else{
                                               //Error
                                           }
                                       }else{
                                           //Error
                                       }
                                   }else{
                                       //Error
                                   }
                               }else{
                                   //Error
                               }
                           }else{
                               //Error
                           }
                       }else{
                           //Error
                       }
                   }else{
                   //Error
                   }
                
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
    
    
    public void LOCACIONESP(){
        System.out.println("LOCACIONESP");
        if(this.tokens.get(0).getTipo().equals("pr_place")){
            this.LOCACION();
            this.LOCACIONESP();
        }else{
            return;
        }
    }

    public void CONEXIONES(){}
    public void OBJETOS(){}



    
}
