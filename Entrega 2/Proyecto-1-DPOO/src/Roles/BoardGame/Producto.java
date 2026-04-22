package BoardGame;

public abstract class Producto {
	 
	 //Atributos
	
     private String nombre;
     private double precio;
     
     //Constructor
     
     public Producto (String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
     }
     
     //Métodos
            
     public String getNombre() {
    	 return this.nombre;
     }
            
     public void setNombre (String nombre) {
    	 if (nombre!=null) {
    		 this.nombre=nombre;
    	 }
     }
     
     public void setPrecio (double precio) {
    	 if (precio>=0) {
    		 this.precio=precio;
    	 }
     }
     
     public double getPrecio() {
    	 return this.precio;
     }
     


     public String mostrarInformacion() {
    	 return "Producto: "+ nombre + " | Precio: " + precio;
     }

}
