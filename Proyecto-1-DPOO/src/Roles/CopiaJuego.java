
public class CopiaJuego {
	
	//Atributos
	
    private String idCopia;
    private Juego juego;
    private boolean disponible;
    private String estado;
    
    //Constructor

    public CopiaJuego(String codigo, Juego juego, String estado) {
        this.idCopia = codigo;
        this.juego = juego;
        this.disponible = true;
        this.estado = estado;
    }

    //Métodos
    
    public String getCodigo() {
        return idCopia;
    }

    public void setCodigo(String idCopia) {
        if (idCopia != null) {
            this.idCopia = idCopia;
        }
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        if (juego != null) {
            this.juego = juego;
        }
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestado() {
        if (disponible) {
            disponible = false;
        }
    }

    public void devuelto() {
        disponible = true;
    }

    public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String mostrarInformacion() {
        return "Copia: " + idCopia + " | " + juego.mostrarInformacion() + " | Disponible: " + disponible + " | Estado: " + estado;
    }

}
