package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.CopiaJuego;
import BoardGame.Juego;

public class PruebasCopiaJuego {
	
	private Juego j1;
	private CopiaJuego cj1;
	
	@BeforeEach
	public void setup() {
		j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		cj1 = new CopiaJuego(1234, j1, "bueno");
	}
	
	@Test
	@DisplayName("Test prestado / Estando disponible")
	public void prestadoEstandoDisponibleTest() {
		int antes = cj1.getVecesPrestado();
		cj1.prestado();
		assertEquals(false, cj1.getDisponible(), "Prestado incorrectamente");
		assertEquals(antes + 1, cj1.getVecesPrestado(), "Prestado incorrectamente");
	}
	
	@Test
	@DisplayName("Test prestado / Sin estar disponible")
	public void prestadoSinEstarDisponibleTest() {
		int antes = cj1.getVecesPrestado();
		cj1.setDisponible(false);
		cj1.prestado();
		assertEquals(antes, cj1.getVecesPrestado(), "Prestado incorrectamente");
	}
	
	@Test
	@DisplayName("Test devuelto")
	public void devueltoTest() {
		cj1.setDisponible(false);
		cj1.devuelto();
		assertEquals(true, cj1.getDisponible(), "Devuelto incorrectamente");
	}
}
