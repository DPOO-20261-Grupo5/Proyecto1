package Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BienvenidaFrame extends JFrame {

    public BienvenidaFrame(

            String mensaje,
            Runnable siguiente) {

        setTitle(
                "Bienvenido");

        setSize(
                500,
                250);

        setLocationRelativeTo(
                null);

        setUndecorated(
                true);

        setLayout(
                new BorderLayout());

        getContentPane()
        .setBackground(
                EstiloUI.FONDO);

        JLabel logo =
                new JLabel(
                        new ImageIcon(
                                "src/Roles/imagenes/dado.png"));

        logo.setHorizontalAlignment(
                JLabel.CENTER);

        JLabel label =
                new JLabel(
                        mensaje,
                        JLabel.CENTER);

        label.setFont(
                EstiloUI.TITULO);

        JPanel centro =
                new JPanel(
                        new BorderLayout());

        centro.setBackground(
                EstiloUI.FONDO);

        centro.add(
                logo,
                BorderLayout.CENTER);

        centro.add(
                label,
                BorderLayout.SOUTH);

        add(
            centro,
            BorderLayout.CENTER);

        setVisible(
                true);

        javax.swing.Timer timer =
                new javax.swing.Timer(

                        2000,

                        e -> {

                            dispose();

                            siguiente.run();
                        });

        timer.setRepeats(
                false);

        timer.start();
    }
}