package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.CopiaJuego;
import BoardGame.Juego;
import BoardGame.Prestamo;
import Roles.Cliente;

public class PruebasCliente {
	
	private Cliente c1;
	
	@BeforeEach
	public void setUp() {
        c1 = new Cliente(1111, "Antonio", "antonito123@uniandes.edu.co", "nublado");
        b1 = new Bebida("Jugo De Naranja", 2500.0, false, false);
        j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
        cj1 = new CopiaJuego(1234, j1, "bueno");
        ip1 = new InventarioPrestamo();
        iv1 = new InventarioVenta();
        pro1 = new Producto("Pastel", 3000.0);
        itv1 = new ItemVenta(pro1, 10, 3000.0);
        jv1 = new JuegoVenta(j1, 20000.0, 3);
        m1 = new Mesa(1, 4, 2, false, false);
        pas1 = new Pasteleria("Tres leches", 4500.0);
        pla1 = new Platillo("Flan", 5000.0);
        pre1 = new Prestamo(01, new LocalDate.of(2025, 5, 28), cj1);
        v1 = new Venta(001, new LocalDate.of(2025, 12, 11));
        rv1 = new ReporteVentas(new LocalDate.of(2024, 5, 6), new LocalDate.of(2024, 5, 8), new ArrayList<Venta>(v1));
        sct1 = new SolicitudCambioTurno(123, e1, t1, t2, "intercambio");
        t1 = new Turno("lunes", LocalTime.of(6, 0), LocalTime.of(20, 0));
        t2 = new Turno("martes", LocalTime.of(6, 0), LocalTime.of(20, 0));
        a1 = new Administrador("Jorge", "0001", t1, "jorgito123@uniandes.edu.co", "soleado");
        co1 = new Cocinero("Henry", "002", t2, "henrysito123@uniandes.edu.co", "nevado");
        e1 = new Empleado("Camiquin", "003", t1, "camiquinsita123@uniandes.edu.co", "lluvioso");
        me1 = new Mesero("Juanfe", "004", t2, "juanfesito123@uniandes.edu.co", "templado");
        u1 = new Usuario("005", "Andres", "andresito123@uniandes.edu.co", "seco");
    }
	
	@Test
	@DisplayName("Test agregar préstamo")
	public void agregarPrestamoTest() {
		Juego j1 = new Juego("Monopoly", 1987, "Hasbro", 2, 6, 3, "Tablero", false);
		CopiaJuego cj1 = new CopiaJuego(1234, j1, "bueno");
        Prestamo pre1 = new Prestamo(1, new Date(), cj1);
        c1.agregarPrestamo(pre1);
        assertEquals(1, c1.getPrestamos().size());
	}
	
	
}