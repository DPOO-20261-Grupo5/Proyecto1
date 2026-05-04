package Pruebas;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.Bebida;
import BoardGame.ItemVenta;
import BoardGame.Juego;
import BoardGame.Pasteleria;
import BoardGame.Producto;
import BoardGame.Torneo;
import BoardGame.Turno;
import BoardGame.Venta;
import Roles.Administrador;
import Roles.Mesero;

public class PruebasIntegracionEmpleado {

	@Test
	@DisplayName("HU Empleado 1 - Consultar turno")
	public void consultarTurnoTest() {
	    Turno t = new Turno("lunes", LocalTime.of(6, 0), LocalTime.of(20, 0));
	    Mesero m = new Mesero("Juan", "001", t, "juan@uniandes.edu.co", "123");
	    assertEquals("lunes", m.getTurno().getDiaSemana(), "Turno incorrecto");
	}
	
	@Test
	@DisplayName("HU Empleado 2 - Cambio de turno")
	public void cambioTurnoTest() {
	    Turno t1 = new Turno("lunes", LocalTime.of(6, 0), LocalTime.of(20, 0));
	    Turno t2 = new Turno("martes", LocalTime.of(6, 0), LocalTime.of(20, 0));
	    Mesero m = new Mesero("Juan", "001", t1, "juan", "123");
	    m.setTurno(t2);
	    assertEquals("martes", m.getTurno().getDiaSemana(), "No cambió el turno");
	}
	
	@Test
	@DisplayName("HU Empleado 3 - Inscripción a torneo sin turno")
	public void inscripcionEmpleadoSinTurnoTest() {
		Turno t1 = new Turno("lunes", LocalTime.of(6, 0), LocalTime.of(20, 0));
		Administrador a1 = new Administrador("Jorge", "0001", t1, "jorgito123@uniandes.edu.co", "soleado");
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
	    Turno tEmpleado = new Turno("martes", LocalTime.of(6, 0), LocalTime.of(20, 0));
	    Mesero m = new Mesero("Juan", "001", tEmpleado, "juan", "123");
	    Torneo t = new Torneo(1, "lunes", "AMISTOSO", 10, j1, a1);
	    assertDoesNotThrow(() -> {t.inscribir(m, 2);}, "No se inscribió al torneo sin turno");
	}
	
	@Test
	@DisplayName("HU Empleado 3 - Inscripción con turno")
	public void inscripcionEmpleadoConTurnoTest() {
		Turno t1 = new Turno("lunes", LocalTime.of(6, 0), LocalTime.of(20, 0));
		Administrador a1 = new Administrador("Jorge", "0001", t1, "jorgito123@uniandes.edu.co", "soleado");
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
	    Turno tEmpleado = new Turno("lunes", LocalTime.of(6, 0), LocalTime.of(20, 0));
	    Mesero m = new Mesero("Juan", "001", tEmpleado, "juan", "123");
	    Torneo t = new Torneo(1, "lunes", "AMISTOSO", 10, j1, a1);
	    assertThrows(Exception.class, () -> {t.inscribir(m, 1);}, "Se inscribió al torneo con turno");
	}
	
	@Test
	@DisplayName("HU Empleado 4 - Compra producto con total positivo")
	public void compraEmpleadoTotalPositivoTest() {
	    Producto bebida = new Bebida("Cafe", 5000, false, true);
	    ItemVenta item = new ItemVenta(bebida, 2, 5000);
	    Venta v = new Venta(1, LocalDate.now());
	    v.agregarItem(item);
	    double total = v.calcularTotal();
	    assertEquals(11800, total, "Total calculado incorrectamente");
	}
	
	@Test
	@DisplayName("HU Empleado 4 - Compra sin productos")
	public void compraEmpleadoSinProductosTest() {
	    Venta v = new Venta(1, LocalDate.now());
	    double total = v.calcularTotal();
	    assertEquals(0, total, "El total debería ser 0");
	}
	
	@Test
	@DisplayName("HU Empleado 5 - Sugerir producto")
	public void sugerirProductoTest() {
	    Producto nuevo = new Pasteleria("Cheesecake", 8000);
	    assertEquals("Cheesecake", nuevo.getNombre(), "Producto no creado correctamente");
	}
}
