package Roles;

import java.util.List;

import BoardGame.*;

public class Administrador extends Empleado {

    // Constructor
    public Administrador(String nombre, String id, Turno turno, String login, String password) {
        super(nombre, id, turno, login, password );
    }



    public void agregarJuegoVenta(InventarioVenta inventario, JuegoVenta juego) {
        inventario.agregarJuegoVenta(juego);
    }

    public void agregarCopiaPrestamo(InventarioPrestamo inventario, CopiaJuego copia) {
        inventario.agregarCopia(copia);
    }

    public void marcarComoRobado(CopiaJuego copia) {
        copia.setEstado("robado");
    }

    public void repararJuego(InventarioPrestamo invPrestamo, InventarioVenta invVenta, JuegoVenta juegoVenta) {
        if (juegoVenta.getStockDisponible() > 0) {
            CopiaJuego nueva = new CopiaJuego(01, juegoVenta.getJuego(), "bueno");
            invPrestamo.agregarCopia(nueva);
            juegoVenta.reducirStock(juegoVenta.getStockDisponible() - 1);
        }
    }


    public ReporteVentas generarReporte(List<Venta> ventas) {
        return new ReporteVentas(
            java.time.LocalDate.now().minusDays(7),
            java.time.LocalDate.now(),
            ventas
        );
    }
}
