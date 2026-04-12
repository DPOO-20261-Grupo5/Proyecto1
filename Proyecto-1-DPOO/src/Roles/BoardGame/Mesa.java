package BoardGame;

public class Mesa {

	//Atributos
	private int numeroMesa;
	private int capacidad;
	private int numeroPersonas;
	private boolean hayNinos;
	private boolean hayMenores;
	
	//Constructor
	public Mesa(int numeroMesa, int capacidad, int numeroPersonas, boolean hayNinos, boolean hayMenores) {
		super();
		this.numeroMesa = numeroMesa;
		this.capacidad = capacidad;
		this.numeroPersonas = numeroPersonas;
		this.hayNinos = hayNinos;
		this.hayMenores = hayMenores;
	}

	//Métodos
	public int getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public boolean isHayNinos() {
		return hayNinos;
	}

	public void setHayNinos(boolean hayNinos) {
		this.hayNinos = hayNinos;
	}

	public boolean isHayMenores() {
		return hayMenores;
	}

	public void setHayMenores(boolean hayMenores) {
		this.hayMenores = hayMenores;
	}
	
	
}
