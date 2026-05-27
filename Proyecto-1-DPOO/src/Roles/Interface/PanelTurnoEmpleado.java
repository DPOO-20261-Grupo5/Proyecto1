package Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Roles.Mesero;
import BoardGame.SolicitudCambioTurno;
import BoardGame.Turno;

public class PanelTurnoEmpleado extends JPanel {

    public PanelTurnoEmpleado(

            Mesero empleado,
            List<SolicitudCambioTurno> solicitudes) {

        setLayout(
                new BorderLayout());
        
        EstiloUI.panel(
                this);

        DateTimeFormatter formato =
                DateTimeFormatter
                .ofPattern(
                        "HH:mm");

        Turno turno =
                empleado.getTurno();

        String texto =

                "Dia: "
                + turno.getDiaSemana()

                + " | "

                + formato.format(
                        turno.getHoraInicio())

                + " - "

                + formato.format(
                        turno.getHoraFin());

        JLabel info =
                new JLabel(
                        texto,
                        JLabel.CENTER);

        info.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26));

        add(
            info,
            BorderLayout.CENTER);

        JButton cambio =
                new JButton(
                        "Solicitar cambio");

        cambio.addActionListener(e -> {

            String nuevoDia =
                    JOptionPane
                    .showInputDialog(
                            this,
                            "Nuevo dia");

            if(nuevoDia == null
                    || nuevoDia.isBlank()) {

                return;
            }

            Turno nuevo =
                    new Turno(
                            nuevoDia,
                            turno.getHoraInicio(),
                            turno.getHoraFin());

            SolicitudCambioTurno solicitud =
                    new SolicitudCambioTurno(

                            solicitudes.size()+1,

                            empleado,

                            turno,

                            nuevo,

                            "CAMBIO");

            solicitudes.add(
                    solicitud);

            JOptionPane.showMessageDialog(
                    this,
                    "Solicitud enviada");
        });

        add(
            cambio,
            BorderLayout.SOUTH);
    }
}
