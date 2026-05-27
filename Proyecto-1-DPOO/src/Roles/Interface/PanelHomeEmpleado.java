package Interface;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Roles.Mesero;

public class PanelHomeEmpleado extends JPanel {

    public PanelHomeEmpleado(
            Mesero empleado) {

        setLayout(
                new BorderLayout());

        EstiloUI.panel(this);

        JLabel titulo =
                new JLabel(

                        "Bienvenido "
                        + empleado.getNombre(),

                        JLabel.CENTER);

        titulo.setFont(
                EstiloUI.TITULO);

        JLabel logo =
                new JLabel(
                        new ImageIcon(
                                getClass()
                                .getResource(
                                        "/imagenes/dado.png")));

        logo.setHorizontalAlignment(
                JLabel.CENTER);

        JLabel turno =
                new JLabel(

                        "Turno: "
                        + empleado
                        .getTurno()
                        .getDiaSemana(),

                        JLabel.CENTER);

        add(
            titulo,
            BorderLayout.NORTH);

        add(
            logo,
            BorderLayout.CENTER);

        add(
            turno,
            BorderLayout.SOUTH);
    }
}