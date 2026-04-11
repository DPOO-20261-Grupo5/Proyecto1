import java.util.List;

public class InventarioPrestamo {

	//Atributos
	private List<String> listaJuegos;
	
	//Constructor
	public InventarioPrestamo(List<String> listaJuegos) {
		super();
		this.listaJuegos = listaJuegos;
	}

	//Métodos
	public List<String> getListaJuegos() {
		return listaJuegos;
	}

	public void setListaJuegos(List<String> listaJuegos) {
		this.listaJuegos = listaJuegos;
	}
}
