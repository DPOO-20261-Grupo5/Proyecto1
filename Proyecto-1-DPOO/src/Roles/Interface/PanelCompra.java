package Interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Roles.Cliente;
import BoardGame.*;

public class PanelCompra extends JPanel {

    public PanelCompra(
            Cliente cliente,
            InventarioVenta inventarioVenta) {

        setLayout(new BorderLayout());
        EstiloUI.panel(
                this);
        
        JLabel titulo =
                new JLabel(
                        "Catalogo",
                        JLabel.CENTER);

        titulo.setFont(
                EstiloUI.TITULO);

        add(
            titulo,
            BorderLayout.NORTH);

        JPanel formulario =
                new JPanel(
                		new GridLayout(
                		        6,
                		        2,
                		        10,
                		        10));

        JLabel lblTipo =
                new JLabel("Tipo:");

        JComboBox<String> comboTipo =
                new JComboBox<>();

        comboTipo.addItem("Juego");
        comboTipo.addItem("Bebida");
        comboTipo.addItem("Pasteleria");

        JLabel lblProducto =
                new JLabel("Producto:");

        JComboBox<String> comboProducto =
                new JComboBox<>();
        
        for(JuegoVenta j :
            inventarioVenta.getJuegosVenta()) {

        comboProducto.addItem(
                j.getJuego()
                .getNombre());
    }
        
        comboTipo.addActionListener(e -> {

            comboProducto.removeAllItems();

            String tipo =
                    comboTipo
                    .getSelectedItem()
                    .toString();

            if(tipo.equals("Juego")){

                for(JuegoVenta j :
                        inventarioVenta
                        .getJuegosVenta()) {

                    comboProducto.addItem(
                            j.getJuego()
                            .getNombre());
                }
            }

            else if(tipo.equals("Bebida")){

                comboProducto.addItem(
                        "Cafe Latte");

                comboProducto.addItem(
                        "Chocolate caliente");

                comboProducto.addItem(
                        "Cerveza artesanal");
            }

            else{

                comboProducto.addItem(
                        "Cheesecake");

                comboProducto.addItem(
                        "Brownie");

                comboProducto.addItem(
                        "Croissant");
            }

           

            comboProducto.setSelectedIndex(
                    0);
        });
        

        JLabel lblCantidad =
                new JLabel(
                        "Cantidad:");
        
        JTextField txtCantidad =
                new JTextField();

        JLabel lblPrecio =
                new JLabel(
                        "Precio: -");

        JLabel lblTotal =
                new JLabel(
                        "Total estimado: -");

        JButton btnComprar =
                new JButton(
                        "Comprar");
        
        comboProducto.addActionListener(ev -> {

            try {

                String tipo =
                        comboTipo
                        .getSelectedItem()
                        .toString();

                String nombre =
                        comboProducto
                        .getSelectedItem()
                        .toString();

                double precio = 0;

                if(tipo.equals("Juego")){

                    JuegoVenta j =
                            inventarioVenta
                            .buscarJuego(
                                    nombre);

                    if(j != null){

                        precio =
                                j.getPrecio();
                    }
                }

                else if(tipo.equals("Bebida")){

                    if(nombre.equals(
                            "Cafe Latte")){

                        precio = 12000;
                    }

                    else if(nombre.equals(
                            "Chocolate caliente")){

                        precio = 10000;
                    }

                    else{

                        precio = 15000;
                    }
                }

                else{

                    if(nombre.equals(
                            "Cheesecake")){

                        precio = 14000;
                    }

                    else if(nombre.equals(
                            "Brownie")){

                        precio = 9000;
                    }

                    else{

                        precio = 8000;
                    }
                }

                lblPrecio.setText(
                        "Precio: $"
                        + precio);

            }

            catch(Exception ex){

            }
            
        });
        
        txtCantidad.addKeyListener(

        	    new java.awt.event.KeyAdapter() {

        	        public void keyReleased(

        	                java.awt.event.KeyEvent e) {

        	            try {

        	                String precioTxt =
        	                        lblPrecio
        	                        .getText()
        	                        .replace(
        	                                "Precio: $",
        	                                "");

        	                double precio =
        	                        Double.parseDouble(
        	                                precioTxt);

        	                int cantidad =
        	                        Integer.parseInt(
        	                                txtCantidad
        	                                .getText());

        	                lblTotal.setText(

        	                        "Total estimado: $"

        	                        + (precio * cantidad));
        	            }

        	            catch(Exception ex){

        	                lblTotal.setText(
        	                        "Total estimado: -");
        	            }
        	        }
        	    });

        formulario.add(lblTipo);
        formulario.add(comboTipo);

        formulario.add(lblProducto);
        formulario.add(comboProducto);
        formulario.add(lblCantidad);
        formulario.add(txtCantidad);
        
        formulario.add(
                lblPrecio);

        formulario.add(
                new JLabel());

        formulario.add(
                lblTotal);

        formulario.add(
                new JLabel());

        add(formulario,
                BorderLayout.CENTER);

        add(btnComprar,
                BorderLayout.SOUTH);

        btnComprar.addActionListener(e -> {

            try {

            	String tipo =
            	        comboTipo
            	        .getSelectedItem()
            	        .toString();

            	String nombre =
            	        comboProducto
            	        .getSelectedItem()
            	        .toString();

                int cantidad =
                        Integer.parseInt(
                                txtCantidad
                                .getText());

                Producto producto = null;

                if(tipo.equals("Juego")){

                    producto =
                            inventarioVenta
                            .buscarJuego(nombre);
                }

                else if(tipo.equals("Bebida")){

                    if(nombre.equals("Cafe Latte")){

                        producto =
                                new Bebida(
                                        "Cafe Latte",
                                        12000,
                                        false,
                                        true);
                    }

                    else if(nombre.equals(
                            "Chocolate caliente")){

                        producto =
                                new Bebida(
                                        "Chocolate caliente",
                                        10000,
                                        false,
                                        true);
                    }

                    else{

                        producto =
                                new Bebida(
                                        "Cerveza artesanal",
                                        15000,
                                        true,
                                        false);
                    }
                }

                else{

                    if(nombre.equals("Cheesecake")){

                        producto =
                                new Pasteleria(
                                        "Cheesecake",
                                        14000);
                    }

                    else if(nombre.equals("Brownie")){

                        producto =
                                new Pasteleria(
                                        "Brownie",
                                        9000);
                    }

                    else{

                        producto =
                                new Pasteleria(
                                        "Croissant",
                                        8000);
                    }
                }

                Venta venta =
                        new Venta(
                                cliente.getVentas().size()+1,
                                java.time.LocalDate.now());

                ItemVenta item =
                        new ItemVenta(
                                producto,
                                cantidad,
                                producto.getPrecio());

                venta.agregarItem(item);

                if(producto instanceof JuegoVenta){

                    ((JuegoVenta) producto)
                            .reducirStock(
                                    cantidad);
                }

                cliente.agregarVenta(
                        venta);

                cliente.acumularPuntos(
                        venta.calcularTotal());

                JOptionPane.showMessageDialog(
                        this,

                        "Subtotal: "
                        + venta.calcularSubtotal()

                        + "\nIVA: "
                        + venta.calcularImpuestos()

                        + "\nTotal: "
                        + venta.calcularTotal()

                        + "\nPuntos: "
                        + venta.calcularPuntos());

            }

            catch(Exception ex){

                JOptionPane.showMessageDialog(
                        this,
                        "Datos invalidos");
            }
        });
    }
}
