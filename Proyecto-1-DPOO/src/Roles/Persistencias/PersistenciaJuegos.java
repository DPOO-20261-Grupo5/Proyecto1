package Persistencias;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import BoardGame.CopiaJuego;
import BoardGame.Juego;
import BoardGame.JuegoVenta;

public class PersistenciaJuegos {

    private static final String RUTA_PRESTAMO = "data/juegos_prestamo.txt";
    private static final String RUTA_VENTA = "data/juegos_venta.txt";

    
    public static void guardarJuegosPrestamo(List<CopiaJuego> copias) {

        try {
            File carpeta = new File("data");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            FileWriter writer = new FileWriter(RUTA_PRESTAMO);

            for (CopiaJuego c : copias) {
                writer.write(
                    c.getJuego().getNombre() + "," +
                    c.getEstado() + "," +
                    c.isDisponible() + "\n"
                );
            }

            writer.close();
            System.out.println("Juegos de préstamo guardados");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<CopiaJuego> cargarJuegosPrestamo() {

        List<CopiaJuego> copias = new ArrayList<>();

        try {
            File archivo = new File(RUTA_PRESTAMO);

            if (!archivo.exists()) {
                return copias;
            }

            BufferedReader reader = new BufferedReader(new FileReader(RUTA_PRESTAMO));
            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] partes = linea.split(",");

                int id = Integer.parseInt(partes[0]);
                String nombreJuego = partes[1];
                String estado = partes[2];
                boolean disponible = Boolean.parseBoolean(partes[3]);

                
                Juego juego = new Juego(nombreJuego, 0, "N/A", 1, 10, 0, "N/A", false);

                CopiaJuego copia = new CopiaJuego(id, juego, estado);

                if (!disponible) {
                    copia.prestado();
                }

                copias.add(copia);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return copias;
    }

    // =========================
    // JUEGOS DE VENTA
    // =========================
    public static void guardarJuegosVenta(List<JuegoVenta> juegos) {

        try {
            File carpeta = new File("data");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            FileWriter writer = new FileWriter(RUTA_VENTA);

            for (JuegoVenta j : juegos) {
                writer.write(
                    j.getJuego().getNombre() + "," +
                    j.getPrecio() + "," +
                    j.getStockDisponible() + "\n"
                );
            }

            writer.close();
            System.out.println("Juegos de venta guardados");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<JuegoVenta> cargarJuegosVenta() {

        List<JuegoVenta> juegos = new ArrayList<>();

        try {
            File archivo = new File(RUTA_VENTA);

            if (!archivo.exists()) {
                return juegos;
            }

            BufferedReader reader = new BufferedReader(new FileReader(RUTA_VENTA));
            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] partes = linea.split(",");

                String nombre = partes[0];
                double precio = Double.parseDouble(partes[1]);
                int stock = Integer.parseInt(partes[2]);

                Juego juego = new Juego(nombre, 0, "N/A", 1, 10, 0, "N/A", false);

                JuegoVenta jv = new JuegoVenta(juego, precio, stock);
                jv.setPrecio(precio);

                juegos.add(jv);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return juegos;
    }
}
