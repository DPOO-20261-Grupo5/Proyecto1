
public class Juego {
	
	private String nombre;
	private double precio;
	
	public Juego (String nombre, double precio) {
		this.nombre = nombre;
		this.precio= precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecio(){
		return precio;
	}
	
	public void setNombre(String nombre) {
		if (nombre != null) {
			this.nombre=nombre;
		}
	}
	
	public void setPrecio(double precio) {
		if (precio>=0) {
			this.precio=precio;
		}	
	}
	
	public String mostrarInformacion() {
	    return "Juego: " + nombre + " | Precio: " + precio;
	}

}
