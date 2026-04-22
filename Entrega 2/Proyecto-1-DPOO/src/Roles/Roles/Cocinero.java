package Roles;

import BoardGame.Turno;

public class Cocinero extends Empleado {

    // Constructor correcto
    public Cocinero(String nombre, String id, Turno turno, String login, String password) {
        super(nombre, id, turno, login, password );
    }
    
    public void prepararPlatillo(String nombrePlatillo) {
        System.out.println("Cocinero " + getNombre() + " está preparando: " + nombrePlatillo);
    }

    public void sugerirPlatillo(String nombrePlatillo) {
        System.out.println("Sugerencia de nuevo platillo: " + nombrePlatillo);
    }

}