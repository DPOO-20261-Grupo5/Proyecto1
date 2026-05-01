package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import BoardGame.CopiaJuego;
import BoardGame.Prestamo;
import Roles.Cliente;

public class PruebasCliente {
	
	private Cliente c1;
	
	@BeforeEach
	public void setUp() {
        c1 = new Cliente(1111, "Antonio", "antonito123@uniandes.edu.co", "nublado");
        b1 = new Bebida ("JugoDeNaranja", 2500.0, false, false);
        cj1 = new CopiaJuego("")
        
    }
	
	@Test
	@DisplayName("Test agregar préstamo")
	public void agregarPrestamoTest() {
		CopiaJuego copia = new CopiaJuego(0, null, null);
        Prestamo p1 = new Prestamo(1, new Date(), copia);
        c1.agregarPrestamo(p1);
        assertEquals(1, c1.getPrestamos().size());
	}
}