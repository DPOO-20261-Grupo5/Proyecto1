package BoardGame;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Roles.Usuario;



public class Prestamo {

    // Atributos
    private int idPrestamo;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private boolean activo;
    private CopiaJuego copiaJuego;


    private static List<Prestamo> historial = new ArrayList<>();

    // Constructor
    public Prestamo(int idPrestamo, Date fechaPrestamo, CopiaJuego copiaJuego) {
        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = null;
        this.activo = true;
        this.copiaJuego = copiaJuego;


        // Marcar la copia como prestada
        copiaJuego.prestado();

        // Guardar en historial
        historial.add(this);
    }
    
    
    

    public Date getFechaPrestamo() {
		return fechaPrestamo;
	}






	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}






	// Devolver juego
    public void devolver(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        this.activo = false;

        // Marcar copia como disponible
        copiaJuego.devuelto();
    }

    // Getters
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public boolean isActivo() {
        return activo;
    }

    public CopiaJuego getCopiaJuego() {
        return copiaJuego;
    }



    public static List<Prestamo> getHistorial() {
        return historial;
    }

    // toString (útil para consola)
    @Override
    public String toString() {
        return "Prestamo #" + idPrestamo +
               " | Juego: " + copiaJuego.getJuego().getNombre() +
               " | Activo: " + activo;
    }
}




