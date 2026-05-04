package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.Bebida;
import BoardGame.CopiaJuego;
import BoardGame.Descuento;
import BoardGame.ItemVenta;
import BoardGame.Juego;
import BoardGame.JuegoVenta;
import BoardGame.Mesa;
import BoardGame.Prestamo;
import BoardGame.Producto;
import BoardGame.Torneo;
import BoardGame.Turno;
import BoardGame.Venta;
import Roles.Administrador;
import Roles.Cliente;

public class PruebasIntegracionCliente {
	
	@Test
	@DisplayName("HU Cliente 1 - Registro de cliente")
	public void registroClienteTest() {
	    Cliente c = new Cliente(1, "Ana", "ana@uniandes.edu.co", "123");
	    assertEquals("Ana", c.getNombre(), "Nombre incorrecto");
	    assertEquals("ana@uniandes.edu.co", c.getLogin(), "Login incorrecto");
	}
	
	@Test
	@DisplayName("HU Cliente 1 - Usuario duplicado")
	public void registroClienteDuplicadoTest() {
	    Cliente c1 = new Cliente(1, "Ana", "ana", "123");
	    Cliente c2 = new Cliente(1, "Ana", "ana", "123");
	    assertEquals(c1.getLogin(), c2.getLogin(), "Usuarios deberían coincidir");
	}

	@Test
	@DisplayName("HU Cliente 2 - Solicitar mesa correctamente")
	public void solicitarMesaTest() {
	    Cliente c = new Cliente(1, "Ana", "ana", "123");
	    Mesa m = new Mesa(1, 4, 2, false, false);
	    c.asignarMesa(m);
	    assertEquals(m, c.getMesa(), "Mesa no asignada correctamente");
	}
	
	@Test
	@DisplayName("HU Cliente 2 - Sin capacidad")
	public void solicitarMesaSinCapacidadTest() {
	    Cliente c = new Cliente(1, "Ana", "ana", "123");
	    assertNull(c.getMesa(), "No debería tener mesa asignada");
	}
	
	@Test
	@DisplayName("HU3 - Cliente solicita préstamo correctamente")
	public void solicitarPrestamoTest() {
	    Cliente c = new Cliente(1, "Ana", "ana", "123");
	    Juego j = new Juego("Uno", 2000, "Hasbro", 2, 4, 5, "Cartas", false);
	    CopiaJuego cj = new CopiaJuego(1, j, "bueno");
	    Prestamo p = new Prestamo(1, LocalDate.of(2025, 11, 12), cj);
	    c.agregarPrestamo(p);
	    assertEquals(1, c.getPrestamos().size(), "No se agregó el préstamo");
	}
	
	@Test
	@DisplayName("HU4 - Cliente compra bebida correctamente")
	public void comprarProductoTest() {
	    Producto bebida = new Bebida("Jugo", 3000, false, false);
	    ItemVenta item = new ItemVenta(bebida, 2, 3000);
	    Venta v = new Venta(1, LocalDate.now());
	    v.agregarItem(item);
	    assertEquals(6000, v.calcularSubtotal(), "Subtotal incorrecto");
	}
	
	@Test
	@DisplayName("HU5 - Compra de juego con IVA")
	public void comprarJuegoTest() {
	    Juego j = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
	    Producto juegoVenta = new JuegoVenta(j, 10000, 5);
	    ItemVenta item = new ItemVenta(juegoVenta, 2, 10000);
	    Venta v = new Venta(1, LocalDate.now());
	    v.agregarItem(item);
	    assertEquals(20000, v.calcularSubtotal(), "Subtotal incorrecto");
	    assertEquals(3800, v.calcularImpuestos(), "IVA incorrecto");
	}
	
	@Test
	@DisplayName("HU6 - Uso de puntos / Acumula puntos")
	public void acumularPuntosSiTest() {
	    Cliente c = new Cliente(1, "Ana", "ana", "123");
	    c.acumularPuntos(100000);
	    assertTrue(c.getPuntosFidelidad() > 0, "No acumuló puntos");
	}
	
	@Test
	@DisplayName("HU6 - Uso de puntos / No acumula puntos")
	public void acumularPuntosNoTest() {
	    Cliente c = new Cliente(1, "Ana", "ana", "123");
	    c.acumularPuntos(50);
	    assertEquals(0, c.getPuntosFidelidad(), "Debería ser 0 puntos");
	}
	
	@Test
	@DisplayName("HU7 - Agregar juego a favoritos")
	public void favoritosTest() {
	    Cliente c = new Cliente(1, "Ana", "ana", "123");
	    Juego j = new Juego("Uno", 2000, "Hasbro", 2, 4, 5, "Cartas", false);
	    c.agregarJuegoFavorito(j);
	    assertTrue(c.getJuegosFavoritos().contains(j), "No se agregó a favoritos");
	}
	
	@Test
	@DisplayName("HU8 - Cliente se inscribe correctamente")
	public void inscripcionTest() throws Exception {
	    Cliente c = new Cliente(1, "Ana", "ana", "123");
	    Turno t1 = new Turno("lunes", LocalTime.of(6, 0), LocalTime.of(20, 0));
	    Administrador a1 = new Administrador("Jorge", "0001", t1, "jorgito123@uniandes.edu.co", "soleado");
	    Juego j1 = new Juego("Uno", 2000, "Hasbro", 2, 4, 5, "Cartas", false);
	    Torneo t = new Torneo(1, "lunes", "AMISTOSO", 10, j1, a1);
	    t.inscribir(c, 2);
	    assertEquals(2, t.getTotalCuposOcupados(), "Inscripción incorrecta");
	}
	
	@Test
	@DisplayName("HU9 - Aplicar descuento correctamente")
	public void usarDescuentoTest() {
	    Descuento d = new Descuento(5000);
	    double total = d.aplicarDescuento(20000);
	    assertEquals(15000, total, "Descuento mal aplicado");
	    assertTrue(d.estaUsado(), "No se marcó como usado");
	}
}
