package BoardGame;

import java.util.ArrayList;
import java.util.List;

public class InventarioVenta {

    // Atributos
    private List<JuegoVenta> juegosVenta;

    // Constructor
    public InventarioVenta() {
        this.juegosVenta = new ArrayList<>();
    }

    // Métodos

    public void agregarJuegoVenta(JuegoVenta juegoVenta) {
        juegosVenta.add(juegoVenta);
    }

    public List<JuegoVenta> getJuegosVenta() {
        return this.juegosVenta;
    }

   
    public JuegoVenta buscarJuego(String nombre) {
        for (JuegoVenta jv : juegosVenta) {
            if (jv.getJuego().getNombre().equalsIgnoreCase(nombre)) {
                return jv;
            }
        }
        return null;
    }

    
    public boolean hayStock(String nombre, int cantidad) {
        JuegoVenta jv = buscarJuego(nombre);
        if (jv != null) {
            return jv.getStockDisponible() >= cantidad;
        }
        return false;
    }

    
    public void venderJuego(String nombre, int cantidad) {
        JuegoVenta jv = buscarJuego(nombre);

        if (hayStock(nombre, cantidad)) {
            jv.reducirStock(cantidad);
        } else {
            System.out.println("No hay stock suficiente");
        }
    }
}
