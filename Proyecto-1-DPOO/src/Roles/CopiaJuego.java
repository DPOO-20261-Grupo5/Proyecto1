
public class CopiaJuego {
    private String codigo;
    private Juego juego;
    private boolean disponible;

    public CopiaJuego(String codigo, Juego juego) {
        this.codigo = codigo;
        this.juego = juego;
        this.disponible = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo != null) {
            this.codigo = codigo;
        }
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        if (juego != null) {
            this.juego = juego;
        }
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestado() {
        if (disponible) {
            disponible = false;
        }
    }

    public void devuelto() {
        disponible = true;
    }

    public String mostrarInformacion() {
        return "Copia: " + codigo + " | " + juego.mostrarInformacion() + " | Disponible: " + disponible;
    }

}
