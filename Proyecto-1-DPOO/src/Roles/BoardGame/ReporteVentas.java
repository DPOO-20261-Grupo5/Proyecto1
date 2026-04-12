package BoardGame;

import java.time.LocalDate;
import java.util.List;

public class ReporteVentas {
	
	// Atributos
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private double ventasComida;
	private double ventasJuegos;
	private double impuestosTotales;
	private double propinasTotales;
	
	private List<Venta> ventas;
	
	// Constructor
	public ReporteVentas(LocalDate fechaInicio, LocalDate fechaFin, List<Venta> ventas) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.ventas = ventas;
		
		calcularTotales();
	}
	
	
	public void calcularTotales() {
		ventasComida = 0;
		ventasJuegos = 0;
		impuestosTotales = 0;
		propinasTotales = 0;

		for (Venta v : ventas) {
			
			impuestosTotales += v.calcularImpuestos();
			propinasTotales += v.calcularPropina();

			
			for (ItemVenta item : v.getItems()) {
				Producto p = item.getProducto();

				if (p instanceof Bebida || p instanceof Pasteleria) {
					ventasComida += item.calcularSubtotal();
				} else if (p instanceof JuegoVenta) {
					ventasJuegos += item.calcularSubtotal();
				}
			}
		}
	}
	
	
	public double getTotalGeneral() {
		return ventasComida + ventasJuegos;
	}
	
	
	public String mostrarReporte() {
		return "REPORTE DE VENTAS\n" +
		       "Desde: " + fechaInicio + " Hasta: " + fechaFin + "\n" +
		       "Ventas comida: " + ventasComida + "\n" +
		       "Ventas juegos: " + ventasJuegos + "\n" +
		       "Impuestos: " + impuestosTotales + "\n" +
		       "Propinas: " + propinasTotales + "\n" +
		       "TOTAL: " + getTotalGeneral();
	}
	
	
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}

	public LocalDate getFechaFin() {
		return this.fechaFin;
	}

	public double getVentasComida() {
		return this.ventasComida;
	}

	public double getVentasJuegos() {
		return this.ventasJuegos;
	}

	public double getImpuestosTotales() {
		return this.impuestosTotales;
	}

	public double getPropinasTotales() {
		return this.propinasTotales;
	}
}
