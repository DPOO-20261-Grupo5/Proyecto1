package Interface;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Roles.Cliente;
import BoardGame.Prestamo;

public class PanelMisPrestamos extends JPanel {

    private JTable tabla;

    public PanelMisPrestamos(
            Cliente cliente) {

        setLayout(new BorderLayout());

        String[] columnas = {
                "ID",
                "Juego",
                "Fecha"
        };

        String[][] datos =
                new String[
                    cliente.getPrestamos().size()
                ][3];

        int i = 0;

        for(Prestamo p :
                cliente.getPrestamos()) {

            datos[i][0] =
                    String.valueOf(
                            p.getIdPrestamo());

            datos[i][1] =
                    p.getCopiaJuego()
                    .getJuego()
                    .getNombre();

            datos[i][2] =
                    p.getFechaPrestamo()
                    .toString();

            i++;
        }

        tabla =
                new JTable(
                        datos,
                        columnas);

        add(
            new JScrollPane(tabla),
            BorderLayout.CENTER);

        JButton btnDevolver =
                new JButton(
                        "Devolver préstamo");

        btnDevolver.addActionListener(e -> {

            int fila =
                    tabla.getSelectedRow();

            if(fila == -1){

                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione préstamo");

                return;
            }

            int id =
                    Integer.parseInt(
                            tabla.getValueAt(
                                    fila,
                                    0)
                            .toString());

            Prestamo devolver =
                    null;

            for(Prestamo p :
                    cliente.getPrestamos()) {

                if(p.getIdPrestamo()
                        == id) {

                    devolver = p;
                    break;
                }
            }

            if(devolver != null){

                devolver.devolver(
                        java.time.LocalDate.now());

                cliente.devolverPrestamo(
                        devolver);

                JOptionPane.showMessageDialog(
                        this,
                        "Devuelto");

                removeAll();

                add(
                    new PanelMisPrestamos(
                            cliente),
                    BorderLayout.CENTER);

                revalidate();
                repaint();
            }
        });

        add(btnDevolver,
                BorderLayout.SOUTH);
    }
}
