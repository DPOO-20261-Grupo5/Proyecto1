import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {
	
	//Atributos
	
	private int idVenta;
	private Date fecha;
	private int subtotal;
	private int impuestos;
	private int propina;
	private int puntosGenerados;
	private List<ItemVenta> items;
	
	//Constructor
	
	public Venta(int idVenta, Date fecha, int subtotal, int impuestos, int propina, int puntosGenerados) {
		this.idVenta = idVenta;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.impuestos = impuestos;
		this.propina = propina;
		this.puntosGenerados = puntosGenerados;
		this.items = new ArrayList<ItemVenta>();
	}	
	
		
}
