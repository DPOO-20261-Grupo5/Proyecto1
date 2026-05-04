package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.Bebida;
import BoardGame.CopiaJuego;
import BoardGame.ItemVenta;
import BoardGame.Juego;
import BoardGame.Pasteleria;
import BoardGame.Producto;
import BoardGame.ReporteVentas;
import BoardGame.Torneo;
import BoardGame.Turno;
import BoardGame.Venta;
import Roles.Administrador;
import Roles.Mesero;

public class PruebasIntegracionAdministrador {

	@Test
	@DisplayName("HU Admin 1 - Crear torneo")
	public void crearTorneoTest() {
	    Turno t = new Turno("lunes", LocalTime.of(6, 0), LocalTime.of(20, 0));
	    Administrador a = new Administrador("Jorge", "001", t, "jorge", "123");
	    Juego j = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
	    Torneo torneo = new Torneo(1, "lunes", "AMISTOSO", 10, j, a);
	    assertEquals(j, torneo.getJuego(), "Juego mal asignado");
	    assertEquals(a, torneo.getAdministrador(), "Administrador mal asignado");
	}
	
	@Test
	@DisplayName("HU Admin 2 - Registrar empleado")
	public void registrarEmpleadoTest() {
	    Turno t = new Turno("martes", LocalTime.of(6, 0), LocalTime.of(20, 0));
	    Mesero m = new Mesero("Juan", "002", t, "juan", "123");
	    assertEquals("Juan", m.getNombre(), "Empleado mal creado");
	}
	
	@Test
	@DisplayName("HU Admin 3 - Crear juego en inventario")
	public void gestionarInventarioTest() {
	    Juego j = new Juego("Uno", 2000, "Hasbro", 2, 4, 5, "Cartas", false);
	    CopiaJuego cj = new CopiaJuego(1, j, "bueno");
	    assertEquals(j, cj.getJuego(), "Inventario incorrecto");
	}
	
	@Test
	@DisplayName("HU Admin 4 - Cambio de turno aprobado")
	public void aprobarCambioTurnoTest() {
	    Turno t1 = new Turno("lunes", LocalTime.of(6, 0), LocalTime.of(20, 0));
	    Turno t2 = new Turno("martes", LocalTime.of(6, 0), LocalTime.of(20, 0));
	    Mesero m = new Mesero("Juan", "001", t1, "juan", "123");
	    m.setTurno(t2);
	    assertEquals("martes", m.getTurno().getDiaSemana(), "Cambio de turno no aplicado");
	}
	
	@Test
	@DisplayName("HU Admin 5 - Reporte sin ventas")
	public void reporteVentasSinVentasTest() {
	    List<Venta> ventas = new ArrayList<>();
	    ReporteVentas r = new ReporteVentas(LocalDate.now(), LocalDate.now(), ventas);
	    assertEquals(0, r.getVentasComida(), "Reporte incorrecto");
	}
	
	@Test
	@DisplayName("HU Admin 5 - Reporte con ventas")
	public void reporteVentasConVentasTest() {
	    Venta v = new Venta(1, LocalDate.now());
	    Producto bebida = new Bebida("Jugo", 3000, false, false);
	    v.agregarItem(new ItemVenta(bebida, 2, 3000)); // 2 * 3000 = 6000
	    List<Venta> ventas = new ArrayList<>();
	    ventas.add(v);
	    ReporteVentas r = new ReporteVentas(LocalDate.now(), LocalDate.now(), ventas);
	    assertEquals(6000, r.getVentasComida(), "Reporte incorrecto");
	}
	
	@Test
	@DisplayName("HU Admin 6 - Crear producto en menú")
	public void gestionarMenuTest() {
	    Producto bebida = new Bebida("Cafe", 4000, false, true);
	    Producto postre = new Pasteleria("Brownie", 5000);
	    assertEquals("Cafe", bebida.getNombre(), "Producto bebida incorrecto");
	    assertEquals("Brownie", postre.getNombre(), "Producto pastelería incorrecto");
	}
}
