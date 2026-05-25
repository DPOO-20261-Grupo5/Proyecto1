package Consola;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import Roles.Administrador;
import Roles.Mesero;
import BoardGame.*;

public class ConsolaAdminMain {

    public static void main(String[] args) {

        Administrador admin =
                new Administrador(
                        "Admin",
                        "001",
                        null,
                        "admin",
                        "123");

        InventarioVenta invVenta = new InventarioVenta();
        InventarioPrestamo invPrestamo = new InventarioPrestamo();

        List<Torneo> torneos = new ArrayList<>();
        List<SolicitudCambioTurno> solicitudes = new ArrayList<>();
        List<Venta> ventas = new ArrayList<>();

        // =========================
        // DATOS DEMO
        // =========================

        Juego catan = new Juego(
                "Catan",
                1995,
                "Kosmos",
                3,
                4,
                10,
                "TABLERO",
                false);

        Juego uno = new Juego(
                "Uno",
                1971,
                "Mattel",
                2,
                10,
                5,
                "CARTAS",
                false);

        JuegoVenta j1 = new JuegoVenta(
                catan,
                180000,
                5);

        JuegoVenta j2 = new JuegoVenta(
                uno,
                35000,
                8);

        invVenta.agregarJuegoVenta(j1);
        invVenta.agregarJuegoVenta(j2);

        CopiaJuego c1 = new CopiaJuego(1, catan, "Bueno");
        CopiaJuego c2 = new CopiaJuego(2, uno, "Nuevo");

        invPrestamo.agregarCopia(c1);
        invPrestamo.agregarCopia(c2);

        Torneo t1 = new Torneo(
                1,
                "Viernes",
                "Amistoso",
                12,
                catan,
                admin);

        torneos.add(t1);
        
        Turno turno1 = new Turno(
                "Lunes",
                LocalTime.of(8,0),
                LocalTime.of(16,0));

        Turno turno2 = new Turno(
                "Martes",
                LocalTime.of(10,0),
                LocalTime.of(18,0));
        
        
        //Mesero juan = new Mesero(
                //"Juan",
                //"002",
               // null,
                //"juan",
                //"123");

     
        SolicitudCambioTurno s1 =
                new SolicitudCambioTurno(
                        1,
                        admin,
                        turno1,
                        turno2,
                        "INTERCAMBIO");

        solicitudes.add(s1);
        
        
     // =========================
     // VENTA DEMO
     // =========================

        Venta ventaDemo = new Venta(
                1,
                LocalDate.now());

        ItemVenta item1 = new ItemVenta(
                j1,
                1,
                j1.getPrecio());

        ventaDemo.agregarItem(item1);

        ventas.add(ventaDemo);
        
        
        // =========================

        ConsolaAdministrador consola =
                new ConsolaAdministrador(
                        admin,
                        invVenta,
                        invPrestamo,
                        torneos,
                        solicitudes,
                        ventas);

        consola.iniciar();
    }
}