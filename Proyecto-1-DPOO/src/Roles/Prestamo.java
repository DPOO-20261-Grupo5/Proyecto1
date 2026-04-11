import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prestamo {
	
	//Atributos
	private int idPrestamo;
	private Date fechaPrestamo;
	private Date fechaDevolucion;
	private Boolean activo;
	private CopiaJuego copiaJuego;
	private static List<Prestamo> historial = new ArrayList<>();
	
	
	//Constructor
	public Prestamo(int idPrestamo, Date fechaPrestamo, Date fechaDevolucion, CopiaJuego copiaJuego) {
		this.idPrestamo = idPrestamo;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = null;
		this.activo = true;
		this.copiaJuego = copiaJuego;
		historial.add(this);
		
	}
	
	
	public static List<Prestamo> getHistorial() {
	    return historial;
	}
	
	public void devolver(Date fechaDevolucion) {
	    this.fechaDevolucion = fechaDevolucion;
	    this.activo = false;
	}
}




