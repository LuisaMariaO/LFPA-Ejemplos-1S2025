/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author luisa
 */
public class PlaceVisual {
    private String figura;
    private String color;
    
    public PlaceVisual(String figura, String color){
        this.figura = figura;
        this.color = color;
    }
    
    public String getFigura(){
        return this.figura;
    }
    
    public String getColor(){
        return this.color;
    }
    
}
