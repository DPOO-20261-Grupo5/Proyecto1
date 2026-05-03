package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.CopiaJuego;
import BoardGame.Descuento;
import BoardGame.Juego;
import BoardGame.Mesa;
import BoardGame.Prestamo;
import BoardGame.Venta;
import Roles.Cliente;

public class PruebasCliente {
	
	private Cliente c1;
	
	@BeforeEach
	public void setUp() {
        c1 = new Cliente(1111, "Antonio", "antonito123@uniandes.edu.co", "nublado");
    }
	
	@Test
	@DisplayName("Test agregar préstamo / Préstamos menor a 2")
	public void agregarPrestamoMenorA2Test() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
        Prestamo pre1 = new Prestamo(1, LocalDate.of(2025, 12, 11), cj1);
        c1.agregarPrestamo(pre1);
        assertEquals(1, c1.getPrestamos().size(), "Préstamo agregado incorrectamente");
	}
	
	@Test
	@DisplayName("Test agregar préstamo / Préstamos 2 o más")
	public void agregarPrestamo2OMasTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
        Prestamo pre1 = new Prestamo(1, LocalDate.of(2025, 12, 11), cj1);
        Juego j2 = new Juego("Uno", 1983, "Hasbro", 2, 6, 3, "Cartas", false);
		CopiaJuego cj2 = new CopiaJuego(1324, j2, "bueno");
        Prestamo pre2 = new Prestamo(2, LocalDate.of(2025, 11, 12), cj2);
        Juego j3 = new Juego("Risk", 1984, "Hasbro", 2, 4, 6, "Tablero", true);
		CopiaJuego cj3 = new CopiaJuego(1342, j3, "bueno");
        Prestamo pre3 = new Prestamo(3, LocalDate.of(2025, 11, 12), cj3);
        c1.agregarPrestamo(pre1);
        c1.agregarPrestamo(pre2);
        c1.agregarPrestamo(pre3);
        assertEquals(2, c1.getPrestamos().size(), "Préstamo agregado incorrectamente");
	}
	
	@Test
	@DisplayName("Test devolver préstamo / Si está")
	public void devolverPrestamoSiEstaTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
        Prestamo pre1 = new Prestamo(1, LocalDate.of(2025, 12, 11), cj1);
        c1.agregarPrestamo(pre1);
        c1.devolverPrestamo(pre1);
        assertEquals(0, c1.getPrestamos().size(), "Préstamo devuelto incorrectamente");
	}
	
	@Test
	@DisplayName("Test devolver préstamo / No está")
	public void devolverPrestamoNoEstaTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
        Prestamo pre1 = new Prestamo(1, LocalDate.of(2025, 12, 11), cj1);
        c1.devolverPrestamo(pre1);
        assertEquals(0, c1.getPrestamos().size(), "Préstamo devuelto incorrectamente");
	}
	
	@Test
	@DisplayName("Test asignar mesa")
	public void asignarMesaTest() {
		Mesa m1 = new Mesa(1, 4, 2, false, false);
		c1.asignarMesa(m1);
        assertEquals(m1, c1.getMesa(), "Mesa asignada incorrectamente");
	}
	
	@Test
	@DisplayName("Test liberar mesa / Asignada")
	public void liberarMesaAsignadaTest() {
		Mesa m1 = new Mesa(1, 4, 2, false, false);
		c1.asignarMesa(m1);
		c1.liberarMesa();
        assertEquals(null, c1.getMesa(), "Mesa liberada incorrectamente");
	}
	
	@Test
	@DisplayName("Test liberar mesa / Sin asignar")
	public void liberarMesaSinAsignarTest() {
		c1.liberarMesa();
        assertEquals(null, c1.getMesa(), "Mesa liberada incorrectamente");
	}
	
	@Test
	@DisplayName("Test agregar venta")
	public void agregarVentaTest() {
		Venta v1 = new Venta(001, LocalDate.of(2025, 12, 11));
		c1.agregarVenta(v1);
        assertEquals(1, c1.getVentas().size(), "Venta agregada incorrectamente");
	}
	
	@Test
	@DisplayName("Test agregar juego favorito / Sin estar")
	public void agregarJuegoFavoritoSinEstarTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		c1.agregarJuegoFavorito(j1);
        assertEquals(1, c1.getJuegosFavoritos().size(), "Juego favorito agregado incorrectamente");
	}
	
	@Test
	@DisplayName("Test agregar juego favorito / Estando")
	public void agregarJuegoFavoritoEstandoTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		c1.agregarJuegoFavorito(j1);
		c1.agregarJuegoFavorito(j1);
        assertEquals(1, c1.getJuegosFavoritos().size(), "Juego favorito agregado incorrectamente");
	}
	
	@Test
	@DisplayName("Test acumular puntos")
	public void acumularPuntosTest() {
		c1.acumularPuntos(50500.0);
        assertEquals(505, c1.getPuntosFidelidad(), "Puntos acumulados incorrectamente");
	}
	
	@Test
	@DisplayName("Test agregar descuento / Descuento nulo")
	public void agregarDescuentoNuloTest() {
		c1.agregarDescuento(null);
        assertEquals(0, c1.getDescuentos().size(), "Descuento agregado incorrectamente");
	}
	
	@Test
	@DisplayName("Test agregar descuento / Con descuento")
	public void agregarDescuentoConTest() {
		Descuento d1 = new Descuento(300.0);
		c1.agregarDescuento(d1);
        assertEquals(1, c1.getDescuentos().size(), "Descuento agregado incorrectamente");
	}
	
	@Test
	@DisplayName("Test obtener descuento disponible / Sin descuentos")
	public void obtenerDescuentoDisponibleSinDescuentosTest() {
        assertEquals(null, c1.obtenerDescuentoDisponible(), "Descuento obtenido incorrectamente");
	}
	
	@Test
	@DisplayName("Test obtener descuento disponible / Con descuento usado")
	public void obtenerDescuentoDisponibleConDescuentoUsadoTest() {
		Descuento d1 = new Descuento(300.0);
		d1.usar();
		c1.agregarDescuento(d1);
        assertEquals(null, c1.obtenerDescuentoDisponible(), "Descuento obtenido incorrectamente");
	}
	
	@Test
	@DisplayName("Test obtener descuento disponible / Con descuento sin usar")
	public void obtenerDescuentoDisponibleConDescuentoSinUsarTest() {
		Descuento d1 = new Descuento(300.0);
		c1.agregarDescuento(d1);
        assertEquals(d1, c1.obtenerDescuentoDisponible(), "Descuento obtenido incorrectamente");
	}
}