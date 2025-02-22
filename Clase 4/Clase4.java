/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author luisa
 */
public class Clase4 {

    public static void main(String[] args) {
        //Creando el selector de archivos
        JFileChooser fileChooser = new JFileChooser();
        
        //Mostrar el cuadro de dialogo con el selector
        int selection = fileChooser.showOpenDialog(null);
        
        //Si el usuario seleccionó un archivo
        if(selection == JFileChooser.APPROVE_OPTION){
            File archivoSeleccionado = fileChooser.getSelectedFile();
            String ruta = archivoSeleccionado.getAbsolutePath();
            
            //Llamar al método que carga los chefs
            List<Chef> chefs = leerChefs(ruta);
            
            System.out.println("Lista de chefs participantes");
            
            for (Chef c : chefs){
                System.out.println(c);
            }
            //Antes de enfrentarlos, recomiendo hacer una copia de los participantes
            
            Chef ganador = realizarConcurso(chefs);
            System.out.println("\nEl gandor de la batalla de cocina es: "+ganador.nombre+"!!!");
        
        }
    }
    
    public static List<Chef> leerChefs(String ruta){
        List<Chef> chefs = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))){
        
            String linea;
            br.readLine();//Leyendo los encabezados
            
            while((linea = br.readLine())!=null){
                String[] datos = linea.split(","); //Separador "\\|"
                chefs.add(new Chef(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), Integer.parseInt(datos[3])));
            }
           
        }catch(IOException e){
            System.out.println("Error al leer el archivo: "+e.getMessage());
        }
        
        return chefs;
    }
    
    
    public static Chef realizarConcurso(List<Chef> chefs){
        
        while (chefs.size() > 1){
            System.out.println("----------------NUEVA RONDA---------------------");
            List<Chef> sobrevivientes = new ArrayList<>();
            for(int i = 0; i < chefs.size() ; i+= 2){ //Paso 2 porque los voy a enfrentar de 2 en 2
                if( i + 1 < chefs.size()){ //Identificar lista de tamaño impar
                    /*
                    Lista 3 elementos
                    i = 2, i+1=3
                    */
                    
                    Chef chef1 = chefs.get(i);
                    Chef chef2 = chefs.get(i+1);
                    
                    System.out.println("Enfrentamiento "+chef1.nombre+" vs "+chef2.nombre);
                    Chef ganador = chef1.calcularPuntaje() > chef2.calcularPuntaje() ? chef1 : chef2;
                    /*
                    if(chef1.calcularPuntaje() > chef2.calcularPuntaje()){
                        chef1
                    }else{
                        chef2
                    }
                    
                    //Hacer un método que calcule el daño provocado a ambos personajes y comparar la vida de ambos después de provocar daño
                    
*/
                    sobrevivientes.add(ganador);
                    System.out.println("El ganador es: "+ganador.nombre);
                
                }else{
                    sobrevivientes.add(chefs.get(i));
                }
            
            }
            
            chefs = sobrevivientes;
        }
        
        return chefs.get(0);
    }
}
