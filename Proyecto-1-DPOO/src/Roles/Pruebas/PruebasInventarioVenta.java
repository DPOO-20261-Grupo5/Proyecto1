package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.InventarioVenta;
import BoardGame.Juego;
import BoardGame.JuegoVenta;

public class PruebasInventarioVenta {

	private InventarioVenta iv1;
	
	@BeforeEach
	public void setUp() {
		iv1 = new InventarioVenta();
	}
	
	@Test
	@DisplayName("Test agregar juego venta")
	public void agregarJuegoVentaTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		JuegoVenta jv1 = new JuegoVenta(j1, 20000.0, 1);
		iv1.agregarJuegoVenta(jv1);
		assertEquals(1, iv1.getJuegosVenta().size(), "Juego venta agregado incorrectamente");
		assertTrue(iv1.getJuegosVenta().contains(jv1), "Juego venta agregado incorrectamente");
	}
	
	@Test
	@DisplayName("Test buscar juego / No está")
	public void buscarJuegoNoEstaTest() {
		assertEquals(null, iv1.buscarJuego("Monopoly"), "Juego buscado incorrectamente");
	}
	
	@Test
	@DisplayName("Test buscar juego / Si está")
	public void buscarJuegoSiEstaTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		JuegoVenta jv1 = new JuegoVenta(j1, 20000.0, 1);
		iv1.agregarJuegoVenta(jv1);
		assertEquals(jv1, iv1.buscarJuego("Monopoly"), "Juego buscado incorrectamente");
	}
	
	@Test
	@DisplayName("Test buscar juego / Está otro")
	public void buscarJuegoEstaOtroTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		JuegoVenta jv1 = new JuegoVenta(j1, 20000.0, 1);
		iv1.agregarJuegoVenta(jv1);
		assertEquals(null, iv1.buscarJuego("Uno"), "Juego buscado incorrectamente");
	}
	
	@Test
	@DisplayName("Test hay stock / Sin stock suficiente")
	public void hayStockSinStockSuficienteTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		JuegoVenta jv1 = new JuegoVenta(j1, 20000.0, 1);
		iv1.agregarJuegoVenta(jv1);
		assertFalse(iv1.hayStock("Monopoly", 2), "Stock revisado incorrectamente");
	}
	
	@Test
	@DisplayName("Test hay stock / Con stock de otro juego")
	public void hayStockConStockDeOtroJuegoTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		JuegoVenta jv1 = new JuegoVenta(j1, 20000.0, 1);
		iv1.agregarJuegoVenta(jv1);
		assertFalse(iv1.hayStock("Uno", 1), "Stock revisado incorrectamente");
	}
	
	@Test
	@DisplayName("Test hay stock / Con stock suficiente")
	public void hayStockConStockSuficienteTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		JuegoVenta jv1 = new JuegoVenta(j1, 20000.0, 3);
		iv1.agregarJuegoVenta(jv1);
		assertTrue(iv1.hayStock("Monopoly", 2), "Stock revisado incorrectamente");
	}
	
	@Test
	@DisplayName("Test vender juego / Sin stock suficiente")
	public void venderJuegoSinStockSuficienteTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		JuegoVenta jv1 = new JuegoVenta(j1, 20000.0, 1);
		iv1.agregarJuegoVenta(jv1);
		iv1.venderJuego("Monopoly", 2);
		assertEquals(1, jv1.getStockDisponible(), "Juego vendido incorrectamente");
	}
	
	@Test
	@DisplayName("Test vender juego / Con stock de otro juego")
	public void venderJuegoConStockDeOtroJuegoTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		JuegoVenta jv1 = new JuegoVenta(j1, 20000.0, 1);
		iv1.agregarJuegoVenta(jv1);
		iv1.venderJuego("Uno", 1);
		assertEquals(1, jv1.getStockDisponible(), "Juego vendido incorrectamente");
	}
	
	@Test
	@DisplayName("Test vender juego / Con stock suficiente")
	public void venderJuegoConStockSuficienteTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		JuegoVenta jv1 = new JuegoVenta(j1, 20000.0, 3);
		iv1.agregarJuegoVenta(jv1);
		iv1.venderJuego("Monopoly", 2);
		assertEquals(1, jv1.getStockDisponible(), "Juego vendido incorrectamente");
	}
	
}
