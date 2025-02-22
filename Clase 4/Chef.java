/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author luisa
 */
public class Chef {
    String nombre;
    int sabor;
    int presentacion;
    int creatividad;
    
    //Método constructor
    public Chef(String nombre, int sabor, int presentacion, int creatividad){
        this.nombre = nombre;
        this.sabor = sabor;
        this.presentacion = presentacion;
        this.creatividad = creatividad;
    }
    
    public int calcularPuntaje(){
        return sabor+presentacion+creatividad;
    }
    
    @Override
    public String toString(){
        return nombre + "(Sabor: "+sabor+" Presentacion: "+presentacion+" Creatividad: "+creatividad+")";
    }
        
     /*Recomendación:
    Crear un método que devuelva una línea html con los datos del personaje para los reportes
     */
}
