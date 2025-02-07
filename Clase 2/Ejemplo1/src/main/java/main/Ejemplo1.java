
package main;

/**
 *
 * @author luisa
 */


public class Ejemplo1 {

    public static void main(String[] args) {
        Producto producto1 = new Producto("Laptop",100.50,5);
        Producto producto2 = new Producto("Mouse", 50.00, 20);
        
        producto1.mostrarInformacion();
        producto2.mostrarInformacion();
        
        producto1.actualizarPrecio(500);
        
        producto1.mostrarInformacion();
        
        System.out.println("Producto1 con 20% de descuento: "+producto1.devolverDescuento(20));
    }
}
