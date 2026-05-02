package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.Juego;
import BoardGame.Turno;
import Roles.Mesero;

public class PruebasMesero {
	
	private Mesero me1;
	private Turno t2;
	
	@BeforeEach
	public void setUp() {
		t2 = new Turno("martes", LocalTime.of(6, 0), LocalTime.of(20, 0));
		me1 = new Mesero("Juanfe", "004", t2, "juanfesito123@uniandes.edu.co", "templado");
	}
	
	@Test
	@DisplayName("Test agregar juego / Sin estar antes")
	public void agregarJuegoSinEstarTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		assertFalse(me1.getJuegosQuePuedeExplicar().contains(j1), "Juego ya contenido");
	    int tamañoAntes = me1.getJuegosQuePuedeExplicar().size();
	    me1.agregarJuego(j1);
	    assertTrue(me1.getJuegosQuePuedeExplicar().contains(j1), "Juego no insertado");
	    assertEquals(tamañoAntes + 1, me1.getJuegosQuePuedeExplicar().size(), "Juego no insertado");
	}
	
	@Test
	@DisplayName("Test agregar juego / Estando antes")
	public void agregarJuegoEstandoTest() {
	    Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
	    me1.agregarJuego(j1);
	    assertTrue(me1.getJuegosQuePuedeExplicar().contains(j1), "Juego no contenido");
	    int tamaño = me1.getJuegosQuePuedeExplicar().size();
	    me1.agregarJuego(j1);
	    assertEquals(tamaño, me1.getJuegosQuePuedeExplicar().size(), "Juego duplicado");
	}
	
	@Test
	@DisplayName("Test puede explicar / Sin estar")
	public void puedeExplicarSinEstarTest() {
	    Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
	    assertFalse(me1.puedeExplicar(j1), "Juego explicado sin saber");
	}
	
	@Test
	@DisplayName("Test puede explicar / Estando")
	public void puedeExplicarEstandoTest() {
	    Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
	    me1.agregarJuego(j1);
	    assertTrue(me1.puedeExplicar(j1), "Juego no explicado sabiendo");
	}
}
