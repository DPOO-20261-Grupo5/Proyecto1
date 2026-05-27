package Interface;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import BoardGame.SolicitudCambioTurno;

public class PanelSolicitudesAdmin extends JPanel {

    private JTable tabla;

    public PanelSolicitudesAdmin(
            List<SolicitudCambioTurno> solicitudes) {

        setLayout(
                new BorderLayout());

        EstiloUI.panel(this);

        String[] columnas = {
                "ID",
                "Tipo",
                "Origen",
                "Destino"
        };

        String[][] datos =
                new String[
                    solicitudes.size()
                ][4];

        int i = 0;

        for(SolicitudCambioTurno s :
                solicitudes) {

            datos[i][0] =
                    String.valueOf(
                            s.getIdSolicitud());

            datos[i][1] =
                    s.getTipo();

            datos[i][2] =
                    s.getTurnoActual()
                    .getDiaSemana();

            datos[i][3] =
                    s.getTurnoNuevo()
                    .getDiaSemana();

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

        JPanel abajo =
                new JPanel();

        JButton aprobar =
                new JButton(
                        "Aprobar");

        JButton rechazar =
                new JButton(
                        "Rechazar");

        EstiloUI.boton(
                aprobar);

        EstiloUI.boton(
                rechazar);

        aprobar.addActionListener(e -> {

            int fila =
                    tabla.getSelectedRow();

            if(fila == -1){

                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione solicitud");

                return;
            }

            solicitudes.remove(
                    fila);

            JOptionPane.showMessageDialog(
                    this,
                    "Solicitud aprobada");

            removeAll();

            add(
                new PanelSolicitudesAdmin(
                        solicitudes),
                BorderLayout.CENTER);

            revalidate();
            repaint();
        });

        rechazar.addActionListener(e -> {

            int fila =
                    tabla.getSelectedRow();

            if(fila == -1){

                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione solicitud");

                return;
            }

            solicitudes.remove(
                    fila);

            JOptionPane.showMessageDialog(
                    this,
                    "Solicitud rechazada");

            removeAll();

            add(
                new PanelSolicitudesAdmin(
                        solicitudes),
                BorderLayout.CENTER);

            revalidate();
            repaint();
        });

        abajo.add(
                aprobar);

        abajo.add(
                rechazar);

        add(
            abajo,
            BorderLayout.SOUTH);
    }
}
