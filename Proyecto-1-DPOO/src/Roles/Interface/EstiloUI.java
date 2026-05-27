package Interface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class EstiloUI {

    public static final Color FONDO_MENU =
            new Color(
                    45,
                    52,
                    54);

    public static final Color BOTON =
            new Color(
                    99,
                    110,
                    114);

    public static final Color FONDO =
    		new Color(
    		        245,
    		        246,
    		        250);

    public static final Font TITULO =
            new Font(
                    "Arial",
                    Font.BOLD,
                    26);

    public static final Font NORMAL =
            new Font(
                    "Arial",
                    Font.PLAIN,
                    16);

    public static void boton(
            JButton b) {

        b.setBackground(
                BOTON);

        b.setForeground(
        		new Color(
        		        245,
        		        246,
        		        250));

        b.setFocusPainted(
                false);

        b.setFont(
                NORMAL);

        b.setBorder(

            BorderFactory
            .createEmptyBorder(
                    10,
                    20,
                    10,
                    20));

        b.setCursor(

            new java.awt.Cursor(
                    java.awt.Cursor.HAND_CURSOR));

        Color original =
                BOTON;

        Color hover =
                new Color(
                        70,
                        80,
                        85);

        b.addMouseListener(

            new java.awt.event.MouseAdapter() {

                public void mouseEntered(
                        java.awt.event.MouseEvent e) {

                    b.setBackground(
                            hover);
                }

                public void mouseExited(
                        java.awt.event.MouseEvent e) {

                    b.setBackground(
                            original);
                }
            });
    }

    public static void tabla(
            JTable tabla) {

        tabla.setRowHeight(
                30);

        tabla.setFont(
                NORMAL);

        tabla.getTableHeader()
                .setFont(
                        new Font(
                                "Arial",
                                Font.BOLD,
                                15));
    }

    public static void panel(
            JPanel panel) {

        panel.setBorder(

            BorderFactory
            .createEmptyBorder(
                    20,
                    20,
                    20,
                    20));
    }
}