package Persistencias;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BoardGame.Juego;

public class PersistenciaJuegos {

    private static final String RUTA = "data/juegos.txt";

    // Guardar juegos
    public static void guardarJuegos(List<Juego> juegos) {

        try {
            File carpeta = new File("data");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            FileWriter writer = new FileWriter(RUTA);

            for (Juego j : juegos) {
                writer.write(
                    j.getNombre() + "," +
                    j.getAnioPublicacion() + "," +
                    j.getEmpresa() + "," +
                    j.getMinJugadores() + "," +
                    j.getMaxJugadores() + "," +
                    j.getEdadMinima() + "," +
                    j.getCategoria() + "," +
                    j.isEsDificil() + "\n"
                );
            }

            writer.close();
            System.out.println("Juegos guardados correctamente");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cargar juegos
    public static List<Juego> cargarJuegos() {

        List<Juego> juegos = new ArrayList<>();

        try {
            File archivo = new File(RUTA);

            if (!archivo.exists()) {
                return juegos;
            }

            BufferedReader reader = new BufferedReader(new FileReader(RUTA));
            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] partes = linea.split(",");

                String nombre = partes[0];
                int anioPublicacion = Integer.parseInt(partes[1]);
                String empresa = partes[2];
                int minJugadores = Integer.parseInt(partes[3]);
                int maxJugadores = Integer.parseInt(partes[4]);
                int edadMinima = Integer.parseInt(partes[5]);
                String categoria = partes[6];
                boolean esDificil = Boolean.parseBoolean(partes[7]);

                Juego j = new Juego( nombre, anioPublicacion, empresa, minJugadores, maxJugadores, edadMinima, categoria, esDificil);

                juegos.add(j);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return juegos;
    }
}
