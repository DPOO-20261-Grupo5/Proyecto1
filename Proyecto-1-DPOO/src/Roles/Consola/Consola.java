package Consola;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import BoardGame.*;
import Roles.Cliente;
import Persistencias.*;

public class Consola {

    private static Scanner scanner = new Scanner(System.in);

    private static List<Cliente> clientes = PersistenciaClientes.cargarClientes();
    private static List<Venta> ventas = PersistenciaVentas.cargarVentas();

    private static InventarioPrestamo inventarioPrestamo = new InventarioPrestamo();
    private static InventarioVenta inventarioVenta = new InventarioVenta();

    private static Cliente clienteActual;
    private static Mesa mesaActual;

    private static Juego catan = new Juego("Catan", 1995, "Kosmos", 3, 4, 10, "Tablero", false);
    private static CopiaJuego copia1 = new CopiaJuego(1, catan, "bueno");
    private static CopiaJuego copia2 = new CopiaJuego(2, catan, "bueno");
    private static JuegoVenta juegoVenta = new JuegoVenta(catan, 5, 120000);

    public static void main(String[] args) {

        inventarioPrestamo.agregarCopia(copia1);
        inventarioPrestamo.agregarCopia(copia2);
        inventarioVenta.agregarJuegoVenta(juegoVenta);

        int opcion = 0;

        while (opcion != 8) {

            mostrarMenu();

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                if (opcion == 1) {
                    crearCliente();
                } 
                else if (opcion == 2) {
                    asignarMesa();
                } 
                else if (opcion == 3) {
                    prestarJuego();
                } 
                else if (opcion == 4) {
                    registrarVenta();
                } 
                else if (opcion == 5) {
                    devolverJuego();
                } 
                else if (opcion == 6) {
                    verReporteVentas();
                } 
                else if (opcion == 7) {
                    guardarDatos();
                } 
                else if (opcion == 8) {
                    System.out.println("Saliendo...");
                } 
                else {
                    System.out.println("Opción inválida.");
                }

            } catch (Exception e) {
                System.out.println("Error en la entrada.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== BOARD GAME CAFÉ ===");
        System.out.println("1. Crear cliente");
        System.out.println("2. Asignar mesa");
        System.out.println("3. Prestar juego");
        System.out.println("4. Registrar venta");
        System.out.println("5. Devolver juego");
        System.out.println("6. Ver reporte");
        System.out.println("7. Guardar datos");
        System.out.println("8. Salir");
        System.out.print("Seleccione: ");
    }

    private static void crearCliente() {
        System.out.print("Id: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        clienteActual = new Cliente(id, nombre, login, password);
        clientes.add(clienteActual);

        System.out.println("Cliente creado.");
    }

    private static void asignarMesa() {
        if (clienteActual == null) {
            System.out.println("Primero cree un cliente.");
            return;
        }

        System.out.print("Número mesa: ");
        int numero = Integer.parseInt(scanner.nextLine());

        System.out.print("Capacidad: ");
        int capacidad = Integer.parseInt(scanner.nextLine());

        System.out.print("Personas: ");
        int personas = Integer.parseInt(scanner.nextLine());

        System.out.print("¿Hay niños? true/false: ");
        boolean hayNinos = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("¿Hay menores? true/false: ");
        boolean hayMenores = Boolean.parseBoolean(scanner.nextLine());

        if (personas > capacidad) {
            System.out.println("Excede capacidad.");
            return;
        }

        mesaActual = new Mesa(numero, capacidad, personas, hayNinos, hayMenores);
        clienteActual.asignarMesa(mesaActual);

        System.out.println("Mesa asignada.");
    }

    private static void prestarJuego() {

        if (clienteActual == null || mesaActual == null) {
            System.out.println("Debe crear cliente y mesa.");
            return;
        }

        if (clienteActual.getPrestamos().size() >= 2) {
            System.out.println("Máximo 2 juegos.");
            return;
        }

        if (!inventarioPrestamo.hayDisponible(catan)) {
            System.out.println("No disponible.");
            return;
        }

        if (!mesaActual.puedeRecibirJuego(catan)) {
            System.out.println("No apto.");
            return;
        }

        CopiaJuego copia = inventarioPrestamo.buscarDisponibles(catan).get(0);

        Prestamo p = new Prestamo(1, new Date(), copia);
        copia.prestado();

        clienteActual.agregarPrestamo(p);
        mesaActual.agregarPrestamo(p);

        System.out.println("Préstamo realizado.");
    }

    private static void registrarVenta() {

        if (clienteActual == null || mesaActual == null) {
            System.out.println("Debe crear cliente y mesa.");
            return;
        }

        Venta venta = new Venta(ventas.size() + 1, new Date());

        Bebida cafe = new Bebida("Café", 5000, false, true);
        Pasteleria pastel = new Pasteleria("Torta", 8000);

        System.out.println("1. Café");
        System.out.println("2. Pastelería");
        System.out.println("3. Juego");

        int opcion = Integer.parseInt(scanner.nextLine());

        System.out.print("Cantidad: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        if (opcion == 1) {

            if (!mesaActual.puedeConsumirBebida(cafe)) {
                System.out.println("No permitido.");
                return;
            }

            venta.agregarItem(new ItemVenta(cafe, cantidad, cafe.getPrecio()));
        } 
        else if (opcion == 2) {
            venta.agregarItem(new ItemVenta(pastel, cantidad, pastel.getPrecio()));
        } 
        else if (opcion == 3) {

            if (!inventarioVenta.hayStock(catan.getNombre(), cantidad)) {
                System.out.println("Sin stock.");
                return;
            }

            venta.agregarItem(new ItemVenta(juegoVenta, cantidad, juegoVenta.getPrecio()));
            inventarioVenta.venderJuego(catan.getNombre(), cantidad);
        } 
        else {
            System.out.println("Opción inválida.");
            return;
        }

        clienteActual.agregarVenta(venta);
        ventas.add(venta);

        clienteActual.acumularPuntos(venta.calcularTotal());

        System.out.println("Total: " + venta.calcularTotal());
        System.out.println("Puntos: " + venta.calcularPuntos());
    }

    private static void devolverJuego() {

        if (clienteActual.getPrestamos().isEmpty()) {
            System.out.println("Sin préstamos.");
            return;
        }

        Prestamo p = clienteActual.getPrestamos().get(0);
        p.devolver(new Date());
        p.getCopiaJuego().devuelto();

        clienteActual.devolverPrestamo(p);

        System.out.println("Devuelto.");
    }

    private static void verReporteVentas() {

        ReporteVentas reporte = new ReporteVentas(
                java.time.LocalDate.now().minusDays(1),
                java.time.LocalDate.now(),
                ventas
        );

        System.out.println(reporte.mostrarReporte());
    }

    private static void guardarDatos() {
        PersistenciaClientes.guardarClientes(clientes);
        PersistenciaVentas.guardarVentas(ventas);
        System.out.println("Datos guardados.");
    }
}