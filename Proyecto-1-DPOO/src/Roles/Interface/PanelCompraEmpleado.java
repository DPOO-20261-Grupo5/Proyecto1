package Interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Roles.Mesero;
import BoardGame.*;

public class PanelCompraEmpleado extends JPanel {

    public PanelCompraEmpleado(

            Mesero empleado,
            InventarioVenta inventarioVenta) {

        setLayout(
                new BorderLayout());
        EstiloUI.panel(
                this);

        JPanel formulario =
                new JPanel(
                        new GridLayout(
                                4,
                                2));

        JLabel lblJuego =
                new JLabel(
                        "Juego");

        JComboBox<String> combo =
                new JComboBox<>();

        for(JuegoVenta j :
                inventarioVenta
                .getJuegosVenta()) {

            combo.addItem(
                    j.getJuego()
                    .getNombre());
        }

        JLabel lblCantidad =
                new JLabel(
                        "Cantidad");

        JTextField txtCantidad =
                new JTextField();

        JButton comprar =
                new JButton(
                        "Comprar");

        formulario.add(
                lblJuego);

        formulario.add(
                combo);

        formulario.add(
                lblCantidad);

        formulario.add(
                txtCantidad);

        add(
            formulario,
            BorderLayout.CENTER);

        add(
            comprar,
            BorderLayout.SOUTH);

        comprar.addActionListener(e -> {

            try {

                String nombre =
                        combo
                        .getSelectedItem()
                        .toString();

                int cantidad =
                        Integer.parseInt(
                                txtCantidad
                                .getText());

                JuegoVenta juego =
                        inventarioVenta
                        .buscarJuego(
                                nombre);

                if(juego == null){

                    JOptionPane.showMessageDialog(
                            this,
                            "Juego no existe");

                    return;
                }

                if(juego
                        .getStockDisponible()
                        < cantidad){

                    JOptionPane.showMessageDialog(
                            this,
                            "Sin stock");

                    return;
                }

                Venta venta =
                        new Venta(
                                1,
                                java.time.LocalDate.now());

                ItemVenta item =
                        new ItemVenta(
                                juego,
                                cantidad,
                                juego.getPrecio());

                venta.agregarItem(
                        item);

                juego.reducirStock(
                        cantidad);

                double subtotal =
                        venta
                        .calcularSubtotal();

                double iva =
                        venta
                        .calcularImpuestos();

                double total =
                        venta
                        .calcularTotal();

                double descuento =
                        total * 0.20;

                double totalFinal =
                        total - descuento;

                JOptionPane.showMessageDialog(

                        this,

                        "Subtotal: "
                        + subtotal

                        + "\nIVA: "
                        + iva

                        + "\nDescuento empleado: "
                        + descuento

                        + "\nTotal final: "
                        + totalFinal);
            }

            catch(Exception ex){

                JOptionPane.showMessageDialog(
                        this,
                        "Datos invalidos");
            }
        });
    }
}
