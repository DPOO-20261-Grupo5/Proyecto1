package Interface;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelHomeAdmin extends JPanel {

    public PanelHomeAdmin(

            int ventas,
            int torneos) {

        setLayout(
                new BorderLayout());

        EstiloUI.panel(this);

        JLabel titulo =
                new JLabel(
                        "Panel Administrador",
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

        JLabel resumen =
                new JLabel(

                        "Ventas: "
                        + ventas

                        + " | Torneos: "
                        + torneos,

                        JLabel.CENTER);

        resumen.setFont(
                EstiloUI.NORMAL);

        add(
            titulo,
            BorderLayout.NORTH);

        add(
            logo,
            BorderLayout.CENTER);

        add(
            resumen,
            BorderLayout.SOUTH);
    }
}
