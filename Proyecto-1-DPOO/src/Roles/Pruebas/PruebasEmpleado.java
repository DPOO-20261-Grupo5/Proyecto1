package Pruebas;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.Turno;
import Roles.Cocinero;
import Roles.Empleado;

public class PruebasEmpleado {

	private Turno t1;
	private Empleado e1;
	
	@BeforeEach
	public void setUp() {
		t1 = new Turno("lunes", LocalTime.of(6, 0), LocalTime.of(20, 0));
		e1 = new Cocinero("Camiquin", "003", t1, "camiquinsita123@uniandes.edu.co", "lluvioso");
	}
	
	@Test
	@DisplayName("Test tiene turno / Turno es nulo")
	public void tieneTurnoNuloTest() {
		e1.setTurno(null);
		assertFalse(e1.tieneTurno("lunes"), "Turno revisado incorrectamente");
	}
	
	@Test
	@DisplayName("Test tiene turno / Turno diferente dia")
	public void tieneTurnoDiferenteDiaTest() {
		assertFalse(e1.tieneTurno("martes"), "Turno revisado incorrectamente");
	}
	
	@Test
	@DisplayName("Test tiene turno / Condiciones Perfectas")
	public void tieneTurnoCondicionesPerfectasTest() {
		assertTrue(e1.tieneTurno("lunes"), "Turno revisado incorrectamente");
	}
}
