package Interface;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import BoardGame.*;

public class PanelInventarioVenta extends JPanel {

    private JTable tabla;

    public PanelInventarioVenta(
            InventarioVenta inventarioVenta) {

        setLayout(
                new BorderLayout());
        
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
                "Juego",
                "Precio",
                "Stock"
        };

        String[][] datos =
                new String[
                    inventarioVenta
                    .getJuegosVenta()
                    .size()
                ][3];

        int i = 0;

        for(JuegoVenta j :
                inventarioVenta
                .getJuegosVenta()) {

            datos[i][0] =
                    j.getJuego()
                    .getNombre();

            datos[i][1] =
                    String.valueOf(
                            j.getPrecio());

            datos[i][2] =
                    String.valueOf(
                            j.getStockDisponible());

            i++;
        }

        tabla =
                new JTable(
                        datos,
                        columnas);
        
        EstiloUI.tabla(
                tabla);

        add(
            new JScrollPane(
                    tabla),
            BorderLayout.CENTER);

        JButton aumentar =
                new JButton(
                        "Aumentar stock");

        aumentar.addActionListener(e -> {

            int fila =
                    tabla
                    .getSelectedRow();

            if(fila == -1){

                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione juego");

                return;
            }

            String nombre =
                    tabla
                    .getValueAt(
                            fila,
                            0)
                    .toString();

            JuegoVenta juego =
                    inventarioVenta
                    .buscarJuego(
                            nombre);

            if(juego != null){

                juego.aumentarStock(
                        1);

                JOptionPane.showMessageDialog(
                        this,
                        "Stock aumentado");

                removeAll();

                add(
                    new PanelInventarioVenta(
                            inventarioVenta),
                    BorderLayout.CENTER);

                revalidate();
                repaint();
            }
        });

        add(
            aumentar,
            BorderLayout.SOUTH);
    }
}
