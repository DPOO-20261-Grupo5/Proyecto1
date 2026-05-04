package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.Juego;
import BoardGame.JuegoVenta;

public class PruebasJuegoVenta {
	
	private JuegoVenta jv1;
	private Juego j1;
	
	@BeforeEach
	public void setUp() {
		j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		jv1 = new JuegoVenta(j1, 20000.0, 0);
	}
	
	@Test
	@DisplayName("Test aumentar stock / Aumentando más de 0")
	public void aumentarStockAumentandoMasDe0Test() {
		jv1.aumentarStock(1);
		assertEquals(1, jv1.getStockDisponible(), "Stock aumentado incorrectamente");
	}
	
	@Test
	@DisplayName("Test aumentar stock / Aumentando menos de 1")
	public void aumentarStockAumentandoMenosDe1Test() {
		jv1.aumentarStock(-1);
		assertEquals(0, jv1.getStockDisponible(), "Stock aumentado incorrectamente");
	}
	
	@Test
	@DisplayName("Test reducir stock / Reduciendo más de 0 y con stock")
	public void reducirStockMasDe0ConTest() {
		jv1.aumentarStock(3);
		jv1.reducirStock(1);
		assertEquals(2, jv1.getStockDisponible(), "Stock reducido incorrectamente");
	}
	
	@Test
	@DisplayName("Test reducir stock / Reduciendo menos de 1 y con stock")
	public void reducirStockMenosDe1ConTest() {
		jv1.aumentarStock(3);
		jv1.reducirStock(-1);
		assertEquals(3, jv1.getStockDisponible(), "Stock reducido incorrectamente");
	}
	
	@Test
	@DisplayName("Test reducir stock / Reduciendo más de 0 y sin stock")
	public void reducirStockMasDe0SinTest() {
		jv1.reducirStock(1);
		assertEquals(0, jv1.getStockDisponible(), "Stock reducido incorrectamente");
	}
	
	@Test
	@DisplayName("Test reducir stock / Reduciendo menos de 1 y sin stock")
	public void reducirStockMenosDe1SinTest() {
		jv1.reducirStock(-1);
		assertEquals(0, jv1.getStockDisponible(), "Stock reducido incorrectamente");
	}
}
