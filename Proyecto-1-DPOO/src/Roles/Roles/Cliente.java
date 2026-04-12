package Roles;
import java.util.ArrayList;
import java.util.List;

import BoardGame.Juego;
import BoardGame.Mesa;
import BoardGame.Prestamo;
import BoardGame.Venta;

public class Cliente extends Usuario {
	
	//Atributos
	
	private int puntosFidelidad;
	private List<Prestamo> prestamos;
	private Mesa mesa;
	private List<Venta> ventas;
	private List<Juego> juegosFavoritos;
	
	
	//Constructor
	public Cliente (int id, String nombre, String login, String password) {
		super(id, nombre, login, password);
		this.puntosFidelidad = 0;
		this.prestamos = new ArrayList<Prestamo>();
		this.juegosFavoritos = new ArrayList<Juego>();
		this.mesa = null;
		this.ventas = new ArrayList<Venta>();
	}
	
	//Metodos
	
	public int getPuntosFidelidad() {
	    return this.puntosFidelidad;
	}
	
	public Mesa getMesa() {
		return this.mesa;
	}
	
	public void agregarPrestamo(Prestamo prestamo) {
	    if (prestamos.size() < 2) {
	        prestamos.add(prestamo);
	    } else {
	        System.out.println("No puede tener más de 2 préstamos simultáneos");
	    }
	}
	
	public void devolverPrestamo(Prestamo prestamo) {
	    prestamos.remove(prestamo);
	}

	public void agregarVenta(Venta venta) {
	    ventas.add(venta);
	}

	public void agregarJuegoFavorito(Juego juego) {
	    if (!juegosFavoritos.contains(juego)) {
	        juegosFavoritos.add(juego);
	    }
	}
	
	public void acumularPuntos(double valorCompra) {
	    int puntos = (int) (valorCompra * 0.01);
	    this.puntosFidelidad += puntos;
	}
	
	public void asignarMesa(Mesa mesa) {
	    this.mesa = mesa;
	}

	public void liberarMesa() {
	    this.mesa = null;
	}
	
	public List<Prestamo> getPrestamos(){
		return this.prestamos;
	}
}
