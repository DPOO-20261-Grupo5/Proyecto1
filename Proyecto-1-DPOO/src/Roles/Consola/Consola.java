package Consola;

import java.util.Date;

import BoardGame.Bebida;
import BoardGame.CopiaJuego;
import BoardGame.ItemVenta;
import BoardGame.Juego;
import BoardGame.Prestamo;
import BoardGame.Venta;
import Roles.Cliente;

public class Consola {
	public static void main(String[] args) {

        // Crear cliente
        Cliente cliente = new Cliente(1, "Juan", "juan123", "1234");

        // Crear juego
        Juego juego = new Juego("Catan", 1995, "Kosmos", 3, 4, 10, "Tablero", false);

        // Crear copia del juego
        CopiaJuego copia = new CopiaJuego(1, juego, "bueno");

        // Crear préstamo
        Prestamo prestamo = new Prestamo(1, new Date(), copia);

        // Asignar préstamo al cliente
        cliente.agregarPrestamo(prestamo);

        System.out.println("Préstamo realizado correctamente");

        // Crear producto 
        Bebida bebida = new Bebida("Café", 5000, false, true);

        // Crear item de venta
        ItemVenta item = new ItemVenta(bebida, 2, bebida.getPrecio());

        // Crear venta
        Venta venta = new Venta(1, new Date());
        venta.agregarItem(item);

        // Asociar venta al cliente
        cliente.agregarVenta(venta);

        // Acumular puntos
        cliente.acumularPuntos(venta.calcularTotal());

        System.out.println("Venta realizada correctamente");
        System.out.println("Total venta: " + venta.calcularTotal());
        System.out.println("Puntos del cliente: " + cliente.getPuntosFidelidad());

        // Devolver juego
        cliente.devolverPrestamo(prestamo);

        System.out.println("Juego devuelto correctamente");
    }

}
