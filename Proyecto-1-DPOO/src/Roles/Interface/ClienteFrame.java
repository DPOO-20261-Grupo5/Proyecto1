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
        
        Juego carcassonne =
                new Juego(
                        "Carcassonne",
                        2000,
                        "Hans im Glück",
                        2,
                        5,
                        8,
                        "TABLERO",
                        false);

        Juego dixit =
                new Juego(
                        "Dixit",
                        2008,
                        "Libellud",
                        3,
                        6,
                        8,
                        "CARTAS",
                        false);

        Juego exploding =
                new Juego(
                        "Exploding Kittens",
                        2015,
                        "Exploding Kittens",
                        2,
                        5,
                        7,
                        "CARTAS",
                        false);

        Juego risk =
                new Juego(
                        "Risk",
                        1957,
                        "Hasbro",
                        2,
                        6,
                        10,
                        "TABLERO",
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
        
        CopiaJuego c3 =
                new CopiaJuego(
                        3,
                        carcassonne,
                        "Bueno");

        CopiaJuego c4 =
                new CopiaJuego(
                        4,
                        dixit,
                        "Nuevo");

        CopiaJuego c5 =
                new CopiaJuego(
                        5,
                        exploding,
                        "Bueno");

        CopiaJuego c6 =
                new CopiaJuego(
                        6,
                        risk,
                        "Desaparecido");
        
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
        
        JuegoVenta j3 =
                new JuegoVenta(
                        carcassonne,
                        150000,
                        4);

        JuegoVenta j4 =
                new JuegoVenta(
                        dixit,
                        110000,
                        7);

        JuegoVenta j5 =
                new JuegoVenta(
                        exploding,
                        90000,
                        9);

        JuegoVenta j6 =
                new JuegoVenta(
                        risk,
                        175000,
                        3);
        
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
        
        Torneo torneo3 =
                new Torneo(
                        3,
                        "Domingo",
                        "Amistoso",
                        10,
                        carcassonne,
                        null);

        Torneo torneo4 =
                new Torneo(
                        4,
                        "Jueves",
                        "Competitivo",
                        8,
                        dixit,
                        null);

        Torneo torneo5 =
                new Torneo(
                        5,
                        "Lunes",
                        "Amistoso",
                        14,
                        risk,
                        null);

        
        torneos.add(torneo1);
        torneos.add(torneo2);
        torneos.add(torneo3);
        torneos.add(torneo4);
        torneos.add(torneo5);
        
        inventarioVenta
                .agregarJuegoVenta(j1);

        inventarioVenta
                .agregarJuegoVenta(j2);
        
        inventarioVenta
        	.agregarJuegoVenta(j3);

        inventarioVenta
        	.agregarJuegoVenta(j4);

        inventarioVenta
        	.agregarJuegoVenta(j5);

        inventarioVenta
        	.agregarJuegoVenta(j6);

        inventarioPrestamo.agregarCopia(c1);
        inventarioPrestamo.agregarCopia(c2);
        inventarioPrestamo
        	.agregarCopia(c3);

        inventarioPrestamo
        	.agregarCopia(c4);

        inventarioPrestamo
        .agregarCopia(c5);
        
        inventarioPrestamo
        	.agregarCopia(c6);
        
        cliente.agregarJuegoFavorito(
                catan);

        cliente.agregarJuegoFavorito(
                dixit);
        
        cliente.acumularPuntos(
                120000);
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
    	
    	JButton btnInicio =
    	        new JButton(
    	                "🏠 Inicio");
    	
        JButton btnCatalogo =
                new JButton("📚 Catalogo");

        JButton btnPrestamos =
                new JButton("📚 Prestamos");

        JButton btnCompra =
                new JButton("🛒 Compra");

        JButton btnTorneos =
                new JButton("🏆 Torneos");
        
        JButton btnFavoritos =
                new JButton("⭐ Favoritos");
 
        JButton btnPuntos =
                new JButton("Puntos");
        
        
        JLabel titulo =
                new JLabel(
                        "Dulces & Dados");

        titulo.setForeground(
        		new Color(
        		        223,
        		        230,
        		        233));

        titulo.setHorizontalAlignment(
                JLabel.CENTER);
        
        titulo.setFont(
                EstiloUI.TITULO);

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
        
        //INICIO
        
        btnInicio.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.setLayout(
                    new BorderLayout());

            contenidoPanel.add(

                new PanelHomeCliente(
                        cliente),

                BorderLayout.CENTER);

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });
        
        

        // =========================
        
        EstiloUI.boton(btnCatalogo);
        EstiloUI.boton(btnPrestamos);
        EstiloUI.boton(btnCompra);
        EstiloUI.boton(btnTorneos);
        EstiloUI.boton(btnFavoritos);
        EstiloUI.boton(btnPuntos);
        EstiloUI.boton(btnInicio);
        
        menuPanel.add(
                btnInicio);

        menuPanel.add(
                btnCatalogo);
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
                EstiloUI.FONDO);
        
        contenidoPanel.setLayout(
                new BorderLayout());

        contenidoPanel.add(
                new PanelHomeCliente(
                        cliente),
                BorderLayout.CENTER);
    }
    

}