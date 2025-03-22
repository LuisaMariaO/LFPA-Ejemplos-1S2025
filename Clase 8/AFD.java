/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luisa
 */
public class AFD {
    private String nombre;
    private String estadoInicial;
    private List<String> estadosFinales;
    private Map<String, Map<String, String>> transiciones;
    
    public AFD(String nombre){
        this.nombre = nombre;
        this.estadosFinales = new ArrayList<>();
        this.transiciones = new HashMap<>();
    }
    
    public void setInicial(String inicial)
    {
        this.estadoInicial = inicial;
    }
    
    public void agregarEstadoFinak(String estado){
        this.estadosFinales.add(estado);
    }
    
    public void agregarTransicion(String estadoActual, String entrada, String estadoDestino){
        transiciones.putIfAbsent(estadoActual, new HashMap<>());
        transiciones.get(estadoActual).put(entrada, estadoDestino);
        
    }
    
    public void graficar(){
        String dotFile = "C:\\Users\\luisa\\OneDrive\\Escritorio\\AFD.dot";
        String pngFile = "C:\\Users\\luisa\\OneDrive\\Escritorio\\AFD.png";
        
        try{
            FileWriter writer = new FileWriter(dotFile);
             writer.write("digraph G {\n");
             writer.write("rankdir=LR;\n");
                
             String transicionesTexto ="";
             String propiedadesTexto = "";
             
             for(Map.Entry<String, Map<String, String>> entry : this.transiciones.entrySet()){
                 String sInicial = entry.getKey();
                 if(this.estadosFinales.contains(sInicial)){
                     propiedadesTexto+=sInicial+"[shape=doublecircle]\n";
                 }else{
                      propiedadesTexto+=sInicial+"[shape=circle]\n";
                 }
                 
                 Map<String, String> transicion = entry.getValue();
                 
                 for(Map.Entry<String, String> entry2: transicion.entrySet()){
                     String etiqueta = entry2.getKey();
                     
                     String estadoFinal = entry2.getValue();
                     
                     transicionesTexto+=sInicial+"->"+estadoFinal+"[label="+etiqueta+"]\n";
                     
                     if(this.estadosFinales.contains(estadoFinal)){
                        propiedadesTexto+=estadoFinal+"[shape=doublecircle]\n";
                    }else{
                        propiedadesTexto+=estadoFinal+"[shape=circle]\n";
                    }
                 }

             }
             writer.write(transicionesTexto);
             writer.write(propiedadesTexto);
             writer.write("}"); //Fin
             writer.close();
        
        }catch (IOException e) {
            System.out.println("Error al escribir el archivo.");
            e.printStackTrace();
        }
        
        String[] comando = {"dot", "-Tpng", dotFile, "-o", pngFile};
        try{
            ProcessBuilder builder = new ProcessBuilder(comando);
            builder.inheritIO();
            Process proceso = builder.start();
            int exitCode = proceso.waitFor();
            
            if(exitCode == 0){
                System.out.println("Conversion completada");
            }else{
                System.err.println("Error en la conversion de codigo");
            }
        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
