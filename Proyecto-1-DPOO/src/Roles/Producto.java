
public class Producto {
	 
	 //Atributos
	
     private String nombre;
     private double precio;
     
     //Constructor
     
     public Producto (String nombre, double precio) {
            this.nombre = nombre;
            setPrecio(precio);
     }
     
     //Métodos
            
     public String getNombre() {
    	 return nombre;
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
    	 return precio;
     }
     
     public void setNombre (double precio) {
    	 if (precio >= 0) {
    		 this.precio=precio;
    	 }
     }
     
     public String mostrarInformacion() {
    	 return "Producto: "+ nombre + " | Precio: " + precio;
     }

}
