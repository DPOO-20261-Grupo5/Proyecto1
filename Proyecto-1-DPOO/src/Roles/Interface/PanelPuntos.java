package Interface;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Roles.Cliente;

public class PanelPuntos extends JPanel {

    public PanelPuntos(
            Cliente cliente) {

        setLayout(
                new BorderLayout());

        JLabel puntos =
                new JLabel(

                    "Puntos fidelidad: "
                    + cliente.getPuntosFidelidad(),

                    JLabel.CENTER);

        puntos.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28));

        add(
            puntos,
            BorderLayout.CENTER);
    }
}