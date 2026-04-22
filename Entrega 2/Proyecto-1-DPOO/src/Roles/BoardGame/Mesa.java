package BoardGame;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

    private int numeroMesa;
    private int capacidad;
    private int numeroPersonas;
    private boolean hayNinos;
    private boolean hayMenores;
    private List<Prestamo> prestamos;
    private List<Producto> productos;

    // Constructor
    public Mesa(int numeroMesa, int capacidad, int numeroPersonas, boolean hayNinos, boolean hayMenores) {
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
        this.numeroPersonas = numeroPersonas;
        this.hayNinos = hayNinos;
        this.hayMenores = hayMenores;
        this.prestamos = new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    
    public boolean puedeRecibirJuego(Juego juego) {
        if (numeroPersonas < juego.getMinJugadores() || numeroPersonas > juego.getMaxJugadores()) {
            return false;
        }

        if (hayNinos && juego.getEdadMinima() > 5) {
            return false;
        }

        if (hayMenores && juego.getEdadMinima() >= 18) {
            return false;
        }

        return true;
    }

   
    public void agregarPrestamo(Prestamo prestamo) {
        if (prestamos.size() < 2) {
            prestamos.add(prestamo);
        } else {
            System.out.println("Máximo 2 juegos por mesa");
        }
    }

   
    public boolean puedeConsumirBebida(Bebida bebida) {

        if (bebida.isAlcoholica() && hayMenores) {
            return false;
        }

        if (bebida.isCaliente()) {
            for (Prestamo p : prestamos) {
                if (p.getCopiaJuego().getJuego().getCategoria().equals("Accion")) {
                    return false;
                }
            }
        }

        return true;
    }

    
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

  
    public int getNumeroMesa() {
        return this.numeroMesa;
    }

    public int getNumeroPersonas() {
        return this.numeroPersonas;
    }
    
    public int getCapacidad() {
    	return this.capacidad;
    }
}
