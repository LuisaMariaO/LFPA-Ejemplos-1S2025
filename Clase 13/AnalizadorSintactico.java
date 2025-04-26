/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author luisa
 */
public class AnalizadorSintactico {
    private List<Token> tokens;
    private List<Token> errores;
    HashMap<String, World> mundos; //<IDentificador del mundo, mundo>
    String mundoActual;
    
    public AnalizadorSintactico(List<Token> tokens){
        this.tokens = tokens;
        this.errores = new ArrayList<>();
        this.mundos = new HashMap<>();
        this.mundoActual = "";
    }
    
    public void agregarError(Token token){
        //this.errores.add(new Error(token.getLexema(), "No se esperaba el token "+token.getLexema(), token.getLinea(), token.getColumna(), "Sintáctico"));  
    }
    
    public void analizar(){
        this.INICIO();
        
        this.mundos.get(mundoActual).graficar();
    
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
                this.mundoActual = tmp.getLexema();
                this.mundos.put(mundoActual,new World());
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
        String identificador;
        String tipo;
        String x;
        String y;
        Token tmp = this.tokens.removeFirst();
        
        if(tmp.getTipo().equals("pr_place")){
            
            tmp = this.tokens.removeFirst();
            
            if(tmp.getTipo().equals("identificador")){
             //El nombre de la locacion
             identificador = tmp.getLexema();
                tmp = this.tokens.removeFirst();
                if(tmp.getTipo().equals("dos_puntos")){
                   tmp = this.tokens.removeFirst();
                   if(tmp.getTipo().equals("pr_locacion")){
                       //Tipo de locacion
                       tipo = tmp.getLexema();
                       tmp = this.tokens.removeFirst();
                       if(tmp.getTipo().equals("pr_at")){
                           tmp = this.tokens.removeFirst();
                           if(tmp.getTipo().equals("parentesis_abre")){
                               tmp = this.tokens.removeFirst();
                               if(tmp.getTipo().equals("numero")){
                                   //Coordenada x
                                   x = tmp.getLexema();
                                   tmp = this.tokens.removeFirst();
                                   if(tmp.getTipo().equals("coma")){
                                       tmp = this.tokens.removeFirst();
                                       if(tmp.getTipo().equals("numero")){
                                           //Coordenada y
                                           y = tmp.getLexema();
                                           tmp = this.tokens.removeFirst();
                                           
                                           if(tmp.getTipo().equals("parentesis_cierra")){
                                               //Crear una nueva locacion
                                               Place place = new Place(identificador, tipo, x, y);
                                               this.mundos.get(mundoActual).agregarPlace(identificador, place);
                                               return;
                                               
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

    public void CONEXIONES(){
        System.out.println("CONEXIONES");
    }
    public void OBJETOS(){}



    
}
