package BoardGame;
import java.time.LocalDate;

public class ReporteVentas {
	
	//Atributos
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private double ventasComida;
	private double ventasJuegos;
	private double impuestosTotales;
	private double propinasTotales;
	
	//Constructor
	public ReporteVentas(LocalDate fechaInicio, LocalDate fechaFin, double ventasComida, double ventasJuegos,
			double impuestosTotales, double propinasTotales) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.ventasComida = ventasComida;
		this.ventasJuegos = ventasJuegos;
		this.impuestosTotales = impuestosTotales;
		this.propinasTotales = propinasTotales;
	}
	
	//Métodos

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getVentasComida() {
		return ventasComida;
	}

	public void setVentasComida(double ventasComida) {
		this.ventasComida = ventasComida;
	}

	public double getVentasJuegos() {
		return ventasJuegos;
	}

	public void setVentasJuegos(double ventasJuegos) {
		this.ventasJuegos = ventasJuegos;
	}

	public double getImpuestosTotales() {
		return impuestosTotales;
	}

	public void setImpuestosTotales(double impuestosTotales) {
		this.impuestosTotales = impuestosTotales;
	}

	public double getPropinasTotales() {
		return propinasTotales;
	}

	public void setPropinasTotales(double propinasTotales) {
		this.propinasTotales = propinasTotales;
	}
	
}
