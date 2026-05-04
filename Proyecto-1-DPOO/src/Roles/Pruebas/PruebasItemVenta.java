package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.ItemVenta;
import BoardGame.Pasteleria;
import BoardGame.Producto;

public class PruebasItemVenta {
	
	private ItemVenta itv1;
	private Producto pro1;
	
	@BeforeEach
	public void setUp() {
		pro1 = new Pasteleria("Tres leches", 4500.0);
		itv1 = new ItemVenta(pro1, 10, 3000.0);
	}
	
	@Test
	@DisplayName("Test calcular subtotal")
	public void calcularSubtotalTest() {
		assertEquals(30000.0, itv1.calcularSubtotal(), "Subtotal calculado incorrectamente");
	}
}
