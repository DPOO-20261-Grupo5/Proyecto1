package Persistencias;
	
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import BoardGame.Venta;

public class PersistenciaVentas {

    private static final String RUTA = "data/ventas.txt";

    // Guardar ventas
    public static void guardarVentas(List<Venta> ventas) {

        try {
            File carpeta = new File("data");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            FileWriter writer = new FileWriter(RUTA);

            for (Venta v : ventas) {
                writer.write(
                    v.getIdVenta() + "," +
                    v.getFecha().toString() + "," +
                    v.calcularTotal() + "\n"
                );
            }

            writer.close();
            System.out.println("Ventas guardadas correctamente");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cargar ventas
    public static List<Venta> cargarVentas() {

        List<Venta> ventas = new ArrayList<>();

        try {
            File archivo = new File(RUTA);

            if (!archivo.exists()) {
                return ventas;
            }

            BufferedReader reader = new BufferedReader(new FileReader(RUTA));
            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] partes = linea.split(",");

                int id = Integer.parseInt(partes[0]);
                LocalDate fecha = LocalDate.parse(partes[1]);

                Venta v = new Venta(id, fecha);

                ventas.add(v);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ventas;
    }
}