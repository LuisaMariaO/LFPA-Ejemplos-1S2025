/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

class Producto {
    //Atributos
    String nombre;
    double precio;
    int stock;
    
    //Método consstructor
    public Producto(String nombre, double precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    //Método para mostrar la información de un producto
    
    public void mostrarInformacion(){
        System.out.println("Producto: "+this.nombre);
        System.out.println("Precio: "+this.precio);
        System.out.println("Stock: "+this.stock);
        System.out.println("-------------------------------------------");
    }
    
    //Método para actualizar el precio de un producto
    public void actualizarPrecio(double precioNuevo){
        if(precioNuevo>0){
        this.precio = precioNuevo;
    }else{
            System.out.println("Error: El precio debe ser mayor a 0");
        }
    }
    
    //Función para obtener el precio del producto con descuento
    
    public double devolverDescuento(int descuento){
        double resultado = this.precio - (this.precio * (descuento/100.00));
        
        return resultado;
    }

}
