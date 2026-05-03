package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.Inscripcion;
import BoardGame.Juego;
import BoardGame.Torneo;
import BoardGame.Turno;
import Roles.Administrador;
import Roles.Cliente;
import Roles.Cocinero;
import Roles.Mesero;
import Roles.Usuario;

public class PruebasTorneo {

	private Turno t1;
	private Turno t2;
	private Usuario u1;
	private Administrador a1;
	private Juego j1;
	private Torneo to1;
	
	@BeforeEach
	public void setUp() {
		t1 = new Turno("lunes", LocalTime.of(6, 0), LocalTime.of(20, 0));
		a1 = new Administrador("Jorge", "0001", t1, "jorgito123@uniandes.edu.co", "soleado");
		j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		to1 = new Torneo(01, "lunes", "AMISTOSO", 10, j1, a1);
		t2 = new Turno("martes", LocalTime.of(6, 0), LocalTime.of(20, 0));
		u1 = new Mesero("Juanfe", "004", t2, "juanfesito123@uniandes.edu.co", "templado");
	}
	
	@Test
	@DisplayName("Test inscribir / Cupos de menos")
	public void inscribirCuposDeMenosTest() {
	    assertThrows(Exception.class, () -> {to1.inscribir(u1, 0);}, "Inscrito incorrectamente");
	}
	
	@Test
	@DisplayName("Test inscribir / Cupos de más")
	public void inscribirCuposDeMasTest() {
	    assertThrows(Exception.class, () -> {to1.inscribir(u1, 4);}, "Inscrito incorrectamente");
	}
	
	@Test
	@DisplayName("Test inscribir / Usuario ya inscrito")
	public void inscribirUsuarioYaInscritoTest() throws Exception {
	    to1.inscribir(u1, 2);
	    assertThrows(Exception.class, () -> {to1.inscribir(u1, 1);}, "Inscrito incorrectamente");
	}
	
	@Test
	@DisplayName("Test inscribir / Empleado con turno")
	public void inscribirEmpleadoConTurnoTest() {
	    Usuario u2 = new Mesero("Pedro", "005", t1, "pedrito123@uniandes.edu.co", "niebla");
	    assertThrows(Exception.class, () -> {to1.inscribir(u2, 1);}, "Inscrito incorrectamente");
	}
	
	@Test
    @DisplayName("Test inscribir / sin cupos suficientes")
    public void inscribirSinCuposTest() throws Exception {
        to1.inscribir(u1, 3);
        Usuario u2 = new Cocinero("Henry", "002", t2, "henrysito123@uniandes.edu.co", "soleado");
        to1.inscribir(u2, 3);
        Usuario u3 = new Cocinero("Luis", "003", t2, "luisito123@uniandes.edu.co", "seco");
        to1.inscribir(u3, 3);
        Usuario u4 = new Cocinero("Carlos", "004", t2, "carlitos123@uniandes.edu.co", "lluvioso");
        assertThrows(Exception.class, () -> {to1.inscribir(u4, 3);}, "Inscrito incorrectamente");
    }
	
	@Test
	@DisplayName("Test inscribir / Válido")
	public void inscribirValidoTest() throws Exception {
	    to1.inscribir(u1, 2);
	    assertEquals(2, to1.getTotalCuposOcupados(), "Inscrito incorrectamente");
	}
	
	@Test
	@DisplayName("Test inscribir / Cliente no fanático")
	public void inscribirClienteNoFanaticoTest() throws Exception {
	    Cliente c1 = new Cliente(2, "Luis", "luisito123@uniandes.edu.co", "nevado");
	    to1.inscribir(c1, 2);
	    Inscripcion i1 = to1.getInscritos().get(0);
	    assertFalse(i1.esFanatico(), "Inscrito incorrectamente");
	}
	
	@Test
	@DisplayName("Test desinscribir / Usuario inscrito")
	public void desinscribirUsuarioInscritoTest() {
	    Inscripcion i1 = new Inscripcion(u1, to1, 2, false);
	    to1.getInscritos().add(i1);
	    to1.desinscribir(u1);
	    assertEquals(0, to1.getInscritos().size(), "Desinscrito incorrectamente");
	}
	
	@Test
	@DisplayName("Test desinscribir / Usuario no inscrito")
	public void desinscribirUsuarioNoInscritoTest() {
	    Usuario u2 = new Cocinero("Pedro", "002", t2, "pedrito123@uniandes.edu.co", "templado");
	    to1.desinscribir(u2);
	    assertEquals(0, to1.getInscritos().size(), "Desinscrito incorrectamente");
	}
	
	@Test
	@DisplayName("Test desinscribir / Múltiples inscripciones")
	public void desinscribirMultiplesTest() {
	    Inscripcion i1 = new Inscripcion(u1, to1, 1, false);
	    Inscripcion i2 = new Inscripcion(u1, to1, 2, false);
	    to1.getInscritos().add(i1);
	    to1.getInscritos().add(i2);
	    to1.desinscribir(u1);
	    assertEquals(0, to1.getInscritos().size(), "Desinscrito incorrectamente");
	}
	
	@Test
	@DisplayName("Test desinscribir / Lista vacía")
	public void desinscribirListaVaciaTest() {
	    to1.desinscribir(u1);
	    assertEquals(0, to1.getInscritos().size(), "Desinscrito incorrectamente");
	}
	
	@Test
	@DisplayName("Test desinscribir / Lista con otros usuarios")
	public void desinscribirUsuarioDiferenteTest() {
	    Usuario u2 = new Cocinero("Pedro", "002", t2, "pedrito123@uniandes.edu.co", "lluvioso");
	    Inscripcion i1 = new Inscripcion(u2, to1, 2, false);
	    to1.getInscritos().add(i1);
	    to1.desinscribir(u1);
	    assertEquals(1, to1.getInscritos().size(), "Desinscrito incorrectamente");
	}
	
	@Test
	@DisplayName("Test cupos fanáticos / Valor exacto")
	public void calcularCuposFanaticosExactoTest() {
	    Torneo to1 = new Torneo(1, "lunes", "AMISTOSO", 10, j1, a1);
	    int resultado = to1.calcularCuposFanaticos();
	    assertEquals(2, resultado, "Cupos fanáticos calculados incorrectamente");
	}
	
	@Test
	@DisplayName("Test cupos fanáticos / valor decimal")
	public void calcularCuposFanaticosDecimalTest() {
	    Torneo to1 = new Torneo(1, "lunes", "AMISTOSO", 7, j1, a1);
	    int resultado = to1.calcularCuposFanaticos();
	    assertEquals(2, resultado, "Cupos fanáticos calculados incorrectamente");
	}
	
	@Test
	@DisplayName("Test otorgar premio / Tipo amistoso")
	public void otorgarPremioAmistosoTest() {
	    Cliente c1 = new Cliente(1, "Ana", "anita123@uniandes.edu.co", "seco");
	    Torneo to1 = new Torneo(1, "lunes", "AMISTOSO", 10, j1, a1);
	    to1.otorgarPremio(c1);
	    assertEquals(1, c1.getDescuentos().size(), "Premio otorgado incorrectamente");
	}
	
	@Test
	@DisplayName("Test otorgar premio / Tipo competitivo")
	public void otorgarPremioCompetitivoTest() {
	    Cliente c1 = new Cliente(2, "Luis", "luisito123@uniandes.edu.co", "lluvioso");
	    Torneo to1 = new Torneo(1, "lunes", "COMPETITIVO", 10, j1, a1);
	    to1.otorgarPremio(c1);
	    assertEquals(0, c1.getDescuentos().size(), "Premio otorgado incorrectamente");
	}
	
	@Test
	@DisplayName("Otorgar premio / tipo inválido")
	public void otorgarPremioTipoInvalidoTest() {
	    Cliente c1 = new Cliente(3, "Pedro", "pedrito123@uniandes.edu.co", "nevado");
	    Torneo to1 = new Torneo(1, "lunes", "OTRO", 10, j1, a1);
	    to1.otorgarPremio(c1);
	    assertEquals(0, c1.getDescuentos().size(), "Premio otorgado incorrectamente");
	}
}
