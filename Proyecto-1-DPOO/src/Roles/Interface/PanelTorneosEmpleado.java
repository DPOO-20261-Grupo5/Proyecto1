package Interface;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Roles.Cliente;
import BoardGame.Torneo;

public class PanelTorneosEmpleado extends JPanel {

    private JTable tabla;

    public PanelTorneosEmpleado(

            Cliente clienteEmpleado,
            List<Torneo> torneos) {

        setLayout(
                new BorderLayout());
        
        EstiloUI.panel(
                this);

        String[] columnas = {
                "ID",
                "Juego",
                "Tipo",
                "Fecha",
                "Inscritos"
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
                            t.getTotalCuposOcupados());

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

        JButton entrar =
                new JButton(
                        "Inscribirse");

        JButton salir =
                new JButton(
                        "Salir");

        // INSCRIBIR

        entrar.addActionListener(e -> {

            int fila =
                    tabla.getSelectedRow();

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

            for(Torneo t :
                    torneos){

                if(t.getId()==id){

                    try {

                        t.inscribir(
                                clienteEmpleado,
                                1);

                        JOptionPane.showMessageDialog(
                                this,
                                "Inscrito");

                        removeAll();

                        add(
                            new PanelTorneosEmpleado(
                                    clienteEmpleado,
                                    torneos),
                            BorderLayout.CENTER);

                        revalidate();
                        repaint();

                    }

                    catch(Exception ex){

                        JOptionPane.showMessageDialog(
                                this,
                                ex.getMessage());
                    }
                }
            }
        });

        // SALIR

        salir.addActionListener(e -> {

            int fila =
                    tabla.getSelectedRow();

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

            for(Torneo t :
                    torneos){

                if(t.getId()==id){

                    t.desinscribir(
                            clienteEmpleado);

                    JOptionPane.showMessageDialog(
                            this,
                            "Desinscrito");

                    removeAll();

                    add(
                        new PanelTorneosEmpleado(
                                clienteEmpleado,
                                torneos),
                        BorderLayout.CENTER);

                    revalidate();
                    repaint();
                }
            }
        });

        abajo.add(
                entrar);

        abajo.add(
                salir);

        add(
            abajo,
            BorderLayout.SOUTH);
    }
}