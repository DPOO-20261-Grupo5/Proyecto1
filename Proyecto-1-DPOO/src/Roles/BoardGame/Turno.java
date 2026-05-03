package BoardGame;

import java.time.LocalTime;

public class Turno {

    // Atributos
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    // Constructor
    public Turno(String diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    // Métodos

    public String getDiaSemana() {
        return this.diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraInicio() {
        return this.horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return this.horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    
    public int duracionHoras() {
        return horaFin.getHour() - horaInicio.getHour();
    }

    public boolean esMismoDia(String otraFecha) {
        return this.diaSemana.equals(otraFecha);
    }
    
    public String mostrarTurno() {
        return diaSemana + " | " + horaInicio + " - " + horaFin;
    }
}
