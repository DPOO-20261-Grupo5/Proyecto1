package Consola;

import java.util.List;
import java.util.Scanner;

import Roles.Cliente;

import BoardGame.*;

public class ConsolaCliente {

    private Scanner scanner;
    private Cliente cliente;

    private InventarioPrestamo inventarioPrestamo;
    private InventarioVenta inventarioVenta;
    private List<Torneo> torneos;

    public ConsolaCliente(
            Cliente cliente,
            InventarioPrestamo inventarioPrestamo,
            InventarioVenta inventarioVenta,
            List<Torneo> torneos) {

        this.cliente = cliente;
        this.inventarioPrestamo = inventarioPrestamo;
        this.inventarioVenta = inventarioVenta;
        this.torneos = torneos;

        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {

        int opcion = -1;

        while(opcion != 0){

            mostrarMenu();

            try{

                opcion = Integer.parseInt(scanner.nextLine());

                switch(opcion){

                    case 1:
                        verCatalogo();
                        break;

                    case 2:
                        pedirPrestamo();
                        break;

                    case 3:
                        devolverJuego();
                        break;

                    case 4:
                        comprar();
                        break;

                    case 5:
                        favoritos();
                        break;

                    case 6:
                        verPuntos();
                        break;

                    case 7:
                        verTorneos();
                        break;

                    case 8:
                        inscribirseTorneo();
                        break;

                    case 9:
                        desinscribirseTorneo();
                        break;

                    case 0:
                        System.out.println("Hasta luego.");
                        break;
                }

            } catch(Exception e){

                System.out.println("Error.");
            }
        }
    }

    private void mostrarMenu(){

        System.out.println("\n===== CLIENTE =====");
        System.out.println("1. Ver catálogo");
        System.out.println("2. Pedir préstamo");
        System.out.println("3. Devolver juego");
        System.out.println("4. Comprar");
        System.out.println("5. Favoritos");
        System.out.println("6. Ver puntos");
        System.out.println("7. Ver torneos");
        System.out.println("8. Inscribirse torneo");
        System.out.println("9. Desinscribirse torneo");
        System.out.println("0. Salir");
    }

    private void verCatalogo(){

        System.out.println("\n--- CATALOGO ---");

        for(CopiaJuego c :
                inventarioPrestamo.getCopias()){

            System.out.println(c.informacion());
        }
    }

    private void pedirPrestamo(){

        System.out.println("\n--- PEDIR PRESTAMO ---");

        if(cliente.getPrestamos().size() >= 2){

            System.out.println(
                    "Maximo 2 prestamos.");
            return;
        }

        System.out.print("Juego: ");
        String nombre =
                scanner.nextLine();

        CopiaJuego disponible = null;

        for(CopiaJuego c :
                inventarioPrestamo.getCopias()){

            if(c.getJuego()
                    .getNombre()
                    .equalsIgnoreCase(nombre)
                    && c.isDisponible()){

                disponible = c;
                break;
            }
        }

        if(disponible == null){

            System.out.println(
                    "No disponible.");
            return;
        }

        Prestamo prestamo =
                new Prestamo(
                        cliente.getPrestamos().size()+1,
                        java.time.LocalDate.now(),
                        disponible);

        cliente.agregarPrestamo(
                prestamo);

        System.out.println(
                "Prestamo realizado.");
    }

    private void devolverJuego(){

        System.out.println(
                "\n--- DEVOLVER ---");

        if(cliente.getPrestamos().isEmpty()){

            System.out.println(
                    "No hay prestamos.");
            return;
        }

        for(Prestamo p :
                cliente.getPrestamos()){

            System.out.println(
                    p.informacion());
        }

        System.out.print(
                "ID prestamo: ");

        int id =
                Integer.parseInt(
                        scanner.nextLine());

        Prestamo devolver = null;

        for(Prestamo p :
                cliente.getPrestamos()){

            if(p.getIdPrestamo()==id){

                devolver = p;
            }
        }

        if(devolver != null){

            devolver.devolver(
                    java.time.LocalDate.now());

            cliente.devolverPrestamo(
                    devolver);

            System.out.println(
                    "Devuelto.");
        }

        else{

            System.out.println(
                    "No encontrado.");
        }
    }

    private void comprar(){

        System.out.println("\n--- COMPRA ---");

        System.out.println("1. Juego");
        System.out.println("2. Bebida");
        System.out.println("3. Pasteleria");

        int opcion =
                Integer.parseInt(
                        scanner.nextLine());

        Venta venta =
                new Venta(
                        cliente.getVentas().size()+1,
                        java.time.LocalDate.now());

        Producto producto = null;

        // =========================
        // JUEGOS
        // =========================

        if(opcion == 1){

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

            producto = juego;
        }

        // =========================
        // BEBIDAS
        // =========================

        else if(opcion == 2){

            System.out.println(
                    "\n--- BEBIDAS ---");

            System.out.println(
                    "1. Café Latte - 12000");

            System.out.println(
                    "2. Chocolate caliente - 10000");

            System.out.println(
                    "3. Cerveza artesanal - 15000");

            int bebida =
                    Integer.parseInt(
                            scanner.nextLine());

            switch(bebida){

                case 1:

                    producto =
                            new Bebida(
                                    "Café Latte",
                                    12000,
                                    false,
                                    true);
                    break;

                case 2:

                    producto =
                            new Bebida(
                                    "Chocolate caliente",
                                    10000,
                                    false,
                                    true);
                    break;

                case 3:

                    producto =
                            new Bebida(
                                    "Cerveza artesanal",
                                    15000,
                                    true,
                                    false);
                    break;
            }
        }

        // =========================
        // PASTELERIA
        // =========================

        else if(opcion == 3){

            System.out.println(
                    "\n--- PASTELERIA ---");

            System.out.println(
                    "1. Cheesecake - 14000");

            System.out.println(
                    "2. Brownie - 9000");

            System.out.println(
                    "3. Croissant - 8000");

            int pastel =
                    Integer.parseInt(
                            scanner.nextLine());

            switch(pastel){

                case 1:

                    producto =
                            new Pasteleria(
                                    "Cheesecake",
                                    14000);
                    break;

                case 2:

                    producto =
                            new Pasteleria(
                                    "Brownie",
                                    9000);
                    break;

                case 3:

                    producto =
                            new Pasteleria(
                                    "Croissant",
                                    8000);
                    break;
            }
        }

        if(producto == null){

            System.out.println(
                    "Opcion invalida.");
            return;
        }

        System.out.print(
                "Cantidad: ");

        int cantidad =
                Integer.parseInt(
                        scanner.nextLine());

        ItemVenta item =
                new ItemVenta(
                        producto,
                        cantidad,
                        producto.getPrecio());

        venta.agregarItem(item);

        // si es juego -> bajar stock

        if(producto instanceof JuegoVenta){

            ((JuegoVenta) producto)
                    .reducirStock(cantidad);
        }

        cliente.agregarVenta(venta);

        cliente.acumularPuntos(
                venta.calcularTotal());

        System.out.println(
                "\n--- RESUMEN ---");

        System.out.println(
                "Subtotal: "
                + venta.calcularSubtotal());

        System.out.println(
                "Impuestos: "
                + venta.calcularImpuestos());

        System.out.println(
                "Total: "
                + venta.calcularTotal());

        System.out.println(
                "Puntos ganados: "
                + venta.calcularPuntos());

        System.out.println(
                "Compra realizada.");
    }
    private void favoritos() {

        System.out.println("\n--- FAVORITOS ---");

        System.out.println("1. Ver favoritos");
        System.out.println("2. Agregar favorito");

        int op =
                Integer.parseInt(scanner.nextLine());

        switch(op){

            case 1:

                for(Juego j :
                        cliente.getJuegosFavoritos()){

                    System.out.println(
                            j.informacion());
                }

                break;

            case 2:

                System.out.print("Juego: ");
                String nombre =
                        scanner.nextLine();

                Juego juego =
                        buscarJuego(nombre);

                if(juego != null){

                    cliente.agregarJuegoFavorito(
                            juego);

                    System.out.println(
                            "Agregado.");
                }

                else{

                    System.out.println(
                            "No existe.");
                }
        }
    }
    
    private Juego buscarJuego(String nombre){

        for(CopiaJuego c :
                inventarioPrestamo.getCopias()){

            if(c.getJuego()
                    .getNombre()
                    .equalsIgnoreCase(nombre)){

                return c.getJuego();
            }
        }

        return null;
    }

    private void verPuntos(){

        System.out.println(
                "\nPuntos fidelidad: "
                + cliente.getPuntosFidelidad());
    }
    private void verTorneos(){

        System.out.println(
                "\n--- TORNEOS ---");

        for(Torneo t : torneos){

            System.out.println(

                "ID: "
                + t.getId()

                + " | Tipo: "
                + t.getTipo()

                + " | Juego: "
                + t.getJuego().getNombre()

                + " | Fecha: "
                + t.getFecha()

                + " | Cupos: "
                + t.getTotalCuposOcupados()
            );
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

        Torneo torneo = null;

        for(Torneo t : torneos){

            if(t.getId()==id){

                torneo = t;
            }
        }

        if(torneo == null){

            System.out.println(
                    "No existe.");
            return;
        }

        System.out.print(
                "Cupos (1-3): ");

        int cupos =
                Integer.parseInt(
                        scanner.nextLine());

        try{

            torneo.inscribir(
                    cliente,
                    cupos);

            System.out.println(
                    "Inscrito correctamente.");

        }

        catch(Exception e){

            System.out.println(
                    e.getMessage());
        }
    }

    private void desinscribirseTorneo(){

        System.out.println(
                "\n--- DESINSCRIPCION ---");

        verTorneos();

        System.out.print(
                "ID torneo: ");

        int id =
                Integer.parseInt(
                        scanner.nextLine());

        Torneo torneo = null;

        for(Torneo t : torneos){

            if(t.getId()==id){

                torneo = t;
            }
        }

        if(torneo == null){

            System.out.println(
                    "No existe.");
            return;
        }

        torneo.desinscribir(
                cliente);

        System.out.println(
                "Desinscrito.");
    }
}
