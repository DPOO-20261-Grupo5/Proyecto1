package Interface;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Roles.Cliente;
import BoardGame.*;

public class PanelFavoritos extends JPanel {

    public PanelFavoritos(
            Cliente cliente,
            InventarioPrestamo inventarioPrestamo) {

        setLayout(new BorderLayout());

        DefaultListModel<String> modelo =
                new DefaultListModel<>();

        for(Juego j :
                cliente.getJuegosFavoritos()) {

            modelo.addElement(
                    j.getNombre());
        }

        JList<String> lista =
                new JList<>(
                        modelo);

        add(
            new JScrollPane(
                    lista),
            BorderLayout.CENTER);

        JPanel abajo =
                new JPanel();

        JComboBox<String> combo =
                new JComboBox<>();

        for(CopiaJuego c :
                inventarioPrestamo.getCopias()) {

            combo.addItem(
                    c.getJuego()
                    .getNombre());
        }

        JButton agregar =
                new JButton(
                        "Agregar favorito");
        
        JButton eliminar =
                new JButton(
                        "Eliminar");

        agregar.addActionListener(e -> {

            String nombre =
                    combo.getSelectedItem()
                    .toString();

            Juego juego =
                    null;

            for(CopiaJuego c :
                    inventarioPrestamo.getCopias()) {

                if(c.getJuego()
                        .getNombre()
                        .equalsIgnoreCase(
                                nombre)) {

                    juego =
                            c.getJuego();
                }
            }

            if(juego != null){

                cliente.agregarJuegoFavorito(
                        juego);

                JOptionPane.showMessageDialog(
                        this,
                        "Agregado");

                removeAll();

                add(
                    new PanelFavoritos(
                            cliente,
                            inventarioPrestamo),
                    BorderLayout.CENTER);

                revalidate();
                repaint();
            }
        });
        
        eliminar.addActionListener(e -> {

            String seleccionado =
                    lista.getSelectedValue();

            if(seleccionado == null){

                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione favorito");

                return;
            }

            Juego borrar =
                    null;

            for(Juego j :
                    cliente.getJuegosFavoritos()) {

                if(j.getNombre()
                        .equalsIgnoreCase(
                                seleccionado)) {

                    borrar = j;
                }
            }

            if(borrar != null){

                cliente
                .getJuegosFavoritos()
                .remove(borrar);

                JOptionPane.showMessageDialog(
                        this,
                        "Eliminado");

                removeAll();

                add(
                    new PanelFavoritos(
                            cliente,
                            inventarioPrestamo),
                    BorderLayout.CENTER);

                revalidate();
                repaint();
            }
        });

        abajo.add(combo);
        abajo.add(agregar);
        abajo.add(eliminar);

        add(abajo,
                BorderLayout.SOUTH);
    }
}
