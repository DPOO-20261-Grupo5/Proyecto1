package Interface;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Roles.Cliente;

public class PanelHomeCliente extends JPanel {

    public PanelHomeCliente(
            Cliente cliente) {

        setLayout(
                new BorderLayout());

        EstiloUI.panel(this);

        JLabel logo =
                new JLabel(
                        new ImageIcon(
                                getClass()
                                .getResource(
                                        "/imagenes/dado.png")));

        logo.setHorizontalAlignment(
                JLabel.CENTER);

        JLabel bienvenida =
                new JLabel(

                        "Bienvenido "
                        + cliente.getNombre(),

                        JLabel.CENTER);

        bienvenida.setFont(
                EstiloUI.TITULO);

        JLabel puntos =
                new JLabel(

                        "Puntos: "
                        + cliente.getPuntosFidelidad(),

                        JLabel.CENTER);

        puntos.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        20));

        JLabel mensaje =
                new JLabel(
                        "Disfruta tu experiencia en Dulces & Dados",
                        JLabel.CENTER);

        add(
            bienvenida,
            BorderLayout.NORTH);

        add(
            logo,
            BorderLayout.CENTER);

        JPanel abajo =
                new JPanel(
                        new BorderLayout());

        abajo.setBackground(
                EstiloUI.FONDO);

        abajo.add(
                puntos,
                BorderLayout.NORTH);

        abajo.add(
                mensaje,
                BorderLayout.SOUTH);

        add(
            abajo,
            BorderLayout.SOUTH);
    }
}