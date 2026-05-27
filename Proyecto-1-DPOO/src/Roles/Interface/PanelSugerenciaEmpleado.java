package Interface;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelSugerenciaEmpleado extends JPanel {

    public PanelSugerenciaEmpleado(
            List<String> sugerencias) {

        setLayout(
                new BorderLayout());
        
        EstiloUI.panel(
                this);

        JTextArea texto =
                new JTextArea(
                        4,
                        30);

        JButton enviar =
                new JButton(
                        "Enviar sugerencia");

        DefaultListModel<String> modelo =
                new DefaultListModel<>();

        for(String s :
                sugerencias) {

            modelo.addElement(
                    s);
        }

        JList<String> lista =
                new JList<>(
                        modelo);

        enviar.addActionListener(e -> {

            String sugerencia =
                    texto.getText();

            if(sugerencia
                    .isBlank()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Escriba sugerencia");

                return;
            }

            sugerencias.add(
                    sugerencia);

            JOptionPane.showMessageDialog(
                    this,
                    "Enviada");

            removeAll();

            add(
                new PanelSugerenciaEmpleado(
                        sugerencias),
                BorderLayout.CENTER);

            revalidate();
            repaint();
        });

        add(
            new JScrollPane(
                    texto),
            BorderLayout.NORTH);

        add(
            new JScrollPane(
                    lista),
            BorderLayout.CENTER);

        add(
            enviar,
            BorderLayout.SOUTH);
    }
}
