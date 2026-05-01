package BoardGame;

import Roles.Empleado;

public class SolicitudCambioTurno {
	
    // Atributos
    private int idSolicitud;
    private Empleado solicitante;
    private Empleado otroEmpleado; 
    private Turno turnoActual;
    private Turno turnoNuevo;
    private String tipo; 
    private String estado; 

    // Constructor
    public SolicitudCambioTurno(int idSolicitud, Empleado solicitante,
                                 Turno turnoActual, Turno turnoNuevo,
                                 String tipo) {

        this.idSolicitud = idSolicitud;
        this.solicitante = solicitante;
        this.turnoActual = turnoActual;
        this.turnoNuevo = turnoNuevo;
        this.tipo = tipo;
        this.estado = "PENDIENTE";
    }

    // Métodos

    public void asignarOtroEmpleado(Empleado otro) {
        this.otroEmpleado = otro;
    }

    public void aprobar() {
        this.estado = "APROBADO";
    }

    public void rechazar() {
        this.estado = "RECHAZADO";
    }


    public int getIdSolicitud() {
        return this.idSolicitud;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getTipo() {
        return this.tipo;
    }

    public Empleado getSolicitante() {
        return this.solicitante;
    }

    public Empleado getOtroEmpleado() {
        return this.otroEmpleado;
    }

    public Turno getTurnoActual() {
        return this.turnoActual;
    }

    public Turno getTurnoNuevo() {
        return this.turnoNuevo;
    }

 
    public String mostrarSolicitud() {
        return "Solicitud #" + idSolicitud +
               " | Tipo: " + tipo +
               " | Estado: " + estado +
               " | Solicitante: " + solicitante.getNombre();
    }
}
