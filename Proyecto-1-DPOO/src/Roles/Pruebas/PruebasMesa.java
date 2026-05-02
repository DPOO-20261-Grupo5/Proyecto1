package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.Bebida;
import BoardGame.CopiaJuego;
import BoardGame.Juego;
import BoardGame.Mesa;
import BoardGame.Prestamo;
import BoardGame.Producto;

public class PruebasMesa {

	private Mesa m1;
	
	@BeforeEach
	public void setUp() {
		m1 = new Mesa(1, 4, 2, false, false);
	}
	
	@Test
	@DisplayName("Test puede recibir juego / Con jugadores insuficientes")
	public void puedeRecibirJuegoJugadoresInsuficientesTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		m1.setNumeroPersonas(1);
		assertFalse(m1.puedeRecibirJuego(j1), "Recibe Juego incorrectamente");
	}
	
	@Test
	@DisplayName("Test puede recibir juego / Con jugadores de más")
	public void puedeRecibirJuegoJugadoresDeMasTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		m1.setNumeroPersonas(7);
		assertFalse(m1.puedeRecibirJuego(j1), "Recibe Juego incorrectamente");
	}
	
	@Test
	@DisplayName("Test puede recibir juego / Con niños menores a edad minima")
	public void puedeRecibirJuegoConNinosMenoresAEdadMinimaTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 6, "Tablero", false);
		m1.setHayNinos(true);
		m1.setHayMenores(true);
		assertFalse(m1.puedeRecibirJuego(j1), "Recibe Juego incorrectamente");
	}
	
	@Test
	@DisplayName("Test puede recibir juego / Con menores de edad menores a edad minima")
	public void puedeRecibirJuegoConMenoresDeEdadMenoresAEdadMinimaTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 20, "Tablero", false);
		m1.setHayMenores(true);
		assertFalse(m1.puedeRecibirJuego(j1), "Recibe Juego incorrectamente");
	}
	
	@Test
	@DisplayName("Test puede recibir juego / Con niños que cumplen edad minima")
	public void puedeRecibirJuegoConNinosQueCumplenEdadMinimaTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		m1.setHayNinos(true);
		m1.setHayMenores(true);
		assertTrue(m1.puedeRecibirJuego(j1), "Recibe Juego incorrectamente");
	}
	
	@Test
	@DisplayName("Test puede recibir juego / Con menores de edad que cumplen la edad minima")
	public void puedeRecibirJuegoConMenoresDeEdadQueCumplenEdadMinimaTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 15, "Tablero", false);
		m1.setHayMenores(true);
		assertTrue(m1.puedeRecibirJuego(j1), "Recibe Juego incorrectamente");
	}
	
	@Test
	@DisplayName("Test puede recibir juego / Sin menores ni niños y con la cantidad adecuada de personas")
	public void puedeRecibirJuegoCondicionesPerfectasTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		assertTrue(m1.puedeRecibirJuego(j1), "Recibe Juego incorrectamente");
	}
	
	@Test
	@DisplayName("Test agregar préstamo / Menos de 2")
	public void agregarPrestamoMenosDe2Test() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
		Prestamo pre1 = new Prestamo(01, LocalDate.of(2025, 5, 28), cj1);
		m1.agregarPrestamo(pre1);
		assertEquals(1, m1.getPrestamos().size(), "Agrega prestamo incorrectamente");
		assertTrue(m1.getPrestamos().contains(pre1), "Agrega prestamo incorrectamente");
	}
	
	@Test
	@DisplayName("Test agregar préstamo / 2 o más")
	public void agregarPrestamo2OMasTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
		Prestamo pre1 = new Prestamo(01, LocalDate.of(2025, 5, 28), cj1);
		Juego j2 = new Juego("Uno", 1983, "Hasbro", 2, 6, 3, "Cartas", false);
		CopiaJuego cj2 = new CopiaJuego(1483, j2, "bueno");
		Prestamo pre2 = new Prestamo(02, LocalDate.of(2025, 6, 28), cj2);
		m1.agregarPrestamo(pre1);
		m1.agregarPrestamo(pre2);
		Juego j3 = new Juego("Rummy Q", 1985, "Hasbro", 2, 4, 3, "Tablero", true);
		CopiaJuego cj3 = new CopiaJuego(1734, j3, "bueno");
		Prestamo pre3 = new Prestamo(03, LocalDate.of(2025, 7, 28), cj3);
		m1.agregarPrestamo(pre3);
		assertEquals(2, m1.getPrestamos().size(), "Agrega prestamo incorrectamente");
	}
	
	@Test
	@DisplayName("Test agregar producto")
	public void agregarProductoTest() {
		Producto pro1 = new Bebida("Jugo De Naranja", 2500.0, false, false);
		m1.agregarProducto(pro1);
		assertEquals(1, m1.getProductos().size(), "Agrega producto incorrectamente");
		assertTrue(m1.getProductos().contains(pro1), "Agrega producto incorrectamente");
	}
	
	@Test
	@DisplayName("Test puede consumir bebida / Bebida alcoholica con menores")
	public void puedeConsumirBebidaAlcoholicaConMenoresTest() {
		Bebida b1 = new Bebida("Tequila", 3500.0, true, false);
		m1.setHayMenores(true);
		assertFalse(m1.puedeConsumirBebida(b1), "Bebida consumida incorrectamente");
	}
	
	@Test
	@DisplayName("Test puede consumir bebida / Bebida caliente con juego de accion")
	public void puedeConsumirBebidaCalienteConJuegoDeAccionTest() {
		Bebida b1 = new Bebida("Chocolate", 3000.0, false, true);
		Juego j1 = new Juego("Twister", 1982, "Hasbro", 2, 4, 3, "Accion", false);
		CopiaJuego cj1 = new CopiaJuego(1235, j1, "bueno");
		Prestamo pre1 = new Prestamo(03, LocalDate.of(2025, 7, 28), cj1);
		m1.agregarPrestamo(pre1);
		assertFalse(m1.puedeConsumirBebida(b1), "Bebida consumida incorrectamente");
	}
	
	@Test
	@DisplayName("Test puede consumir bebida / Condiciones perfectas")
	public void puedeConsumirBebidaCondicionesPerfectasTest() {
		Bebida b1 = new Bebida("Jugo De Naranja", 2500.0, false, false);
		assertTrue(m1.puedeConsumirBebida(b1), "Bebida consumida incorrectamente");
	}
}
