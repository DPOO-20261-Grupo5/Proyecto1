package Consola;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Roles.Empleado;
import BoardGame.*;

public class ConsolaEmpleado {

    private Scanner scanner;
    private Empleado empleado;

    private InventarioPrestamo inventarioPrestamo;
    private InventarioVenta inventarioVenta;
    private List<Torneo> torneos;
    private List<SolicitudCambioTurno> solicitudes;
    private List<Prestamo> prestamosEmpleado;

    public ConsolaEmpleado(
            Empleado empleado,
            InventarioPrestamo inventarioPrestamo,
            InventarioVenta inventarioVenta,
            List<Torneo> torneos,
            List<SolicitudCambioTurno> solicitudes) {

        this.empleado = empleado;
        this.inventarioPrestamo = inventarioPrestamo;
        this.inventarioVenta = inventarioVenta;
        this.torneos = torneos;
        this.scanner = new Scanner(System.in);
        this.solicitudes = solicitudes;
        this.prestamosEmpleado = new ArrayList<>();
    }

    public void iniciar() {

        int opcion = -1;

        while(opcion != 0){

            mostrarMenu();

            opcion =
                    Integer.parseInt(
                            scanner.nextLine());

            switch(opcion){

                case 1:
                    verTurno();
                    break;

                case 2:
                    solicitarCambio();
                    break;

                case 3:
                    pedirPrestamo();
                    break;

                case 4:
                    devolverPrestamo();
                    break;

                case 5:
                    comprar();
                    break;

                case 6:
                    verTorneos();
                    break;

                case 7:
                    inscribirseTorneo();
                    break;

                case 8:
                    sugerirPlatillo();
                    break;

                case 0:
                    System.out.println(
                            "Hasta luego.");
                    break;
            }
        }
    }

    private void mostrarMenu(){

        System.out.println(
                "\n===== EMPLEADO =====");

        System.out.println(
                "1. Ver turno");

        System.out.println(
                "2. Solicitar cambio");

        System.out.println(
                "3. Pedir préstamo");

        System.out.println(
                "4. Devolver préstamo");

        System.out.println(
                "5. Comprar");

        System.out.println(
                "6. Ver torneos");

        System.out.println(
                "7. Inscribirse torneo");

        System.out.println(
                "8. Sugerir platillo");

        System.out.println(
                "0. Salir");
    }

    // TURNO

    private void verTurno(){

        System.out.println(
                "\nTurno: "
                + empleado.getTurno()
                .mostrarTurno());
    }

    private void solicitarCambio(){

        System.out.println(
                "\n--- CAMBIO TURNO ---");

        System.out.print(
                "Nuevo dia: ");

        String dia =
                scanner.nextLine();

        Turno nuevo =
                new Turno(
                        dia,
                        empleado.getTurno()
                                .getHoraInicio(),
                        empleado.getTurno()
                                .getHoraFin());

        SolicitudCambioTurno s =
                new SolicitudCambioTurno(
                        solicitudes.size()+1,
                        empleado,
                        empleado.getTurno(),
                        nuevo,
                        "CAMBIO");

        solicitudes.add(s);

        System.out.println(
                "Solicitud enviada.");
    }

    // PRESTAMO

    private void pedirPrestamo(){
    	
    	if(empleado.getTurno() != null){

    	    System.out.println(
    	            "No puede pedir juegos estando en turno.");

    	    return;
    	}

        System.out.println(
                "\n--- PRESTAMO ---");

        System.out.print(
                "Juego: ");

        String nombre =
                scanner.nextLine();

        CopiaJuego copia = null;

        for(CopiaJuego c :
                inventarioPrestamo.getCopias()){

            if(c.getJuego()
                    .getNombre()
                    .equalsIgnoreCase(nombre)
                    && c.isDisponible()){

                copia = c;
                break;
            }
        }

        if(copia == null){

            System.out.println(
                    "No disponible");
            return;
        }

        Prestamo p =
                new Prestamo(
                        1,
                        LocalDate.now(),
                        copia);
        prestamosEmpleado.add(p);

        System.out.println(
                "Prestamo realizado.");
    }

    private void devolverPrestamo(){

        System.out.println(
                "\n--- DEVOLVER ---");

        if(prestamosEmpleado.isEmpty()){

            System.out.println(
                    "No hay prestamos.");
            return;
        }

        for(Prestamo p :
                prestamosEmpleado){

            System.out.println(
                    p.informacion());
        }

        System.out.print(
                "ID: ");

        int id =
                Integer.parseInt(
                        scanner.nextLine());

        Prestamo devolver =
                null;

        for(Prestamo p :
                prestamosEmpleado){

            if(p.getIdPrestamo()==id){

                devolver = p;
            }
        }

        if(devolver != null){

            devolver.devolver(
                    java.time.LocalDate.now());

            prestamosEmpleado.remove(
                    devolver);

            System.out.println(
                    "Devuelto.");
        }

        else{

            System.out.println(
                    "No encontrado.");
        }
    }
    // COMPRA

    private void comprar(){

        System.out.println(
                "\n--- COMPRA ---");

        for(JuegoVenta j :
                inventarioVenta.getJuegosVenta()){

            System.out.println(
                    j.informacion());
        }

        System.out.print(
                "Juego: ");

        String nombre =
                scanner.nextLine();

        JuegoVenta juego =
                inventarioVenta.buscarJuego(
                        nombre);

        if(juego == null){

            System.out.println(
                    "No existe.");
            return;
        }

        System.out.print(
                "Cantidad: ");

        int cantidad =
                Integer.parseInt(
                        scanner.nextLine());

        if(juego.getStockDisponible()
                < cantidad){

            System.out.println(
                    "No stock.");
            return;
        }

        Venta venta =
                new Venta(
                        1,
                        java.time.LocalDate.now());

        ItemVenta item =
                new ItemVenta(
                        juego,
                        cantidad,
                        juego.getPrecio());

        venta.agregarItem(item);

        juego.reducirStock(
                cantidad);

        double subtotal =
                venta.calcularSubtotal();

        double iva =
                venta.calcularImpuestos();

        double total =
                venta.calcularTotal();

        double descuento =
                total * 0.20;

        double totalFinal =
                total - descuento;

        System.out.println(
                "\n--- RESUMEN ---");

        System.out.println(
                "Subtotal: "
                + subtotal);

        System.out.println(
                "IVA: "
                + iva);

        System.out.println(
                "Descuento empleado (20%): "
                + descuento);

        System.out.println(
                "Total final: "
                + totalFinal);

        System.out.println(
                "Compra realizada.");
    }
    

    // TORNEOS

    private void verTorneos(){

        for(Torneo t : torneos){

            System.out.println(

                    "ID: "
                    + t.getId()

                    + " | "
                    + t.getTipo()

                    + " | "
                    + t.getFecha());
        }
    }

    private void inscribirseTorneo(){

        System.out.println(
                "\n--- INSCRIPCION ---");

        verTorneos();

        System.out.print(
                "ID torneo: ");

        int id =
                Integer.parseInt(
                        scanner.nextLine());

        for(Torneo t : torneos){

            if(t.getId()==id){

                try{

                    t.inscribir(
                            empleado,
                            1);

                    System.out.println(
                            "Inscrito.");

                }

                catch(Exception e){

                    System.out.println(
                            e.getMessage());
                }
            }
        }
    }

    private void sugerirPlatillo(){

        System.out.println(
                "\nSugerencia demo enviada.");
    }
}
