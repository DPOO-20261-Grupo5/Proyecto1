package Interface;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import BoardGame.CopiaJuego;
import BoardGame.InventarioPrestamo;

public class PanelInventarioPrestamo extends JPanel {

    private JTable tabla;

    public PanelInventarioPrestamo(
            InventarioPrestamo inventarioPrestamo) {

        setLayout(
                new BorderLayout());

        String[] columnas = {
                "ID",
                "Juego",
                "Estado",
                "Disponible"
        };

        String[][] datos =
                new String[
                    inventarioPrestamo
                    .getCopias()
                    .size()
                ][4];

        int i = 0;

        for(CopiaJuego c :
                inventarioPrestamo
                .getCopias()) {

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

        tabla =
                new JTable(
                        datos,
                        columnas);

        add(
            new JScrollPane(
                    tabla),
            BorderLayout.CENTER);

        JButton marcar =
                new JButton(
                        "Marcar desaparecido");

        marcar.addActionListener(e -> {

            int fila =
                    tabla.getSelectedRow();

            if(fila == -1){

                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione copia");

                return;
            }

            int id =
                    Integer.parseInt(
                            tabla
                            .getValueAt(
                                    fila,
                                    0)
                            .toString());

            for(CopiaJuego c :
                    inventarioPrestamo
                    .getCopias()) {

                if(c.getIdCopia()
                        == id) {

                    c.setEstado(
                            "Desaparecido");

                    JOptionPane.showMessageDialog(
                            this,
                            "Marcado");

                    removeAll();

                    add(
                        new PanelInventarioPrestamo(
                                inventarioPrestamo),
                        BorderLayout.CENTER);

                    revalidate();
                    repaint();
                }
            }
        });

        add(
            marcar,
            BorderLayout.SOUTH);
    }
}
