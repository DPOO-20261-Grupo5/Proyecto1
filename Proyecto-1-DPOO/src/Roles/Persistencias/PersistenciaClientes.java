package Persistencias;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Roles.Cliente;

public class PersistenciaClientes {
	private static final String RUTA = "data/clientes.txt";

	//Guardar los clientes
    public static void guardarClientes(List<Cliente> clientes) {

        try {
            File carpeta = new File("data");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            FileWriter writer = new FileWriter(RUTA);

            for (Cliente c : clientes) {
                writer.write(
                    c.getId() + "," +
                    c.getNombre() + "," +
                    c.getLogin() + "," +
                    c.getPassword() + "," +
                    c.getPuntosFidelidad() + "\n"
                );
            }

            writer.close();
            System.out.println("Clientes guardados correctamente");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Crgar los clientes
    public static List<Cliente> cargarClientes() {

        List<Cliente> clientes = new ArrayList<>();

        try {
            File archivo = new File(RUTA);

            if (!archivo.exists()) {
                return clientes; 
            }

            BufferedReader reader = new BufferedReader(new FileReader(RUTA));
            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] partes = linea.split(",");

                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String login = partes[2];
                String password = partes[3];
                int puntos = Integer.parseInt(partes[4]);

                Cliente c = new Cliente(id, nombre, login, password);

                
                c.acumularPuntos(puntos);

                clientes.add(c);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientes;
    }
}

