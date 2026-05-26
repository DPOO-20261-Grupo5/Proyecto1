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

public class PanelTorneos extends JPanel {

    private JTable tabla;

    public PanelTorneos(
            Cliente cliente,
            List<Torneo> torneos) {

        setLayout(new BorderLayout());

        String[] columnas = {
                "ID",
                "Juego",
                "Tipo",
                "Fecha",
                "Cupos"
        };

        String[][] datos =
                new String[torneos.size()][5];

        int i = 0;

        for(Torneo t : torneos) {

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
            new JScrollPane(tabla),
            BorderLayout.CENTER);

        JButton btnInscribir =
                new JButton(
                        "Inscribirse");
        
        JButton btnSalir =
                new JButton(
                        "Desinscribirse");

        btnInscribir.addActionListener(e -> {

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
                            tabla.getValueAt(
                                    fila,
                                    0)
                            .toString());

            for(Torneo t : torneos){

                if(t.getId()==id){

                    try {

                        t.inscribir(
                                cliente,
                                1);

                        JOptionPane.showMessageDialog(
                                this,
                                "Inscrito");

                        removeAll();

                        add(
                            new PanelTorneos(
                                    cliente,
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
        
        btnSalir.addActionListener(e -> {

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
                            tabla.getValueAt(
                                    fila,
                                    0)
                            .toString());

            for(Torneo t :
                    torneos){

                if(t.getId()==id){

                    t.desinscribir(
                            cliente);

                    JOptionPane.showMessageDialog(
                            this,
                            "Desinscrito");

                    removeAll();

                    add(
                        new PanelTorneos(
                                cliente,
                                torneos),
                        BorderLayout.CENTER);

                    revalidate();
                    repaint();
                }
            }
        });

        JPanel abajo =
                new JPanel();

        abajo.add(btnInscribir);
        abajo.add(btnSalir);

        add(abajo,
                BorderLayout.SOUTH);
    }
}
