package BoardGame;

public abstract class Platillo extends Producto{
	
	//Constructor
	
	public Platillo (String nombre, double precio ) {
		super(nombre, precio);
	}
	
	@Override
	public String mostrarInformacion() {
	    return "Platillo: " + getNombre() + " | Precio: " + getPrecio();
	}

}
