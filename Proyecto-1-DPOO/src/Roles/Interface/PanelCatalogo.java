package Interface;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import BoardGame.CopiaJuego;
import BoardGame.InventarioPrestamo;

public class PanelCatalogo extends JPanel {

    public PanelCatalogo(
            InventarioPrestamo inventarioPrestamo) {

        setLayout(new BorderLayout());
        EstiloUI.panel(
                this);
        
        JLabel titulo =
                new JLabel(
                        "Catalogo",
                        JLabel.CENTER);

        titulo.setFont(
                EstiloUI.TITULO);

        add(
            titulo,
            BorderLayout.NORTH);

        String[] columnas = {
                "ID",
                "Juego",
                "Estado",
                "Disponible"
        };

        String[][] datos =
                new String[
                    inventarioPrestamo.getCopias().size()
                ][4];

        int i = 0;

        for(CopiaJuego c :
                inventarioPrestamo.getCopias()) {

            datos[i][0] =
                    String.valueOf(
                            c.getIdCopia());

            datos[i][1] =
                    c.getJuego()
                    .getNombre();

            datos[i][2] =
                    c.getEstado();

            datos[i][3] =
                    String.valueOf(
                            c.isDisponible());

            i++;
        }

        JTable tabla =
                new JTable(
                        datos,
                        columnas);
        
        EstiloUI.tabla(
                tabla);

        JScrollPane scroll =
                new JScrollPane(tabla);

        add(scroll,
                BorderLayout.CENTER);
    }
}