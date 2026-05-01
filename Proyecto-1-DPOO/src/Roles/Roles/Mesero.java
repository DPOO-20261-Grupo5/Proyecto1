package Roles;

import java.util.ArrayList;
import java.util.List;

import BoardGame.Juego;
import BoardGame.Turno;

public class Mesero extends Empleado {

    // Atributos
    private List<Juego> juegosQuePuedeExplicar;

    // Constructor correcto
    public Mesero(String nombre, String idEmpleado, Turno turno, String login, String password) {
        super(nombre, idEmpleado, turno, login, password);
        this.juegosQuePuedeExplicar = new ArrayList<>();
    }

    // Métodos útiles

    public void agregarJuego(Juego juego) {
        if (!juegosQuePuedeExplicar.contains(juego)) {
            juegosQuePuedeExplicar.add(juego);
        }
    }

    public boolean puedeExplicar(Juego juego) {
        return juegosQuePuedeExplicar.contains(juego);
    }

    public List<Juego> getJuegosQuePuedeExplicar() {
        return this.juegosQuePuedeExplicar;
    }
}
