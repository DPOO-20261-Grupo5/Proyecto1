package BoardGame;

import java.util.ArrayList;
import java.util.List;

public class InventarioPrestamo {

	//Atributos
    private List<CopiaJuego> copias;

    // Constructor
    public InventarioPrestamo() {
        this.copias = new ArrayList<>();
    }

    // Métodos

    public void agregarCopia(CopiaJuego copia) {
        copias.add(copia);
    }

    public List<CopiaJuego> getCopias() {
        return this.copias;
    }

    
    public List<CopiaJuego> buscarDisponibles(Juego juego) {
        List<CopiaJuego> disponibles = new ArrayList<>();

        for (CopiaJuego c : copias) {
            if (c.getJuego().equals(juego) && c.isDisponible()) {
                disponibles.add(c);
            }
        }

        return disponibles;
    }

    
    public boolean hayDisponible(Juego juego) {
        for (CopiaJuego c : copias) {
            if (c.getJuego().equals(juego) && c.isDisponible()) {
                return true;
            }
        }
        return false;
    }
}