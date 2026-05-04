package Pruebas;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.Juego;

public class PruebasJuego {

	private Juego j1;
	
	@BeforeEach
	public void setUp() {
		j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
	}
	
	@Test
	@DisplayName("Test es apto para / Jugadores insuficientes")
	public void esAptoParaJugadoresInsuficientesTest() {
		assertFalse(j1.esAptoPara(1, 5));
	}
	
	@Test
	@DisplayName("Test es apto para / Jugadores de más")
	public void esAptoParaJugadoresDeMasTest() {
		assertFalse(j1.esAptoPara(7, 15));
	}
	
	@Test
	@DisplayName("Test es apto para / Jugadores menores que edad minima")
	public void esAptoParaJugadoresMenoresQueEdadMinimaTest() {
		assertFalse(j1.esAptoPara(3, 2));
	}
	
	@Test
	@DisplayName("Test es apto para / Condiciones Perfectas")
	public void esAptoParaCondicionesPerfectasTest() {
		assertTrue(j1.esAptoPara(3, 8));
	}
}
