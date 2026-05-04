package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.Bebida;
import BoardGame.ItemVenta;
import BoardGame.Juego;
import BoardGame.JuegoVenta;
import BoardGame.Pasteleria;
import BoardGame.Producto;
import BoardGame.ReporteVentas;
import BoardGame.Venta;

public class PruebasReporteVenta {

	private ReporteVentas rv1;
	private Venta v1;
	
	@BeforeEach
	public void setUp() {
		v1 = new Venta(001, LocalDate.of(2025, 12, 11));
		List<Venta> ventas = new ArrayList<>();
		ventas.add(v1);
		rv1 = new ReporteVentas(LocalDate.of(2024, 5, 6), LocalDate.of(2024, 5, 8), ventas);
	}
	
	@Test
	@DisplayName("Test calcular totales / Sin ventas")
	public void calcularTotalesSinVentasTest() {
		List<Venta> ventas = new ArrayList<>();
		rv1 = new ReporteVentas(LocalDate.of(2024, 5, 6), LocalDate.of(2024, 5, 8), ventas);
		assertEquals(0, rv1.getVentasComida(), "Totales mal calculados");
		assertEquals(0, rv1.getVentasJuegos(), "Totales mal calculados");
		assertEquals(0, rv1.getImpuestosTotales(), "Totales mal calculados");
		assertEquals(0, rv1.getPropinasTotales(), "Totales mal calculados");
	}
	
	@Test
	@DisplayName("Test calcular totales / Con 1 venta comida bebida")
	public void calcularTotalesCon1VentaComidaBebidaTest() {
		Producto pro1 = new Bebida("Jugo De Naranja", 3000.0, false, false);
		ItemVenta itv1 = new ItemVenta(pro1, 10, 3000.0);
		v1 = new Venta(001, LocalDate.of(2025, 12, 11));
		v1.agregarItem(itv1);
		List<Venta> ventas = new ArrayList<>();
		ventas.add(v1);
		rv1 = new ReporteVentas(LocalDate.of(2024, 5, 6), LocalDate.of(2024, 5, 8), ventas);
		assertEquals(30000, rv1.getVentasComida(), "Totales mal calculados");
		assertEquals(0, rv1.getVentasJuegos(), "Totales mal calculados");
		assertEquals(2400, rv1.getImpuestosTotales(), "Totales mal calculados");
		assertEquals(3000, rv1.getPropinasTotales(), "Totales mal calculados");
	}
	
	@Test
	@DisplayName("Test calcular totales / Con 1 venta comida pasteleria")
	public void calcularTotalesCon1VentaComidaPasteleriaTest() {
		Producto pro1 = new Pasteleria("Tres leches", 5000.0);
		ItemVenta itv1 = new ItemVenta(pro1, 8, 5000.0);
		v1 = new Venta(001, LocalDate.of(2025, 12, 11));
		v1.agregarItem(itv1);
		List<Venta> ventas = new ArrayList<>();
		ventas.add(v1);
		rv1 = new ReporteVentas(LocalDate.of(2024, 5, 6), LocalDate.of(2024, 5, 8), ventas);
		assertEquals(40000, rv1.getVentasComida(), "Totales mal calculados");
		assertEquals(0, rv1.getVentasJuegos(), "Totales mal calculados");
		assertEquals(3200, rv1.getImpuestosTotales(), "Totales mal calculados");
		assertEquals(4000, rv1.getPropinasTotales(), "Totales mal calculados");
	}
	
	@Test
	@DisplayName("Test calcular totales / Con 1 venta juego")
	public void calcularTotalesCon1VentaJuegoTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		Producto pro1 = new JuegoVenta(j1, 10000.0, 3);
		ItemVenta itv1 = new ItemVenta(pro1, 3, 10000.0);
		v1 = new Venta(001, LocalDate.of(2025, 12, 11));
		v1.agregarItem(itv1);
		List<Venta> ventas = new ArrayList<>();
		ventas.add(v1);
		rv1 = new ReporteVentas(LocalDate.of(2024, 5, 6), LocalDate.of(2024, 5, 8), ventas);
		assertEquals(0, rv1.getVentasComida(), "Totales mal calculados");
		assertEquals(30000, rv1.getVentasJuegos(), "Totales mal calculados");
		assertEquals(5700, rv1.getImpuestosTotales(), "Totales mal calculados");
		assertEquals(3000, rv1.getPropinasTotales(), "Totales mal calculados");
	}
	
	@Test
	@DisplayName("Test calcular totales / Con ventas juego y platillo")
	public void calcularTotalesConVentasJuegoYPlatilloTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		Producto pro1 = new JuegoVenta(j1, 10000.0, 3);
		ItemVenta itv1 = new ItemVenta(pro1, 1, 10000.0);
		Producto pro2 = new Bebida("Jugo De Naranja", 3000.0, false, false);
		ItemVenta itv2 = new ItemVenta(pro2, 5, 3000.0);
		Venta v2 = new Venta(002, LocalDate.of(2025, 11, 12));
		v1 = new Venta(001, LocalDate.of(2025, 12, 11));
		v1.agregarItem(itv1);
		v2.agregarItem(itv2);
		List<Venta> ventas = new ArrayList<>();
		ventas.add(v1);
		ventas.add(v2);
		rv1 = new ReporteVentas(LocalDate.of(2024, 5, 6), LocalDate.of(2024, 5, 8), ventas);
		assertEquals(15000, rv1.getVentasComida(), "Totales mal calculados");
		assertEquals(10000, rv1.getVentasJuegos(), "Totales mal calculados");
		assertEquals(3100, rv1.getImpuestosTotales(), "Totales mal calculados");
		assertEquals(2500, rv1.getPropinasTotales(), "Totales mal calculados");
	}
	
	@Test
	@DisplayName("Test calcular totales / Con 1 venta juego y platillo")
	public void calcularTotalesCon1VentaJuegoYPlatilloTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		Producto pro1 = new JuegoVenta(j1, 10000.0, 5);
		ItemVenta itv1 = new ItemVenta(pro1, 4, 10000.0);
		Producto pro2 = new Bebida("Jugo De Naranja", 3000.0, false, false);
		ItemVenta itv2 = new ItemVenta(pro2, 10, 3000.0);
		v1 = new Venta(001, LocalDate.of(2025, 12, 11));
		v1.agregarItem(itv1);
		v1.agregarItem(itv2);
		List<Venta> ventas = new ArrayList<>();
		ventas.add(v1);
		rv1 = new ReporteVentas(LocalDate.of(2024, 5, 6), LocalDate.of(2024, 5, 8), ventas);
		assertEquals(30000, rv1.getVentasComida(), "Totales mal calculados");
		assertEquals(40000, rv1.getVentasJuegos(), "Totales mal calculados");
		assertEquals(10000, rv1.getImpuestosTotales(), "Totales mal calculados");
		assertEquals(7000, rv1.getPropinasTotales(), "Totales mal calculados");
	}
	
	@Test
	@DisplayName("Test total general / Sin ventas")
	public void totalGeneralSinVentasTest() {
		List<Venta> ventas = new ArrayList<>();
		rv1 = new ReporteVentas(LocalDate.of(2024, 5, 6), LocalDate.of(2024, 5, 8), ventas);
		assertEquals(0, rv1.getTotalGeneral(), "Total general calculado incorrectamente");
	}
	
	@Test
	@DisplayName("Test total general / Con ventas juego y platillo")
	public void totalGeneralConVentasJuegoYPlatilloTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		Producto pro1 = new JuegoVenta(j1, 10000.0, 3);
		ItemVenta itv1 = new ItemVenta(pro1, 2, 10000.0);
		Producto pro2 = new Bebida("Jugo De Naranja", 3000.0, false, false);
		ItemVenta itv2 = new ItemVenta(pro2, 4, 3000.0);
		Venta v2 = new Venta(002, LocalDate.of(2025, 11, 12));
		v1 = new Venta(001, LocalDate.of(2025, 12, 11));
		v1.agregarItem(itv1);
		v2.agregarItem(itv2);
		List<Venta> ventas = new ArrayList<>();
		ventas.add(v1);
		ventas.add(v2);
		rv1 = new ReporteVentas(LocalDate.of(2024, 5, 6), LocalDate.of(2024, 5, 8), ventas);
		assertEquals(32000, rv1.getTotalGeneral(), "Total general calculado incorrectamente");
	}
}
