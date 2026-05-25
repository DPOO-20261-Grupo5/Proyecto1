package Consola;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import Roles.Mesero;
import BoardGame.*;

public class ConsolaEmpleadoMain {

    public static void main(String[] args) {

        Turno turno =
                new Turno(
                        "Lunes",
                        LocalTime.of(8,0),
                        LocalTime.of(16,0));

        Mesero juan =
                new Mesero(
                        "Juan",
                        "001",
                        turno,
                        "juan",
                        "123");

        InventarioVenta invVenta =
                new InventarioVenta();

        InventarioPrestamo invPrestamo =
                new InventarioPrestamo();

        List<Torneo> torneos =
                new ArrayList<>();

        Juego catan =
                new Juego(
                        "Catan",
                        1995,
                        "Kosmos",
                        3,
                        4,
                        10,
                        "TABLERO",
                        false);

        JuegoVenta j1 =
                new JuegoVenta(
                        catan,
                        180000,
                        5);

        invVenta.agregarJuegoVenta(j1);

        CopiaJuego c1 =
                new CopiaJuego(
                        1,
                        catan,
                        "Bueno");

        invPrestamo.agregarCopia(c1);

        Torneo t1 =
                new Torneo(
                        1,
                        "Viernes",
                        "COMPETITIVO",
                        12,
                        catan,
                        null);

        torneos.add(t1);
        
        List<SolicitudCambioTurno> solicitudes =
                new ArrayList<>();
        
        ConsolaEmpleado consola =
                new ConsolaEmpleado(
                        juan,
                        invPrestamo,
                        invVenta,
                        torneos,
                        solicitudes);

        consola.iniciar();
    }
}
