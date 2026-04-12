package BoardGame;

public class Juego {

    // Atributos
    private String nombre;
    private int anioPublicacion;
    private String empresa;
    private int minJugadores;
    private int maxJugadores;
    private int edadMinima;
    private String categoria; // Cartas, Tablero, Acción
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

    // Getters

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

    // Método útil (extra, suma puntos)
    public boolean esAptoPara(int numeroJugadores, int edad) {
        return numeroJugadores >= minJugadores &&
               numeroJugadores <= maxJugadores &&
               edad >= edadMinima;
    }

    // toString (útil para pruebas en consola)
    @Override
    public String toString() {
        return "Juego: " + nombre +
               " (" + categoria + ") - Jugadores: " +
               minJugadores + "-" + maxJugadores;
    }

	
	public void setPrecio(double precio) {
		if (precio>=0) {
			this.precio=precio;
		}	
	}
	
	public String mostrarInformacion() {
	    return "Juego: " + nombre + " | Precio: " + precio;
	}

}
