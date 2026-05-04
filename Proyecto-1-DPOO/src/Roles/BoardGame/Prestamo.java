package BoardGame;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestamo {

    // Atributos
    private int idPrestamo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean activo;
    private CopiaJuego copiaJuego;
    private static List<Prestamo> historial = new ArrayList<>();

    // Constructor
    public Prestamo(int idPrestamo, LocalDate fechaPrestamo, CopiaJuego copiaJuego) {
        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = null;
        this.activo = true;
        this.copiaJuego = copiaJuego;

        copiaJuego.prestado();

       
        historial.add(this);
    }
    
    public LocalDate getFechaPrestamo() {
		return this.fechaPrestamo;
	}


	public LocalDate getFechaDevolucion() {
		return this.fechaDevolucion;
	}


	
    public void devolver(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        this.activo = false;

        
        copiaJuego.devuelto();
    }

 
    public int getIdPrestamo() {
        return this.idPrestamo;
    }

    public boolean isActivo() {
        return activo;
    }

    public CopiaJuego getCopiaJuego() {
        return this.copiaJuego;
    }



    public static List<Prestamo> getHistorial() {
        return historial;
    }

    
    public String informacion() {
        return "Prestamo #" + idPrestamo +
               " | Juego: " + copiaJuego.getJuego().getNombre() +
               " | Activo: " + activo;
    }
}




