package BoardGame;

public class Bebida extends Platillo {

	//Atributos
	
	private boolean alcoholica;
    private boolean caliente;
	
    //Constructor
    
	public Bebida (String nombre, double precio, boolean alcoholica, boolean caliente) {
		super(nombre, precio);
		this.alcoholica= alcoholica;
		this.caliente = caliente;
	}
	
	//Métodos
	
	public boolean isAlcoholica() {
		return alcoholica;
	}
	
    public void setAlcoholica(boolean alcoholica) {
    	this.alcoholica= alcoholica;
    }
    
    public boolean isCaliente() {
		return caliente;
	}
	
    public void setCaliente(boolean caliente) {
    	this.caliente= caliente;
    }
    
    public String obtenerTipo() {
        if (alcoholica && caliente) { 
        	return "Alcohólica caliente";
        }
        if (alcoholica) {
        	return "Alcohólica fría";
        }
        if (caliente) {
        	return "No alcohólica caliente";
        }
        return "No alcohólica fría";
    }

    public String mostrarInformacion() {
        return super.mostrarInformacion() + " | Tipo: " + obtenerTipo();
    }
}
