package BoardGame;
import java.util.List;

public class Pasteleria extends Platillo{

	//Atributos
	private List<String> listaAlergenos;

	//Constructor
	public Pasteleria(String nombre, double precio, List<String> listaAlergenos) {
		super(nombre, precio);
		this.listaAlergenos = listaAlergenos;
	}

	//Métodos
	public List<String> getListaAlergenos() {
		return listaAlergenos;
	}

	public void setListaAlergenos(List<String> listaAlergenos) {
		this.listaAlergenos = listaAlergenos;
	}
}
