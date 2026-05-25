package Consola;

import java.util.ArrayList;
import java.util.List;

import Roles.Cliente;

import BoardGame.*;

public class ConsolaClienteMain {

    public static void main(String[] args) {

        // CLIENTE DEMO
        Cliente cliente =
                new Cliente(
                        100,
                        "Laura",
                        "laura",
                        "123");

        // INVENTARIOS
        InventarioVenta invVenta =
                new InventarioVenta();

        InventarioPrestamo invPrestamo =
                new InventarioPrestamo();

        List<Torneo> torneos =
                new ArrayList<>();

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

        JuegoVenta j1 =
                new JuegoVenta(
                        catan,
                        180000,
                        5);

        invVenta.agregarJuegoVenta(j1);

        // copia demo
        CopiaJuego c1 =
                new CopiaJuego(
                        1,
                        catan,
                        "Bueno");

        CopiaJuego c2 =
                new CopiaJuego(
                        2,
                        uno,
                        "Nuevo");

        invPrestamo.agregarCopia(c1);
        invPrestamo.agregarCopia(c2);

        // torneo demo
        Torneo torneo1 =
                new Torneo(
                        1,
                        "Viernes",
                        "Amistoso",
                        12,
                        catan,
                        null);

        torneos.add(torneo1);

        // =========================

        ConsolaCliente consola =
                new ConsolaCliente(
                        cliente,
                        invPrestamo,
                        invVenta,
                        torneos);

        consola.iniciar();
    }
}