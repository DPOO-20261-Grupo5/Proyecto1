package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.Descuento;

public class PruebasDescuento {

	private Descuento d1;
	
	@BeforeEach
	public void setUp() {
		d1 = new Descuento(300.0);
	}
	
	@Test
	@DisplayName("Test aplicar descuento / Usado")
	public void aplicarDescuentoUsado() {
		d1.usar();
		assertEquals(80000, d1.aplicarDescuento(80000.0), "Descuento aplicado incorrectamente");
	}
	
	@Test
	@DisplayName("Test aplicar descuento / Mayor a total")
	public void aplicarDescuentoMayorATotal() {
		assertEquals(0, d1.aplicarDescuento(200.0), "Descuento aplicado incorrectamente");
	}
	
	@Test
	@DisplayName("Test aplicar descuento / Normal")
	public void aplicarDescuentoNormal() {
		assertEquals(700, d1.aplicarDescuento(1000.0), "Descuento aplicado incorrectamente");
	}
}
