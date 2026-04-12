package BoardGame;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Venta {

    // Atributos
    private int idVenta;
    private Date fecha;
    private List<ItemVenta> items;
    private double porcentajePropina; // ej: 0.1 = 10%

    // Constructor
    public Venta(int idVenta, Date fecha) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.items = new ArrayList<>();
        this.porcentajePropina = 0.10; // sugerida
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

    // Calcular impuestos
    public double calcularImpuestos() {
        double impuestos = 0;

        for (ItemVenta item : items) {
            Producto p = item.getProducto();

            if (p instanceof Bebida || p instanceof Pasteleria) {
                impuestos += item.calcularSubtotal() * 0.08; // consumo
            } else if (p instanceof JuegoVenta) {
                impuestos += item.calcularSubtotal() * 0.19; // IVA
            }
        }

        return impuestos;
    }

    // Calcular propina
    public double calcularPropina() {
        return calcularSubtotal() * porcentajePropina;
    }

    // Calcular total
    public double calcularTotal() {
        return calcularSubtotal() + calcularImpuestos() + calcularPropina();
    }

    // Calcular puntos (1%)
    public int calcularPuntos() {
        return (int) (calcularTotal() * 0.01);
    }

    // Getters
    public int getIdVenta() {
        return idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<ItemVenta> getItems() {
        return items;
    }

    // Cambiar propina
    public void setPorcentajePropina(double porcentaje) {
        this.porcentajePropina = porcentaje;
    }

    // toString (muy útil para consola)
    @Override
    public String toString() {
        return "Venta #" + idVenta +
               " | Fecha: " + fecha +
               " | Total: " + calcularTotal();
    }
}
