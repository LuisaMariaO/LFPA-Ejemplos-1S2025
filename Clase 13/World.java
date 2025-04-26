/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luisa
 */
public class World {
    HashMap<String, Place> locaciones; //<IDentificador del lugar, Lugar>
    HashMap<String, PlaceVisual> locacionesVisuales;
    public World(){
        locaciones = new HashMap<>();
        locacionesVisuales = new HashMap<>();
        this.locacionesVisuales.put("playa", new PlaceVisual("ellipse","lightblue"));
        this.locacionesVisuales.put("cueva", new PlaceVisual("box","gray")); 
        //Asi todos los de la tabla
        
    }
    
    
    public void agregarPlace(String identificador, Place place){
        this.locaciones.put(identificador, place);
    }
    
    public void graficar(){
        String dotFilePath = "C:\\Users\\luisa\\OneDrive\\Escritorio\\grafo.dot";
        String outputImagePath = "C:\\Users\\luisa\\OneDrive\\Escritorio\\grafo.png";
        
        String dotContent = "digraph G {\n";
        dotContent += "node [style=filled fontname=\"Noto Color Emoji\"];\n";
        dotContent += "graph [layout=neato, splines=true, overlap=false];\n";
        
        for (Map.Entry<String, Place> entry: locaciones.entrySet()){
            String identificador = entry.getKey();
            Place lugar = entry.getValue();
            
            PlaceVisual lugarVisual = this.locacionesVisuales.get(lugar.tipo);
            
            dotContent+=identificador+"[label=\""+identificador+"\", shape="+lugarVisual.getFigura()
                    +", fillcolor= "+lugarVisual.getColor()+", pos=\""+lugar.x+","+lugar.y+"!\"];";
        }
        
        dotContent+="}";
        
        
         try{ 
             FileWriter writer = new FileWriter(dotFilePath);
             writer.write(dotContent);
             writer.close(); // Muy importante
            }catch (IOException e) {
            System.out.println("Error al escribir el archivo.");
            e.printStackTrace();
        }
            
            String[] comando = {"dot", "-Tpng", dotFilePath, "-o", outputImagePath};
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
