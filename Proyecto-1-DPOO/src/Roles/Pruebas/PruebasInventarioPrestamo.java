package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.CopiaJuego;
import BoardGame.InventarioPrestamo;
import BoardGame.Juego;

public class PruebasInventarioPrestamo {
	
	private InventarioPrestamo ip1;
	
	@BeforeEach
	public void setUp() {
		ip1 = new InventarioPrestamo();
	}
	
	@Test
	@DisplayName("Test agregar copia")
	public void agregarCopiaTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
        CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
        ip1.agregarCopia(cj1);
        assertEquals(1, ip1.getCopias().size(), "Copia agregada incorrectamente");
        assertTrue(ip1.getCopias().contains(cj1), "Copia agregada incorrectamente");
	}
	
	@Test
	@DisplayName("Test hay disponible / Esta el juego pero no disponible")
	public void hayDisponibleSinDisponibilidadTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
        CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
        cj1.setDisponible(false);
        ip1.agregarCopia(cj1);
        assertFalse(ip1.hayDisponible(j1), "Disponibilidad revisada incorrectamente");
	}
	
	@Test
	@DisplayName("Test hay disponible / No esta el juego")
	public void hayDisponibleSinEstarTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
        assertFalse(ip1.hayDisponible(j1), "Disponibilidad revisada incorrectamente");
	}
	
	@Test
	@DisplayName("Test hay disponible / Esta el juego disponible")
	public void hayDisponibleConDisponibilidadTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
        CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
        ip1.agregarCopia(cj1);
        assertTrue(ip1.hayDisponible(j1), "Disponibilidad revisada incorrectamente");
	}
	
	@Test
	@DisplayName("Test hay disponible / Esta otro juego")
	public void hayDisponibleEstaOtroJuegoTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		Juego j2 = new Juego("Uno", 1983, "Hasbro", 2, 6, 3, "Cartas", false);
        CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
        cj1.setDisponible(false);
        ip1.agregarCopia(cj1);
        assertFalse(ip1.hayDisponible(j2), "Disponibilidad revisada incorrectamente");
	}
	
	@Test
	@DisplayName("Test buscar disponibles / Estan los juegos pero no disponibles")
	public void buscarDisponibleSinDisponibilidadTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
        CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
        cj1.setDisponible(false);
        ip1.agregarCopia(cj1);
        assertEquals(0, ip1.buscarDisponibles(j1).size(), "Busqueda de disponibilidad revisada incorrectamente");
	}
	
	@Test
	@DisplayName("Test buscar disponibles / No estan los juegos")
	public void buscarDisponiblesSinEstarTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
        assertEquals(0, ip1.buscarDisponibles(j1).size(), "Busqueda de disponibilidad revisada incorrectamente");
	}
	
	@Test
	@DisplayName("Test buscar disponibles / Estan los juegos disponibles")
	public void buscarDisponiblesConDisponibilidadTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
        CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
        ip1.agregarCopia(cj1);
        assertEquals(1, ip1.buscarDisponibles(j1).size(), "Busqueda de disponibilidad revisada incorrectamente");
	}
	
	@Test
	@DisplayName("Test buscar disponibles / Estan otros juegos")
	public void buscarDisponiblesEstanOtrosJuegosTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		Juego j2 = new Juego("Uno", 1983, "Hasbro", 2, 6, 3, "Cartas", false);
        CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
        cj1.setDisponible(false);
        ip1.agregarCopia(cj1);
        assertEquals(0, ip1.buscarDisponibles(j2).size(), "Busqueda de disponibilidad revisada incorrectamente");
	}
}
