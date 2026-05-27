package Interface;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Roles.Mesero;
import BoardGame.*;

public class PanelPrestamosEmpleado extends JPanel {

    private JTable tabla;

    public PanelPrestamosEmpleado(

            Mesero empleado,
            InventarioPrestamo inventarioPrestamo,
            List<Prestamo> prestamosEmpleado) {

        setLayout(
                new BorderLayout());
        
        EstiloUI.panel(
                this);

        String[] columnas = {
                "ID",
                "Juego",
                "Disponible"
        };

        String[][] datos =
                new String[
                    inventarioPrestamo
                    .getCopias()
                    .size()
                ][3];

        int i = 0;

        for(CopiaJuego copia :
                inventarioPrestamo
                .getCopias()) {

            datos[i][0] =
                    String.valueOf(
                            copia.getIdCopia());

            datos[i][1] =
                    copia.getJuego()
                    .getNombre();

            datos[i][2] =
                    String.valueOf(
                            copia.isDisponible());

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

        JPanel abajo =
                new JPanel();

        JButton pedir =
                new JButton(
                        "Pedir");

        JButton devolver =
                new JButton(
                        "Devolver");

        // PEDIR

        pedir.addActionListener(e -> {

            if(empleado.getTurno()
                    != null){

                JOptionPane.showMessageDialog(
                        this,
                        "No puede pedir en turno");

                return;
            }

            int fila =
                    tabla.getSelectedRow();

            if(fila == -1){

                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione juego");

                return;
            }

            int id =
                    Integer.parseInt(
                            tabla
                            .getValueAt(
                                    fila,
                                    0)
                            .toString());

            for(CopiaJuego copia :
                    inventarioPrestamo
                    .getCopias()) {

                if(copia.getIdCopia()
                        == id
                        && copia.isDisponible()) {

                    Prestamo p =
                            new Prestamo(

                                    prestamosEmpleado
                                    .size()+1,

                                    LocalDate.now(),

                                    copia);

                    prestamosEmpleado
                    .add(p);

                    JOptionPane.showMessageDialog(
                            this,
                            "Prestamo realizado");
                }
            }
        });

        // DEVOLVER

        devolver.addActionListener(e -> {

            if(prestamosEmpleado
                    .isEmpty()){

                JOptionPane.showMessageDialog(
                        this,
                        "No hay prestamos");

                return;
            }

            String idTxt =
                    JOptionPane
                    .showInputDialog(
                            this,
                            "ID prestamo");

            if(idTxt == null){

                return;
            }

            int id =
                    Integer.parseInt(
                            idTxt);

            Prestamo borrar =
                    null;

            for(Prestamo p :
                    prestamosEmpleado){

                if(p.getIdPrestamo()
                        == id){

                    borrar = p;
                }
            }

            if(borrar != null){

                borrar.devolver(
                        LocalDate.now());

                prestamosEmpleado
                .remove(
                        borrar);

                JOptionPane.showMessageDialog(
                        this,
                        "Devuelto");
            }
        });

        abajo.add(
                pedir);

        abajo.add(
                devolver);

        add(
            abajo,
            BorderLayout.SOUTH);
    }
}
