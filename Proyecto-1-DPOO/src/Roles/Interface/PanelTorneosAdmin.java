package Interface;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import BoardGame.*;

public class PanelTorneosAdmin extends JPanel {

    private JTable tabla;

    public PanelTorneosAdmin(
            List<Torneo> torneos,
            InventarioVenta inventarioVenta) {

        setLayout(
                new BorderLayout());
        
        EstiloUI.panel(
                this);

        String[] columnas = {
                "ID",
                "Juego",
                "Tipo",
                "Fecha",
                "Capacidad"
        };

        String[][] datos =
                new String[
                    torneos.size()
                ][5];

        int i = 0;

        for(Torneo t :
                torneos) {

            datos[i][0] =
                    String.valueOf(
                            t.getId());

            datos[i][1] =
                    t.getJuego()
                    .getNombre();

            datos[i][2] =
                    t.getTipo();

            datos[i][3] =
                    t.getFecha();

            datos[i][4] =
                    String.valueOf(
                            t.getCapacidadMaxima());

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

        JButton crear =
                new JButton(
                        "Crear");

        JButton eliminar =
                new JButton(
                        "Eliminar");

        // CREAR

        crear.addActionListener(e -> {

            try {

                String idTxt =
                        JOptionPane
                        .showInputDialog(
                                this,
                                "ID");

                String fecha =
                        JOptionPane
                        .showInputDialog(
                                this,
                                "Fecha");

                String tipo =
                        JOptionPane
                        .showInputDialog(
                                this,
                                "Tipo");

                String capacidadTxt =
                        JOptionPane
                        .showInputDialog(
                                this,
                                "Capacidad");

                String juegoNombre =
                        JOptionPane
                        .showInputDialog(
                                this,
                                "Juego");

                int id =
                        Integer.parseInt(
                                idTxt);

                int capacidad =
                        Integer.parseInt(
                                capacidadTxt);

                Juego juego =
                        inventarioVenta
                        .buscarJuego(
                                juegoNombre)
                        .getJuego();

                Torneo nuevo =
                        new Torneo(
                                id,
                                fecha,
                                tipo,
                                capacidad,
                                juego,
                                null);

                torneos.add(
                        nuevo);

                JOptionPane.showMessageDialog(
                        this,
                        "Creado");

                removeAll();

                add(
                    new PanelTorneosAdmin(
                            torneos,
                            inventarioVenta),
                    BorderLayout.CENTER);

                revalidate();
                repaint();
            }

            catch(Exception ex){

                JOptionPane.showMessageDialog(
                        this,
                        "Datos invalidos");
            }
        });

        // ELIMINAR

        eliminar.addActionListener(e -> {

            int fila =
                    tabla
                    .getSelectedRow();

            if(fila == -1){

                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione torneo");

                return;
            }

            int id =
                    Integer.parseInt(
                            tabla
                            .getValueAt(
                                    fila,
                                    0)
                            .toString());

            Torneo borrar =
                    null;

            for(Torneo t :
                    torneos){

                if(t.getId()
                        == id){

                    borrar = t;
                }
            }

            if(borrar != null){

                torneos.remove(
                        borrar);

                JOptionPane.showMessageDialog(
                        this,
                        "Eliminado");

                removeAll();

                add(
                    new PanelTorneosAdmin(
                            torneos,
                            inventarioVenta),
                    BorderLayout.CENTER);

                revalidate();
                repaint();
            }
        });

        abajo.add(crear);
        abajo.add(eliminar);

        add(
            abajo,
            BorderLayout.SOUTH);
    }
}