package Consola;

import java.util.List;
import java.util.Scanner;

import Roles.Administrador;
//import Roles.Empleado;
//import Roles.Cliente;

import BoardGame.Torneo;
import BoardGame.Venta;
import BoardGame.Juego;
import BoardGame.JuegoVenta;
import BoardGame.CopiaJuego;
import BoardGame.InventarioVenta;
import BoardGame.InventarioPrestamo;
import BoardGame.ReporteVentas;
import BoardGame.SolicitudCambioTurno;

public class ConsolaAdministrador {

    private Scanner scanner;
    private Administrador admin;

    private InventarioVenta inventarioVenta;
    private InventarioPrestamo inventarioPrestamo;
    private List<Torneo> torneos;
    private List<SolicitudCambioTurno> solicitudes;
    private List<Venta> ventas;

    public ConsolaAdministrador(
            Administrador admin,
            InventarioVenta inventarioVenta,
            InventarioPrestamo inventarioPrestamo,
            List<Torneo> torneos,
            List<SolicitudCambioTurno> solicitudes,
            List<Venta> ventas) {

        this.admin = admin;
        this.inventarioVenta = inventarioVenta;
        this.inventarioPrestamo = inventarioPrestamo;
        this.torneos = torneos;
        this.solicitudes = solicitudes;
        this.ventas = ventas;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {

        int opcion = -1;

        while (opcion != 0) {

            mostrarMenu();

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {

                    case 1:
                        gestionarTorneos();
                        break;

                    case 2:
                        gestionarInventarioVenta();
                        break;

                    case 3:
                        gestionarInventarioPrestamo();
                        break;

                    case 4:
                        gestionarMenuCafe();
                        break;

                    case 5:
                        gestionarTurnos();
                        break;

                    case 6:
                        revisarSolicitudes();
                        break;

                    case 7:
                        generarReporte();
                        break;

                    case 8:
                        repararOMoverJuego();
                        break;

                    case 9:
                        verHistorialPrestamos();
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void mostrarMenu() {

        System.out.println("\n===== ADMINISTRADOR =====");
        System.out.println("1. Gestionar torneos");
        System.out.println("2. Inventario venta");
        System.out.println("3. Inventario préstamos");
        System.out.println("4. Menú café");
        System.out.println("5. Gestionar turnos");
        System.out.println("6. Revisar solicitudes");
        System.out.println("7. Generar reportes");
        System.out.println("8. Reparar / mover juego");
        System.out.println("9. Historial préstamos");
        System.out.println("0. Salir");
        System.out.print("Seleccione: ");
    }

    // =========================
    // TORNEOS
    // =========================

    private void gestionarTorneos() {

        System.out.println("\n--- TORNEOS ---");
        System.out.println("1. Crear torneo");
        System.out.println("2. Ver torneos");
        System.out.println("3. Eliminar torneo");

        int op = Integer.parseInt(scanner.nextLine());

        switch(op){

            case 1:
                crearTorneo();
                break;

            case 2:
                verTorneos();
                break;

            case 3:
                eliminarTorneo();
                break;
        }
    }

    private void crearTorneo() {

        try {

            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Fecha: ");
            String fecha = scanner.nextLine();

            System.out.print("Tipo: ");
            String tipo = scanner.nextLine();

            System.out.print("Capacidad: ");
            int capacidad = Integer.parseInt(scanner.nextLine());

            System.out.print("Nombre juego: ");
            String nombreJuego = scanner.nextLine();

            Juego juego = buscarJuego(nombreJuego);

            if(juego == null){

                System.out.println("Juego no existe.");
                return;
            }

            Torneo torneo = new Torneo(
                    id,
                    fecha,
                    tipo,
                    capacidad,
                    juego,
                    admin);

            torneos.add(torneo);

            System.out.println("Torneo creado.");

        } catch (Exception e) {
            System.out.println("No se pudo crear.");
        }
    }
    
    private void eliminarTorneo() {

        verTorneos();

        System.out.print("ID torneo a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Torneo eliminar = null;

        for(Torneo t : torneos){

            if(t.getId() == id){
                eliminar = t;
            }
        }

        if(eliminar != null){

            System.out.print("Confirmar (S/N): ");
            String conf = scanner.nextLine();

            if(conf.equalsIgnoreCase("S")){

                torneos.remove(eliminar);
                System.out.println("Torneo eliminado.");
            }

            else{
                System.out.println("Cancelado.");
            }
        }

        else{
            System.out.println("No encontrado.");
        }
    }

    private void verTorneos() {

        for (Torneo t : torneos) {
            System.out.println(t.getId() + " - " + t.getTipo());
        }
    }

    // =========================
    // INVENTARIO VENTA
    // =========================

    private void gestionarInventarioVenta() {

        System.out.println("\n--- INVENTARIO VENTA ---");
        System.out.println("1. Agregar juego");
        System.out.println("2. Ver juegos");

        int op = Integer.parseInt(scanner.nextLine());

        switch(op){

            case 1:
                agregarJuegoVenta();
                break;

            case 2:
            	for(JuegoVenta j : inventarioVenta.getJuegosVenta()) {

            	    System.out.println(j.informacion());
            	}
                break;
        }
    }

    private void agregarJuegoVenta() {

        System.out.print("Nombre juego: ");
        String nombre = scanner.nextLine();

        JuegoVenta j = inventarioVenta.buscarJuego(nombre);

        if(j != null){
            j.aumentarStock(1);
            System.out.println("Stock aumentado");
        }
    }

    // =========================
    // INVENTARIO PRESTAMO
    // =========================

    private void gestionarInventarioPrestamo() {

        System.out.println("\n--- PRESTAMOS ---");
        System.out.println("1. Ver copias");
        System.out.println("2. Marcar robado");

        int op = Integer.parseInt(scanner.nextLine());

        switch(op){

            case 1:
            	for(CopiaJuego c : inventarioPrestamo.getCopias()) {

            	    System.out.println(c.informacion());
            	}
                break;

            case 2:
                marcarRobado();
                break;
        }
    }

    private void marcarRobado() {

        System.out.print("ID copia: ");
        int id = Integer.parseInt(scanner.nextLine());

        for(CopiaJuego c : inventarioPrestamo.getCopias()){

            if(c.getIdCopia() == id){

                c.setEstado("Desaparecido");
                System.out.println("Marcado.");
            }
        }
    }

    // =========================
    // MENU
    // =========================

    private void gestionarMenuCafe() {

        System.out.println("\n--- MENU CAFÉ ---");

        System.out.println("Bebidas:");
        System.out.println("- Café Latte");
        System.out.println("- Chocolate caliente");
        System.out.println("- Cerveza artesanal");

        System.out.println("\nPastelería:");
        System.out.println("- Cheesecake");
        System.out.println("- Brownie");
        System.out.println("- Croissant");
    }

    // =========================
    // TURNOS
    // =========================

    private void gestionarTurnos() {

        System.out.println("\n--- TURNOS ---");

        for(SolicitudCambioTurno s : solicitudes){

            System.out.println(
                s.getSolicitante().getNombre()
                + " -> "
                + s.getTurnoActual().mostrarTurno());
        }
    }

    // =========================
    // SOLICITUDES
    // =========================

    private void revisarSolicitudes() {

        for(SolicitudCambioTurno s : solicitudes){

            System.out.println(s.mostrarSolicitud());
        }
    }

    // =========================
    // REPORTES
    // =========================

    private void generarReporte() {

        ReporteVentas reporte = admin.generarReporte(ventas);

        System.out.println("\n=== REPORTE ===");
        System.out.println("Comida: " + reporte.getVentasComida());
        System.out.println("Juegos: " + reporte.getVentasJuegos());
        System.out.println("Impuestos: " + reporte.getImpuestosTotales());
        System.out.println("Propinas: " + reporte.getPropinasTotales());
    }

    // =========================
    // REPARAR
    // =========================

    private void repararOMoverJuego() {

        System.out.println("\n--- REPARAR / MOVER ---");

        System.out.println("1. Reparar copia dañada");
        System.out.println("2. Mover juego venta -> préstamo");

        System.out.println("Demo realizada.");
    }
    // =========================
    // HISTORIAL
    // =========================

    private void verHistorialPrestamos() {

        for(CopiaJuego c : inventarioPrestamo.getCopias()){

            System.out.println(c.informacion());
        }
    }

    private Juego buscarJuego(String nombre){

        for(JuegoVenta j : inventarioVenta.getJuegosVenta()){

            if(j.getJuego().getNombre().equalsIgnoreCase(nombre)){

                return j.getJuego();
            }
        }

        return null;
    }
    
    
    //private void buscarJuegoVenta() {

        //System.out.print("Nombre: ");
        //String nombre = scanner.nextLine();

        //JuegoVenta j = inventarioVenta.buscarJuego(nombre);

        //if(j != null){

           // System.out.println(j.informacion());
       // }

       // else{

           // System.out.println("No existe.");
        //}
    //} 
    
}
