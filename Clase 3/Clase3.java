/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.*;

/**
 *
 * @author luisa
 */
public class Clase3 {
    ArrayList<Estudiante> estudiantes = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        Clase3 clase3 = new Clase3();
        do{
            System.out.println("-------------MENU DE EJEMPLOS----------------------");
            System.out.println("1. Arreglos");
            System.out.println("2. Diccionarios");
            System.out.println("3. Listas");
            System.out.println("4. Pilas");
            System.out.println("5. Colas");
            System.out.println("6. Itreaciones");
            System.out.println("7. Lectura de archivo");
            System.out.println("8. Escritura de archivo");
            System.out.println("9. Salir");
            
            option = scanner.nextInt();
            
            switch (option){
                case 1:
                    arreglos();
                    break;
                case 2:
                    diccionarios();
                    break;
                case 3:
                    listas();
                    break;
                case 4:
                    pilas();
                    break;
                case 5:
                    colas();
                    break;
                case 6:
                    iteraciones();
                    
                case 7:
                    clase3.lecturaArchivo();
                    break;
                case 8:
                    clase3.escrituraArchivo();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema....");
                    break;
                default:
                    System.out.println("Opción no encontrada");
                    break;
            }
            
        }while(option!=9);
    }
    
    public static void arreglos(){
        //Arreglo con tamaño fijo predefinido
        int numeros[] = new int[5];
        
        numeros[0] = 1;
        numeros [1] = 2;
        System.out.println(numeros[0]);
        
        //Arreglo con inicializacion directa
        String[] nombres = {"Ana", "Luisa", "Carlos", "Jose"};
        System.out.println(nombres[2]);
        
        //Recorrido con for tradicional
        for (int i = 0; i < numeros.length; i++) { //nombre.length -> El tamaño del arreglo
            System.out.println(numeros[i]);
        }
        
        
        //Recorrido con foreach
        for (String nombre : nombres){
            System.out.println(nombre);
        }
    }
    
    public static void diccionarios(){
        // Clave-valor
        HashMap<String, Integer> edades = new HashMap();
        edades.put("Juan",25);
        edades.put("Ana",20);
        edades.put("Jose", 35);
        
        System.out.println(edades.get("Juan"));
        
        System.out.println("Recorrido");
        
        for(String clave : edades.keySet()){
            System.out.println("Clave: "+clave+", valor: "+edades.get(clave));
        }
        
    }
    
    public static void listas(){
       ArrayList<String> lista = new ArrayList<>();
       lista.add("Pera");
       lista.add("Manzana");
       lista.add("Fresa");
       
       for (String elemento : lista){
           System.out.println(elemento);
       }
    }
    
    public static void pilas(){
       Stack<Integer> pila = new Stack<>();
       
       pila.push(10);
       pila.push(9);
       pila.push(8);
       
       System.out.println(pila.pop());
       System.out.println(pila.pop());
       System.out.println(pila.pop());
    }
    
    public static void colas(){
        Queue<String> cola = new LinkedList<>();
        
        cola.add("A");
        cola.add("B");
        cola.add("C");
        
        System.out.println(cola.poll());
        System.out.println(cola.poll());
        System.out.println(cola.poll());
    }
    
    public static void iteraciones(){
        //For tradicional
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }
        System.out.println("");
        
        //While
        int i = 0;
        while(i<5){
            System.out.println(i);
            i++; //i = i+1;
        }
        
        System.out.println("");
        //Do-while
        int j = 0;
        do{
            System.out.println(j);
            j++;
        }while(j<5);
        
    }
    
    public void lecturaArchivo(){
        //Crear el selector de archivos
        JFileChooser fileChooser = new JFileChooser();
        
        int selection = fileChooser.showOpenDialog(null);
        
        //Si el usuario seleccionó un archivo
        if(selection == JFileChooser.APPROVE_OPTION){
            File archivoSeleccionado = fileChooser.getSelectedFile();
            String ruta = archivoSeleccionado.getAbsolutePath();
            
            try{
                File archivo = new File(ruta);
                
                if(archivo.exists()){
                    BufferedReader br = new BufferedReader(new FileReader(archivo));
                    String linea;
                    br.readLine(); //Saltar la primera linea
                    
                    while((linea = br.readLine())!=null){
                        System.out.println(linea);
                         String[] datos = linea.split("\\|");
                        
                        //Encontrando los datos
                        String nombre = datos[0].trim();
                        int edad = Integer.parseInt(datos[1].trim());
                        int promedio = Integer.parseInt(datos[2].trim());
                        
                        Estudiante estudiante = new Estudiante(nombre, edad, promedio);
                        estudiantes.add(estudiante);
                        
                    }
                }else{
                    System.out.println("Error: el archivo no existe :(");
                }
            }catch (IOException e){
                System.out.println("Error al leer el archivo "+e.getMessage());
            }
            
        }else{
            System.out.println("No se seleccionó ningún archivo");
        }
    }
    
    public void escrituraArchivo() {
        String contenido = "<html>";
        contenido+="<table border=\"solid\">";
        contenido+="<tr>";
        contenido+="<th>Nombre</th><th>Edad</th><th>Promedio</th>";
        contenido+="</tr>";
        
        
        for(Estudiante estudiante : estudiantes){
            contenido+="<tr>";
            contenido+="<td>"+estudiante.nombre+"</td>";
            contenido+="<td>"+estudiante.edad+"</td>";
            contenido+="<td>"+estudiante.promedio+"</td>";
            contenido+="</tr>";
        }
        contenido+="</table>";
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("C:\\Users\\luisa\\OneDrive\\Documentos\\USAC\\Practicas finales\\LFP 2025\\reporte.html"))) {
            escritor.write(contenido);
            System.out.println("El archivo se ha escrito correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        contenido.concat("<html>");
    }
}
