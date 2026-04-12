package Roles;

import BoardGame.Turno;

public class Cocinero extends Empleado {

    // Constructor correcto
    public Cocinero(String nombre, String idEmpleado, Turno turno) {
        super(nombre, idEmpleado, turno);
    }
    
    public void prepararPlatillo(String nombrePlatillo) {
        System.out.println("Cocinero " + getNombre() + " está preparando: " + nombrePlatillo);
    }

    public void sugerirPlatillo(String nombrePlatillo) {
        System.out.println("Sugerencia de nuevo platillo: " + nombrePlatillo);
    }

}