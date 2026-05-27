package Interface;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Roles.Cliente;
import BoardGame.*;

public class PanelPrestamos extends JPanel {

    private JTable tabla;

    public PanelPrestamos(
            Cliente cliente,
            InventarioPrestamo inventarioPrestamo) {

        setLayout(new BorderLayout());
        EstiloUI.panel(
                this);

        String[] columnas = {
                "ID",
                "Juego",
                "Disponible"
        };

        String[][] datos =
                new String[
                    inventarioPrestamo.getCopias().size()
                ][3];

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
                    String.valueOf(
                            c.isDisponible());

            i++;
        }

        tabla =
                new JTable(
                        datos,
                        columnas);
        
        EstiloUI.tabla(
                tabla);

        JScrollPane scroll =
                new JScrollPane(tabla);

        add(scroll,
                BorderLayout.CENTER);

        JButton btnPrestamo =
                new JButton(
                        "Solicitar préstamo");

        btnPrestamo.addActionListener(e -> {

            int fila =
                    tabla.getSelectedRow();

            if(fila == -1){

                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione un juego");

                return;
            }

            int idCopia =
                    Integer.parseInt(
                            tabla.getValueAt(
                                    fila,
                                    0).toString());

            CopiaJuego copia =
                    null;

            for(CopiaJuego c :
                    inventarioPrestamo.getCopias()) {

                if(c.getIdCopia()
                        == idCopia) {

                    copia = c;
                    break;
                }
            }

            if(copia == null
                    || !copia.isDisponible()) {

                JOptionPane.showMessageDialog(
                        this,
                        "No disponible");

                return;
            }

            Prestamo prestamo =
                    new Prestamo(
                            cliente.getPrestamos().size()+1,
                            java.time.LocalDate.now(),
                            copia);

            cliente.agregarPrestamo(
                    prestamo);

            JOptionPane.showMessageDialog(
                    this,
                    "Préstamo realizado");
        });

        add(btnPrestamo,
                BorderLayout.SOUTH);
    }
}
