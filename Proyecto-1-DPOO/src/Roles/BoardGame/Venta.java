package BoardGame;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Venta {

    // Atributos
    private int idVenta;
    private LocalDate fecha;
    private List<ItemVenta> items;
    private double porcentajePropina; 

    // Constructor
    public Venta(int idVenta, LocalDate fecha) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.items = new ArrayList<>();
        this.porcentajePropina = 0.10; 
    }

    // Agregar item
    public void agregarItem(ItemVenta item) {
        items.add(item);
    }

    // Calcular subtotal
    public double calcularSubtotal() {
        double subtotal = 0;
        for (ItemVenta item : items) {
            subtotal += item.calcularSubtotal();
        }
        return subtotal;
    }

   
    public double calcularImpuestos() {
        double impuestos = 0;

        for (ItemVenta item : items) {
            Producto p = item.getProducto();

            if (p instanceof Bebida || p instanceof Pasteleria) {
                impuestos += item.calcularSubtotal() * 0.08; 
            } else if (p instanceof JuegoVenta) {
                impuestos += item.calcularSubtotal() * 0.19; 
            }
        }

        return impuestos;
    }

    
    public double calcularPropina() {
        return calcularSubtotal() * porcentajePropina;
    }

  
    public double calcularTotal() {
        return calcularSubtotal() + calcularImpuestos() + calcularPropina();
    }

   
    public int calcularPuntos() {
        return (int) (calcularTotal() * 0.01);
    }

    // Getters
    public int getIdVenta() {
        return this.idVenta;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public List<ItemVenta> getItems() {
        return this.items;
    }

    // Cambiar propina
    public void setPorcentajePropina(double porcentaje) {
        this.porcentajePropina = porcentaje;
    }


    public String informacion() {
        return "Venta #" + idVenta +
               " | Fecha: " + fecha +
               " | Total: " + calcularTotal();
    }
}
