package Consola;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import BoardGame.*;
import Roles.Cliente;

public class Consola {

    public static void main(String[] args) {

        System.out.println("=== INICIO SIMULACIÓN BOARD GAME CAFE ===\n");

        // =========================
        // 1. INVENTARIO PRÉSTAMO
        // =========================
        InventarioPrestamo inventarioPrestamo = new InventarioPrestamo();

        Juego catan = new Juego("Catan", 1995, "Kosmos", 3, 4, 10, "Tablero", false);
        CopiaJuego copia1 = new CopiaJuego(01, catan, "bueno");
        CopiaJuego copia2 = new CopiaJuego(02, catan, "bueno");

        inventarioPrestamo.agregarCopia(copia1);
        inventarioPrestamo.agregarCopia(copia2);

        System.out.println("Inventario de préstamo inicializado\n");

        // =========================
        // 2. CLIENTE Y MESA
        // =========================
        Cliente cliente = new Cliente(1, "Juan", "juan123", "1234");

        Mesa mesa = new Mesa(1, 4, 3, false, true); // 3 personas, hay menores
        cliente.asignarMesa(mesa);

        System.out.println("Cliente asignado a mesa\n");

        // =========================
        // 3. VALIDAR Y HACER PRÉSTAMO
        // =========================
        if (inventarioPrestamo.hayDisponible(catan) &&
            catan.esAptoPara(mesa.getNumeroPersonas(), 15)) {

            CopiaJuego copiaDisponible = inventarioPrestamo.buscarDisponibles(catan).get(0);

            Prestamo prestamo = new Prestamo(1, new Date(), copiaDisponible);
            copiaDisponible.prestado();
            cliente.agregarPrestamo(prestamo);

            System.out.println("Préstamo realizado: " + catan.getNombre());
        } else {
            System.out.println("No se puede realizar el préstamo");
        }

        // =========================
        // 4. INVENTARIO VENTA
        // =========================
        InventarioVenta inventarioVenta = new InventarioVenta();

        JuegoVenta juegoVenta = new JuegoVenta(catan, 5, 120000);
        inventarioVenta.agregarJuegoVenta(juegoVenta);

        System.out.println("\nInventario de venta inicializado");

        // =========================
        // 5. CREAR PRODUCTOS
        // =========================
        Bebida cafe = new Bebida("Café", 5000, false, true);
        Pasteleria torta = new Pasteleria("Torta", 8000);

        // =========================
        // 6. CREAR VENTA
        // =========================
        Venta venta = new Venta(1, new Date());

        ItemVenta item1 = new ItemVenta(cafe, 2, cafe.getPrecio());
        ItemVenta item2 = new ItemVenta(torta, 1, torta.getPrecio());
        ItemVenta item3 = new ItemVenta(juegoVenta, 1, juegoVenta.getPrecio());

        venta.agregarItem(item1);
        venta.agregarItem(item2);
        venta.agregarItem(item3);

        cliente.agregarVenta(venta);

        System.out.println("\nVenta realizada:");
        System.out.println("Subtotal: " + venta.calcularSubtotal());
        System.out.println("Impuestos: " + venta.calcularImpuestos());
        System.out.println("Propina: " + venta.calcularPropina());
        System.out.println("TOTAL: " + venta.calcularTotal());

        // =========================
        // 7. PUNTOS FIDELIDAD
        // =========================
        cliente.acumularPuntos(venta.calcularTotal());

        System.out.println("\nPuntos acumulados: " + cliente.getPuntosFidelidad());

        // =========================
        // 8. DEVOLVER JUEGO
        // =========================
        Prestamo prestamo = cliente.getPrestamos().get(0);
        prestamo.devolver(new Date());
        copia1.devuelto();
        cliente.devolverPrestamo(prestamo);

        System.out.println("\nJuego devuelto correctamente");

        // =========================
        // 9. REPORTE DE VENTAS
        // =========================
        List<Venta> ventas = new ArrayList<>();
        ventas.add(venta);

        ReporteVentas reporte = new ReporteVentas(
                java.time.LocalDate.now().minusDays(1),
                java.time.LocalDate.now(),
                ventas
        );

        System.out.println("\n" + reporte.mostrarReporte());

        System.out.println("\n=== FIN SIMULACIÓN ===");
    }
}
