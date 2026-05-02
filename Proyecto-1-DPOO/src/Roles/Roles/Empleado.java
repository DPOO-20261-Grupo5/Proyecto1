package Roles;
import java.time.LocalDate;

import BoardGame.Turno;

public abstract class Empleado extends Usuario {
	
	//Atributos
    protected Turno turno;

    //Constructor
    
    public Empleado(String nombre, String id, Turno turno, String login, String password) {
    	super(id, nombre, login, password);
        this.turno = turno;
    }
    
    //Métodos

    public String getNombre() {
        return nombre;
    }

    public String getIdEmpleado() {
        return super.getId();
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
      
            super.id = idEmpleado;
      
    }

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	public boolean tieneTurno(LocalDate fecha) {
	    return turno != null && turno.esMismoDia(fecha);
	}

    public String mostrarInformacion() {
        return "Empleado: " + nombre + " | ID: " + id + " | Turno: " + turno;
    }
    

}

