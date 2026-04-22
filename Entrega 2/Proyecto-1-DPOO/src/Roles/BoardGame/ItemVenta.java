package BoardGame;

public class ItemVenta {
	
	//Atributos
    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    
    //Constructor
    public ItemVenta(Producto producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
    
    //Metodos

    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }
    
    public Producto getProducto(){
    	return this.producto;
    }
}
