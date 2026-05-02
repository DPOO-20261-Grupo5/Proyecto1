package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.SolicitudCambioTurno;
import BoardGame.Turno;
import Roles.Cocinero;
import Roles.Empleado;

public class PruebasSolicitudCambioTurno {
	
	private Turno t1;
	private Turno t2;
	private Empleado e1;
	private SolicitudCambioTurno sct1;
	
	@BeforeEach
	public void setUp() {
		t1 = new Turno("lunes", LocalTime.of(6, 0), LocalTime.of(20, 0));
        t2 = new Turno("martes", LocalTime.of(6, 0), LocalTime.of(20, 0));
		e1 = new Cocinero("Camiquin", "003", t1, "camiquinsita123@uniandes.edu.co", "lluvioso");
		sct1 = new SolicitudCambioTurno(123, e1, t1, t2, "intercambio");
	}
	
	@Test
	@DisplayName("Test asignar otro empleado")
	public void asignarOtroEmpleadoTest() {
		sct1.asignarOtroEmpleado(e1);
		assertEquals(e1, sct1.getOtroEmpleado(), "Otro empleado asignado incorrectamente");
	}
	
	@Test
	@DisplayName("Test aprobar")
	public void aprobarTest() {
		sct1.aprobar();
		assertEquals("APROBADO", sct1.getEstado(), "Aprobado incorrectamente");
	}
	
	@Test
	@DisplayName("Test rechazar")
	public void rechazarTest() {
		sct1.rechazar();
		assertEquals("RECHAZADO", sct1.getEstado(), "Rechazado incorrectamente");
	}
}