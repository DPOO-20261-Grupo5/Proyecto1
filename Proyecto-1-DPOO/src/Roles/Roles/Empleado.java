package Roles;
import BoardGame.Turno;

public abstract class Empleado {
	
	//Atributos
	
    private String nombre;
    private String idEmpleado;
    private Turno turno;

    //Constructor
    
    public Empleado(String nombre, String idEmpleado, Turno turno) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
        this.turno = turno;
    }
    
    //Métodos

    public String getNombre() {
        return nombre;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public Turno getTurno() {
		return turno;
	}

	public void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = nombre;
        }
    }	

    public void setIdEmpleado(String idEmpleado) {
        if (idEmpleado != null) {
            this.idEmpleado = idEmpleado;
        }
    }

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

    public String mostrarInformacion() {
        return "Empleado: " + nombre + " | ID: " + idEmpleado + " | Turno: " + turno;
    }

}

