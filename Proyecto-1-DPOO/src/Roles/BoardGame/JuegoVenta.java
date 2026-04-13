package BoardGame;

public class JuegoVenta extends Producto {

    // Atributos
    private Juego juego;
    private int stockDisponible;

    // Constructor 
    public JuegoVenta(Juego juego, double precio, int stockDisponible) {
        super(juego.getNombre(), precio); 
        this.juego = juego;
        this.stockDisponible = stockDisponible;
    }

    // Métodos

    public Juego getJuego() {
        return this.juego;
    }

    public int getStockDisponible() {
        return this.stockDisponible;
    }
    

    public void reducirStock(int cantidad) {
        if (cantidad > 0 && stockDisponible >= cantidad) {
            stockDisponible -= cantidad;
        }
    }

    public void aumentarStock(int cantidad) {
        if (cantidad > 0) {
            stockDisponible += cantidad;
        }
    }

 
    public String informacion() {
        return "Juego en venta: " + juego.getNombre() +
               " | Precio: " + getPrecio() +
               " | Stock: " + stockDisponible;
    }
}