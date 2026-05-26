package Interface;
import BoardGame.*;
import java.awt.BorderLayout;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

import BoardGame.InventarioPrestamo;
import Roles.Cliente;

public class ClienteFrame extends JFrame {

    private JPanel menuPanel;
    private JPanel contenidoPanel;
    private InventarioPrestamo inventarioPrestamo;
    private InventarioVenta inventarioVenta;
    private Cliente cliente;
    private List<Torneo> torneos;

    public ClienteFrame() {

        setTitle("Dulces & Dados - Cliente");
        setSize(900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        crearDatosDemo();
        construirMenu();
        construirContenido();

        setVisible(true);
    }
    
    private void crearDatosDemo() {

        inventarioPrestamo =
                new InventarioPrestamo();
        
        inventarioVenta =
                new InventarioVenta();
        
        torneos =
                new ArrayList<>();
        
        cliente =
                new Cliente(
                        1,
                        "Laura",
                        "laura",
                        "123");

        Juego catan =
                new Juego(
                        "Catan",
                        1995,
                        "Kosmos",
                        3,
                        4,
                        10,
                        "TABLERO",
                        false);

        Juego uno =
                new Juego(
                        "Uno",
                        1971,
                        "Mattel",
                        2,
                        10,
                        5,
                        "CARTAS",
                        false);

        CopiaJuego c1 =
                new CopiaJuego(
                        1,
                        catan,
                        "Bueno");

        CopiaJuego c2 =
                new CopiaJuego(
                        2,
                        uno,
                        "Nuevo");
        
        JuegoVenta j1 =
                new JuegoVenta(
                        catan,
                        180000,
                        5);

        JuegoVenta j2 =
                new JuegoVenta(
                        uno,
                        35000,
                        8);
        
        Torneo torneo1 =
                new Torneo(
                        1,
                        "Viernes",
                        "Amistoso",
                        12,
                        catan,
                        null);

        Torneo torneo2 =
                new Torneo(
                        2,
                        "Sabado",
                        "Competitivo",
                        8,
                        uno,
                        null);

        
        torneos.add(torneo1);
        torneos.add(torneo2);
        
        inventarioVenta
                .agregarJuegoVenta(j1);

        inventarioVenta
                .agregarJuegoVenta(j2);

        inventarioPrestamo.agregarCopia(c1);
        inventarioPrestamo.agregarCopia(c2);
    }

    private void construirMenu() {

    	menuPanel = new JPanel();
    	menuPanel.setLayout(
    	        new java.awt.GridLayout(
    	                8,
    	                1,
    	                10,
    	                10));
    	
    	menuPanel.setPreferredSize(
    	        new java.awt.Dimension(
    	                180,
    	                600));
    	
    	menuPanel.setBackground(
    	        new Color(
    	                45,
    	                52,
    	                54));
    	
        JButton btnCatalogo =
                new JButton("Catalogo");

        JButton btnPrestamos =
                new JButton("Prestamos");

        JButton btnCompra =
                new JButton("Compra");

        JButton btnTorneos =
                new JButton("Torneos");
        
        JButton btnFavoritos =
                new JButton("Favoritos");
 
        JButton btnPuntos =
                new JButton("Puntos");
        
        
        JLabel titulo =
                new JLabel(
                        "Dulces & Dados");

        titulo.setForeground(
                Color.WHITE);

        titulo.setHorizontalAlignment(
                JLabel.CENTER);

        menuPanel.add(titulo);
        
        // CATALOGO
        

        btnCatalogo.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.add(
                    new PanelCatalogo(
                            inventarioPrestamo));

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });

        
        // PRESTAMOS
        

        btnPrestamos.addActionListener(e -> {

            contenidoPanel.removeAll();

            JPanel panel =
                    new JPanel();

            JButton pedir =
                    new JButton("Pedir");

            JButton mis =
                    new JButton("Mis prestamos");

            pedir.addActionListener(ev -> {

                contenidoPanel.removeAll();

                contenidoPanel.add(
                        new PanelPrestamos(
                                cliente,
                                inventarioPrestamo));

                contenidoPanel.revalidate();
                contenidoPanel.repaint();
            });

            mis.addActionListener(ev -> {

                contenidoPanel.removeAll();

                contenidoPanel.add(
                        new PanelMisPrestamos(
                                cliente));

                contenidoPanel.revalidate();
                contenidoPanel.repaint();
            });

            panel.add(pedir);
            panel.add(mis);

            contenidoPanel.add(panel);

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });

        
        // COMPRA
       

        btnCompra.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.add(
                    new PanelCompra(
                            cliente,
                            inventarioVenta));

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });
        
        //TORNEOS
        
        btnTorneos.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.add(
                    new PanelTorneos(
                            cliente,
                            torneos));

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });
        
        //FAVORITOS
        
        btnFavoritos.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.add(
                    new PanelFavoritos(
                            cliente,
                            inventarioPrestamo));

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });
        
        //PUNTOS
        
        btnPuntos.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.add(
                    new PanelPuntos(
                            cliente));

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });
        
        

        // =========================
        
        estilizarBoton(btnCatalogo);
        estilizarBoton(btnPrestamos);
        estilizarBoton(btnCompra);
        estilizarBoton(btnTorneos);
        estilizarBoton(btnFavoritos);
        estilizarBoton(btnPuntos);

        menuPanel.add(btnCatalogo);
        menuPanel.add(btnPrestamos);
        menuPanel.add(btnCompra);
        menuPanel.add(btnTorneos);
        menuPanel.add(btnFavoritos);
        menuPanel.add(btnPuntos);

        add(menuPanel,
        		BorderLayout.WEST);
    }

    private void construirContenido() {

        contenidoPanel =
                new JPanel();

        add(contenidoPanel,
                BorderLayout.CENTER);
        
        contenidoPanel.setBackground(
                Color.WHITE);
    }
    
    private void estilizarBoton(
            JButton boton) {

        boton.setBackground(
                new Color(
                        99,
                        110,
                        114));

        boton.setForeground(
                Color.WHITE);

        boton.setFocusPainted(
                false);

        boton.setPreferredSize(
                new java.awt.Dimension(
                        150,
                        45));
    }
}