package Pruebas;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.Bebida;
import BoardGame.ItemVenta;
import BoardGame.Juego;
import BoardGame.JuegoVenta;
import BoardGame.Producto;
import BoardGame.Venta;

public class PruebasVenta {
	
	private Venta v1;
	@BeforeEach
	public void setUp() {
		v1 = new Venta(001, LocalDate.of(2025, 12, 11));
		
		
	}
	
	@Test
	@DisplayName("Prueba Agregar Item")
	public void agregarItemTest() {
		Producto pro1 =  new Bebida("Jugo De Naranja", 2500.0, false, false);
		ItemVenta itv1 = new ItemVenta(pro1, 10, 2500.0);
		int sizeItemsAntes = v1.getItems().size();
		v1.agregarItem(itv1);
		assertEquals(sizeItemsAntes + 1, v1.getItems().size());
		
	}	
	
	@Test
	@DisplayName("Prueba Calcular Subtotal")
	public void calcularSubtotalTest() {
		Producto pro1 =  new Bebida("Jugo De Naranja", 2500.0, false, false);
		Producto pro2=  new Bebida("Cafe", 3000.0, false, false);
		Producto pro3 =  new Bebida("Milo", 2700.0, false, false);
		ItemVenta itv1 = new ItemVenta(pro1, 10, 2500.0);
		ItemVenta itv2 = new ItemVenta(pro2, 10, 3000.0);
		ItemVenta itv3 = new ItemVenta(pro3, 10, 2700.0);
		v1.agregarItem(itv1);
		v1.agregarItem(itv2);
		v1.agregarItem(itv3);
		assertEquals(82000.0, v1.calcularSubtotal(), 0.001);
		
	}
	
	@Test
	@DisplayName("Impuestos solo bebidas (8%)")
	public void calcularImpuestosBebidasTest() {

	    Producto bebida = new Bebida("Jugo", 1000.0, false, false);
	    ItemVenta item = new ItemVenta(bebida, 2, 1000.0); 

	    v1.agregarItem(item);

	    double esperado = 2000 * 0.08; 

	    assertEquals(esperado, v1.calcularImpuestos(), 0.001);
	}
	@Test
	@DisplayName("Impuestos juegos (19%)")
	public void calcularImpuestosJuegosTest() {


	    Juego j1 = new Juego("Catan", 2000, "Marca", 2, 4, 3, "Tablero", false);
	    Producto juego = new JuegoVenta(j1, 5000.0, 3);
	    
	    ItemVenta item = new ItemVenta(juego, 1, 5000.0); 

	    v1.agregarItem(item);

	    double esperado = 5000 * 0.19; 

	    assertEquals(esperado, v1.calcularImpuestos(), 0.001);
	}
	
	@Test
	@DisplayName("Impuestos mixtos")
	public void calcularImpuestosMixtoTest() {
	    
	    Producto bebida = new Bebida("Cafe", 1000.0, false, false);
	    ItemVenta item1 = new ItemVenta(bebida, 2, 1000.0); // 2000

	    
	    Juego j1 = new Juego("Catan", 2000, "Marca", 2, 4, 3, "Tablero", false);
	    Producto juego = new JuegoVenta(j1, 5000.0, 3);
	    ItemVenta item2 = new ItemVenta(juego, 1, 5000.0); 

	    v1.agregarItem(item1);
	    v1.agregarItem(item2);

	    double esperado = (2000 * 0.08) + (5000 * 0.19); 

	    assertEquals(esperado, v1.calcularImpuestos(), 0.001);
	}
}


