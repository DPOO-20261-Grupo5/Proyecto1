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

    public static void main(String[] args) {

        // Inicializar datos
        inventarioPrestamo.agregarCopia(new CopiaJuego(1, catan, "bueno"));
        inventarioVenta.agregarJuegoVenta(new JuegoVenta(catan, 5, 120000));

        int opcion = 0;

        while (opcion != 4) {

            System.out.println("\n=== BOARD GAME CAFÉ ===");
            System.out.println("1. Cliente");
            System.out.println("2. Empleado");
            System.out.println("3. Administrador");
            System.out.println("4. Salir");

            opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 1) menuCliente();
            else if (opcion == 2) menuEmpleado();
            else if (opcion == 3) menuAdministrador();
        }
    }

    // ================= CLIENTE =================
    private static void menuCliente() {

        int op = 0;

        while (op != 6) {

            System.out.println("\n=== CLIENTE ===");
            System.out.println("1. Crear cliente");
            System.out.println("2. Asignar mesa");
            System.out.println("3. Prestar juego");
            System.out.println("4. Comprar");
            System.out.println("5. Devolver juego");
            System.out.println("6. Volver");

            op = Integer.parseInt(scanner.nextLine());

            if (op == 1) {
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                clienteActual = new Cliente(1, nombre, "login", "123");
                clientes.add(clienteActual);
                System.out.println("Cliente creado.");
            }

            else if (op == 2) {
                mesaActual = new Mesa(1, 4, 3, false, true);
                clienteActual.asignarMesa(mesaActual);
                System.out.println("Mesa asignada.");
            }

            else if (op == 3) {

                if (clienteActual.getPrestamos().size() < 2 &&
                    inventarioPrestamo.hayDisponible(catan) &&
                    mesaActual.puedeRecibirJuego(catan)) {

                    CopiaJuego copia = inventarioPrestamo.buscarDisponibles(catan).get(0);
                    Prestamo p = new Prestamo(1, new Date(), copia);

                    copia.prestado();
                    clienteActual.agregarPrestamo(p);
                    mesaActual.agregarPrestamo(p);

                    System.out.println("Juego prestado.");
                } else {
                    System.out.println("No se puede prestar.");
                }
            }

            else if (op == 4) {

                Venta venta = new Venta(ventas.size() + 1, new Date());
                Bebida cafe = new Bebida("Café", 5000, false, true);

                if (mesaActual.puedeConsumirBebida(cafe)) {
                    venta.agregarItem(new ItemVenta(cafe, 1, cafe.getPrecio()));
                    ventas.add(venta);
                    clienteActual.acumularPuntos(venta.calcularTotal());

                    System.out.println("Total: " + venta.calcularTotal());
                } else {
                    System.out.println("No permitido.");
                }
            }

            else if (op == 5) {
                if (!clienteActual.getPrestamos().isEmpty()) {
                    Prestamo p = clienteActual.getPrestamos().get(0);
                    p.devolver(new Date());
                    p.getCopiaJuego().devuelto();
                    clienteActual.devolverPrestamo(p);
                    System.out.println("Devuelto.");
                }
            }
        }
    }

    // ================= EMPLEADO =================
    private static void menuEmpleado() {

        int op = 0;

        while (op != 4) {

            System.out.println("\n=== EMPLEADO ===");
            System.out.println("1. Ver turno");
            System.out.println("2. Solicitar cambio");
            System.out.println("3. Pedir juego");
            System.out.println("4. Volver");

            op = Integer.parseInt(scanner.nextLine());

            if (op == 1) {
                System.out.println("Turno: Lunes 8am-5pm");
            }

            else if (op == 2) {
                System.out.println("Solicitud enviada.");
            }

            else if (op == 3) {
                if (inventarioPrestamo.hayDisponible(catan)) {
                    CopiaJuego copia = inventarioPrestamo.buscarDisponibles(catan).get(0);
                    copia.prestado();
                    System.out.println("Juego prestado al empleado.");
                }
            }
        }
    }

    // ================= ADMIN =================
    private static void menuAdministrador() {

        int op = 0;

        while (op != 5) {

            System.out.println("\n=== ADMINISTRADOR ===");
            System.out.println("1. Ver ventas");
            System.out.println("2. Ver reporte");
            System.out.println("3. Marcar juego perdido");
            System.out.println("4. Guardar datos");
            System.out.println("5. Volver");

            op = Integer.parseInt(scanner.nextLine());

            if (op == 1) {
                for (Venta v : ventas) {
                    System.out.println(v.informacion());
                }
            }

            else if (op == 2) {
                ReporteVentas r = new ReporteVentas(
                        java.time.LocalDate.now().minusDays(1),
                        java.time.LocalDate.now(),
                        ventas
                );
                System.out.println(r.mostrarReporte());
            }

            else if (op == 3) {
                System.out.println("Juego marcado como perdido.");
            }

            else if (op == 4) {
                PersistenciaClientes.guardarClientes(clientes);
                PersistenciaVentas.guardarVentas(ventas);
                System.out.println("Datos guardados.");
            }
        }
    }
}