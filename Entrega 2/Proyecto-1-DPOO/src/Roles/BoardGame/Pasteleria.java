package BoardGame;
import java.util.ArrayList;
import java.util.List;

public class Pasteleria extends Platillo{

	//Atributos
	private List<String> listaAlergenos;

	//Constructor
	public Pasteleria(String nombre, double precio) {
		super(nombre, precio);
		this.listaAlergenos = new ArrayList<>();
	}

	//Métodos
	public List<String> getListaAlergenos() {
		return listaAlergenos;
	}

	public void setListaAlergenos(List<String> listaAlergenos) {
	    if (listaAlergenos != null) {
	        this.listaAlergenos = new ArrayList<>(listaAlergenos);
	    }
	}
	
	public boolean contieneAlergeno(String alergeno) {
	    return listaAlergenos.contains(alergeno);
	}
	
	public String mostrarAlergenos() {
	    return "Alergenos: " + listaAlergenos;
	}
	
	@Override
	public String mostrarInformacion() {
	    return super.mostrarInformacion() + " | " + mostrarAlergenos();
	}
}
