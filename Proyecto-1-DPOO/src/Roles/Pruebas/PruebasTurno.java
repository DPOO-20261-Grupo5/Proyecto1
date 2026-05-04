package Pruebas;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.Turno;

public class PruebasTurno {
	
	private Turno t1;
	
	@BeforeEach
	public void setUp() {
		t1 = new Turno("lunes", LocalTime.of(6, 0), LocalTime.of(20, 0));
	}
	
	@Test
	@DisplayName("Test es mismo dia / No es")
	public void esMismoDiaNoEsTest() {
		assertFalse(t1.esMismoDia("martes"), "Mismo dia revisado incorrectamente");
	}
	
	@Test
	@DisplayName("Test es mismo dia / Si es")
	public void esMismoDiaSiEsTest() {
		assertTrue(t1.esMismoDia("lunes"), "Mismo dia revisado incorrectamente");
	}
}
