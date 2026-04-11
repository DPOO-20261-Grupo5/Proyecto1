
public class Empleado {
	
    private String nombre;
    private String idEmpleado;
    private boolean enTurno;

    public Empleado(String nombre, String idEmpleado, boolean enTurno) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
        this.enTurno = enTurno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public boolean isEnTurno() {
        return enTurno;
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

    public void setEnTurno(boolean enTurno) {
        this.enTurno = enTurno;
    }

    public String mostrarInformacion() {
        return "Empleado: " + nombre + " | ID: " + idEmpleado + " | En turno: " + enTurno;
    }

}

