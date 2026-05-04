package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.Inscripcion;
import BoardGame.Juego;
import BoardGame.Torneo;
import BoardGame.Turno;
import Roles.Administrador;
import Roles.Cocinero;
import Roles.Mesero;
import Roles.Usuario;

public class PruebasInscripcion {
	
	private Turno t1;
	private Turno t2;
	private Juego j1;
	private Administrador a1;
	private Inscripcion i1;
	private Usuario u1;
	private Torneo to1;
	
	@BeforeEach
	public void setUp() {
		t1 = new Turno("lunes", LocalTime.of(6, 0), LocalTime.of(20, 0));
		t2 = new Turno("martes", LocalTime.of(6, 0), LocalTime.of(20, 0));
		u1 = new Mesero("Juanfe", "004", t2, "juanfesito123@uniandes.edu.co", "templado");
		a1 = new Administrador("Jorge", "0001", t1, "jorgito123@uniandes.edu.co", "soleado");
		j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		to1 = new Torneo(01, "19/05/25", "Amistoso", 10, j1, a1);
		i1 = new Inscripcion(u1, to1, 2, true);
	}
	
	@Test
	@DisplayName("Test pertenece a / No pertenece")
	public void perteneceANoTest() {
		Usuario u2 = new Cocinero("Henry", "002", t2, "henrysito123@uniandes.edu.co", "nevado");
		assertFalse(i1.perteneceA(u2), "Pertenecencia revisada incorrectamente");
	}
	
	@Test
	@DisplayName("Test pertenece a / Si pertenece")
	public void perteneceASiTest() {
		assertTrue(i1.perteneceA(u1), "Pertenecencia revisada incorrectamente");
	}
	
	@Test
	@DisplayName("Test aumentar cupos / Más cupos de los permitidos")
	public void aumentarCuposMasTest() {
		i1.aumentarCupos(2);
		assertEquals(2, i1.getCantidadCupos(), "Cupos aumentados incorrectamente");
	}
	
	@Test
	@DisplayName("Test aumentar cupos / Cupos permitidos")
	public void aumentarCuposPermitidosTest() {
		i1.aumentarCupos(1);
		assertEquals(3, i1.getCantidadCupos(), "Cupos aumentados incorrectamente");
	}
	
	@Test
	@DisplayName("Test reducir cupos / Cupos no permitidos")
	public void reducirCuposNoPermitidosTest() {
		i1.reducirCupos(3);
		assertEquals(2, i1.getCantidadCupos(), "Cupos reducidos incorrectamente");
	}
	
	@Test
	@DisplayName("Test reducir cupos / Cupos permitidos")
	public void reducirCuposPermitidosTest() {
		i1.reducirCupos(1);
		assertEquals(1, i1.getCantidadCupos(), "Cupos reducidos incorrectamente");
	}
}
