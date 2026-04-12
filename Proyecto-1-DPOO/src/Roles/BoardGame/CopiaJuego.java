package BoardGame;

public class CopiaJuego {
	
    private int idCopia;
    private Juego juego;
    private boolean disponible;
    private String estado;
    private int vecesPrestado;

    public CopiaJuego(int idCopia, Juego juego, String estado) {
        this.idCopia = idCopia;
        this.juego = juego;
        this.disponible = true;
        this.estado = estado;
        this.vecesPrestado = 0;
    }

    public int getIdCopia() {
        return this.idCopia;
    }

    public Juego getJuego() {
        return juego;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public int getVecesPrestado() {
        return vecesPrestado;
    }

    public void prestado() {
        if (disponible) {
            disponible = false;
            vecesPrestado++;
        }
    }

    public void devuelto() {
        disponible = true;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Copia: " + idCopia +
               " | Juego: " + juego.getNombre() +
               " | Disponible: " + disponible +
               " | Estado: " + estado +
               " | Veces prestado: " + vecesPrestado;
    }
}
