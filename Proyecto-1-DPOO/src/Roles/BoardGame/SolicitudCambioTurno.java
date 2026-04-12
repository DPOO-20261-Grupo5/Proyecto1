package BoardGame;

public class SolicitudCambioTurno {
	
	//Atributos
	private int idSolicitud;
	private String estado;
	
	//Constructor
	public SolicitudCambioTurno(int idSolicitud, String estado) {
		super();
		this.idSolicitud = idSolicitud;
		this.estado = estado;
	}
	
	//Métodos
	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
