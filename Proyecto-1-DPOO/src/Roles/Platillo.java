
public class Platillo extends Producto{
	
	public Platillo (String nombre, double precio ) {
		super(nombre, precio);
	}
	
	@Override
	 public String mostrarInformacion() {
		return "Platillo: "+ super.mostrarInformacion();
    }

    
    

}
