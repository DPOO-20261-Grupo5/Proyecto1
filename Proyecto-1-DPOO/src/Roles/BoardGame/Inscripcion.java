package BoardGame;

import Roles.Usuario;

public class Inscripcion {

    // Atributos
    private Usuario usuario;
    private Torneo torneo;
    private int cantidadCupos;
    private boolean esFanatico;

    // Constructor
    public Inscripcion(Usuario usuario, Torneo torneo, int cantidadCupos, boolean esFanatico) {
        this.usuario = usuario;
        this.torneo = torneo;
        setCantidadCupos(cantidadCupos); 
        this.esFanatico = esFanatico;
    }

    //Metodos

    public void setCantidadCupos(int cantidadCupos) {
        if (cantidadCupos <= 0 || cantidadCupos > 3) {
            System.out.println("Un usuario solo puede inscribir entre 1 y 3 cupos");
            return;
        }
        this.cantidadCupos = cantidadCupos;
    }



    public Usuario getUsuario() {
        return usuario;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public int getCantidadCupos() {
        return cantidadCupos;
    }

    public boolean esFanatico() {
        return esFanatico;
    }



    public boolean perteneceA(Usuario u) {
        return this.usuario.equals(u);
    }

    public void aumentarCupos(int cantidadExtra) {
        int nuevoTotal = this.cantidadCupos + cantidadExtra;
        setCantidadCupos(nuevoTotal);
    }

    public void reducirCupos(int cantidad) {
        int nuevoTotal = this.cantidadCupos - cantidad;

        if (nuevoTotal <= 0) {
            System.out.println("No puedes dejar la inscripción en 0 cupos");
            return;
        }

        this.cantidadCupos = nuevoTotal;
    }
}
