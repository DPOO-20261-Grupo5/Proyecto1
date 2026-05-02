package Pruebas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.CopiaJuego;
import BoardGame.InventarioPrestamo;
import BoardGame.InventarioVenta;
import BoardGame.Juego;
import BoardGame.JuegoVenta;
import BoardGame.ReporteVentas;
import BoardGame.Turno;
import BoardGame.Venta;
import Roles.Administrador;

public class PruebasAdministrador {
	
	private Administrador a1;
	private Turno t1;

	@BeforeEach
	public void setUp() {
        a1 = new Administrador("Jorge", "0001", t1, "jorgito123@uniandes.edu.co", "soleado");
        t1 = new Turno("lunes", LocalTime.of(6, 0), LocalTime.of(20, 0));

	}
	
	
	@Test 
	@DisplayName("Prueba Agregar Juego Venta")
	public void agregarJuegoVentaTest() {
        InventarioVenta iv1 = new InventarioVenta();
        Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
        JuegoVenta jv1 = new JuegoVenta(j1, 20000.0, 3);
 
        int sizeAntes = iv1.getJuegosVenta().size();
        a1.agregarJuegoVenta(iv1, jv1);
        
        assertEquals(sizeAntes + 1, iv1.getJuegosVenta().size());
        assertEquals(true, iv1.getJuegosVenta().contains(jv1));

	}
	
	@Test 
	@DisplayName("Prueba Agregar Copia Prestamo")
	public void agregarCopiaPrestamoTest() {
        InventarioPrestamo ip1 = new InventarioPrestamo();
        Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
        CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
        int sizeAntes = ip1.getCopias().size();
        a1.agregarCopiaPrestamo(ip1, cj1);
        assertEquals(sizeAntes + 1, ip1.getCopias().size());
        assertEquals(true, ip1.getCopias().contains(cj1));
        
		
	}
	
	@Test 
	@DisplayName("Prueba Marcar como Robado")
	public void marcarComoRobadoTest() {
        Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
        CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
        a1.marcarComoRobado(cj1);
        assertEquals("robado", cj1.getEstado());
	}
	
	
	@Test 
	@DisplayName("Prueba Marcar como Robado")
	public void repararJuegoTest() {
        InventarioVenta iv1 = new InventarioVenta();
        InventarioPrestamo ip1 = new InventarioPrestamo();
        Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
        JuegoVenta jv1 = new JuegoVenta(j1, 20000.0, 3);
        
        int sizeInvPrestamosAntes = ip1.getCopias().size();
        int cantidadJuegoAntes = jv1.getStockDisponible();
        a1.repararJuego(ip1, iv1, jv1);
        
        assertEquals(sizeInvPrestamosAntes + 1, ip1.getCopias().size());
        assertTrue(jv1.getStockDisponible() < cantidadJuegoAntes);
		
	}
	
	@Test 
	@DisplayName("Prueba Reporte Ventas")
	public void generarReporteTest() {
	  
	    Venta v1 = new Venta(1, new Date());
	    List<Venta> ventas = new ArrayList<>();
	    ventas.add(v1);

	
	    ReporteVentas rv1 = a1.generarReporte(ventas);

	
	    assertEquals(
	        rv1.getFechaFin().minusDays(7),
	        rv1.getFechaInicio()
	    );

	    
	    assertNotNull(rv1);
	}
	}
	
	
	
	

	
	
	
	
	
	

