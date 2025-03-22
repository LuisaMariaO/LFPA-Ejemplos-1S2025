/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luisa
 */
public class Clase8 {
    private static Map<String, AFD> automatas;
  

    public static void main(String[] args) {
        AnalizadorLexico analizador = new AnalizadorLexico();
       automatas = new HashMap<>();
       
       try {
    File archivo = new File("C:\\Users\\luisa\\OneDrive\\Documentos\\USAC\\Practicas finales\\LFP 2025\\EntradaGrafica.txt");
    StringBuilder content = new StringBuilder();
    if (archivo.exists()) {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
            while ((linea = br.readLine()) != null) {
                content.append(linea).append("\n");
            }

        //System.out.println(content);
        analizador.analizar(content);
        
        //analizador.imprimirTokens();
        //System.out.println("");
        //analizador.imprimirErrores();
        
        List<Token> tokens = analizador.getTokens();
        //Recorrer la lista de tokens devuelta por el analizador léxico
        int i = 0;
        while(i < tokens.size()){
            if(tokens.get(i).getTipo().equals("identificador") && tokens.get(i+1).getTipo().equals("dosPuntos")){
                String nombre = tokens.get(i).getLexema();
                AFD afd = new AFD(nombre);
                
                i+=2;//Avanzo al token después de dosPuntos
                
                if(tokens.get(i).getTipo().equals("palabraReservada") && tokens.get(i).getLexema().equals("inicial")){
                    //Avanzo hasta después de dosPuntos
                    i+=2;
                    
                    afd.setInicial(tokens.get(i).getLexema());
                    i+=2; 
                }
                
                if(tokens.get(i).getTipo().equals("palabraReservada") && tokens.get(i).getLexema().equals("finales")){
                    i+=3;
                    while(!tokens.get(i).getTipo().equals("parentesisCierra")){
                        afd.agregarEstadoFinak(tokens.get(i).getLexema());
                        
                        if(tokens.get(i+1).getTipo().equals("coma")){
                            i+=2;
                        }else{
                            i+=1;
                        }
                    }
                    
                }
                
                i+=2;
                
                if(tokens.get(i).getTipo().equals("palabraReservada") && tokens.get(i).getLexema().equals("transiciones")){
                    i+=1;
                    
                    while(!tokens.get(i+1).getTipo().equals("llaveCierre")){
                        i+=2;
                        
                        String estadoActual = tokens.get(i).getLexema();
                        
                        i+=3;
                        
                        while(!tokens.get(i).getTipo().equals("parentesisCierra")){
                            String entrada = tokens.get(i).getLexema();
                            
                            i+=2;
                            String estadoDestino = tokens.get(i).getLexema();
                            
                            afd.agregarTransicion(estadoActual, entrada, estadoDestino);
                            
                            if(tokens.get(i+1).getTipo().equals("coma")){
                                i+=2;
                            } else{
                                i+=1;
                            }
                        }
                    }
                }
                
                automatas.put(nombre, afd);
                
            }
            
            i++;
        }
        
        automatas.get("AFD1").graficar();
    } else {
        System.out.println("El archivo no existe.");
    }
}
    catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
