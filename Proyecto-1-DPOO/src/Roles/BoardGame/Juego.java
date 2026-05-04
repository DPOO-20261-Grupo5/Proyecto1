package BoardGame;

public class Juego {

    // Atributos
    private String nombre;
    private int anioPublicacion;
    private String empresa;
    private int minJugadores;
    private int maxJugadores;
    private int edadMinima;
    private String categoria; // 
    private boolean esDificil;

    // Constructor
    public Juego(String nombre, int anioPublicacion, String empresa,
                 int minJugadores, int maxJugadores,
                 int edadMinima, String categoria, boolean esDificil) {

        this.nombre = nombre;
        this.anioPublicacion = anioPublicacion;
        this.empresa = empresa;
        this.minJugadores = minJugadores;
        this.maxJugadores = maxJugadores;
        this.edadMinima = edadMinima;
        this.categoria = categoria;
        this.esDificil = esDificil;
    }

   

    public String getNombre() {
        return this.nombre;
    }

    public int getAnioPublicacion() {
        return this.anioPublicacion;
    }

    public String getEmpresa() {
        return this.empresa;
    }

    public int getMinJugadores() {
        return this.minJugadores;
    }

    public int getMaxJugadores() {
        return this.maxJugadores;
    }

    public int getEdadMinima() {
        return this.edadMinima;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public boolean isEsDificil() {
        return this.esDificil;
    }

   
    public boolean esAptoPara(int numeroJugadores, int edad) {
        return numeroJugadores >= minJugadores &&
               numeroJugadores <= maxJugadores &&
               edad >= edadMinima;
    }

    
    public String informacion() {
        return "Juego: " + nombre +
               " (" + categoria + ") - Jugadores: " +
               minJugadores + "-" + maxJugadores;
    }
//
}


