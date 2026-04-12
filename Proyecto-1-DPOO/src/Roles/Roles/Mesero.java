package Roles;
import java.util.ArrayList;
import java.util.List;

import BoardGame.Juego;

public class Mesero extends Empleado {
	
	//Atributos
	
	private List<Juego> juegosQuePuedeExplicar;
	
	//Constructor
	public Mesero(int idEmpleado, String nombre, String password, String turno) {
		super(idEmpleado, nombre, password, turno);
		this.juegosQuePuedeExplicar = new ArrayList<Juego>();
	}
	
	

}
