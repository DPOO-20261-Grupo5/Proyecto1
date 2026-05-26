package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import BoardGame.*;
import BoardGame.InventarioVenta;
import Roles.Administrador;
import Roles.Cliente;

import java.time.LocalDate;

public class AdminFrame extends JFrame {

    private JPanel menuPanel;
    private JPanel contenidoPanel;
    private InventarioVenta inventarioVenta;
    private InventarioPrestamo inventarioPrestamo;
    private List<Torneo> torneos;
    private List<Venta> ventas;
    private Administrador admin;

    public AdminFrame() {

        setTitle("Dulces & Dados - Admin");
        setSize(1100,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        crearDatosDemo();
        construirMenu();
        construirContenido();

        setVisible(true);
    }
    
    private void crearDatosDemo() {
    	
    	admin =
    	        new Administrador(
    	                "Admin",
    	                "001",
    	                null,
    	                "admin",
    	                "123");

        inventarioVenta =
                new InventarioVenta();
        
        inventarioPrestamo =
                new InventarioPrestamo();
        
        torneos =
                new ArrayList<>();
        
        ventas =
                new ArrayList<>();

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
        
        Torneo t1 =
                new Torneo(
                        1,
                        "Viernes",
                        "Amistoso",
                        12,
                        catan,
                        null);

        Torneo t2 =
                new Torneo(
                        2,
                        "Sabado",
                        "Competitivo",
                        8,
                        uno,
                        null);
        
        Venta v1 =
                new Venta(
                        1,
                        LocalDate.now().minusDays(4));

        v1.agregarItem(
                new ItemVenta(
                        j1,
                        1,
                        j1.getPrecio()));

        ventas.add(v1);

        Venta v2 =
                new Venta(
                        2,
                        LocalDate.now().minusDays(3));

        v2.agregarItem(
                new ItemVenta(
                        new Bebida(
                                "Cafe",
                                12000,
                                false,
                                true),
                        1,
                        12000));

        ventas.add(v2);

        Venta v3 =
                new Venta(
                        3,
                        LocalDate.now().minusDays(2));

        v3.agregarItem(
                new ItemVenta(
                        j2,
                        2,
                        j2.getPrecio()));

        ventas.add(v3);

        Venta v4 =
                new Venta(
                        4,
                        LocalDate.now().minusDays(1));

        v4.agregarItem(
                new ItemVenta(
                        new Pasteleria(
                                "Brownie",
                                9000),
                        2,
                        9000));

        ventas.add(v4);

        Venta v5 =
                new Venta(
                        5,
                        LocalDate.now());

        v5.agregarItem(
                new ItemVenta(
                        j1,
                        1,
                        j1.getPrecio()));

        ventas.add(v5);
        
        Cliente cliente1 =
                new Cliente(
                        1,
                        "Laura",
                        "laura",
                        "123");

        Cliente cliente2 =
                new Cliente(
                        2,
                        "Juan",
                        "juan",
                        "123");

        try {

        	t1.inscribir(
        	        cliente1,
        	        2);

        	t1.inscribir(
        	        cliente2,
        	        1);

        	t2.inscribir(
        	        cliente1,
        	        1);
        }

        catch(Exception e){

        }



        torneos.add(t1);
        torneos.add(t2);

        inventarioPrestamo
                .agregarCopia(c1);

        inventarioPrestamo
                .agregarCopia(c2);

        inventarioVenta
                .agregarJuegoVenta(
                        j1);

        inventarioVenta
                .agregarJuegoVenta(
                        j2);
    }

    private void construirMenu() {

        menuPanel = new JPanel();

        menuPanel.setLayout(
                new GridLayout(
                        10,
                        1,
                        10,
                        10));

        menuPanel.setPreferredSize(
                new Dimension(
                        220,
                        700));

        menuPanel.setBackground(
                new Color(
                        45,
                        52,
                        54));

        JLabel titulo =
                new JLabel(
                        "ADMIN");

        titulo.setForeground(
                Color.WHITE);

        titulo.setHorizontalAlignment(
                JLabel.CENTER);

        menuPanel.add(titulo);

        JButton btnInventarioVenta =
                new JButton(
                        "Inventario Venta");

        JButton btnInventarioPrestamo =
                new JButton(
                        "Inventario Prestamo");

        JButton btnTorneos =
                new JButton(
                        "Torneos");

        JButton btnSolicitudes =
                new JButton(
                        "Solicitudes");

        JButton btnReportes =
                new JButton(
                        "Reportes");
        
        JButton btnGraficas =
                new JButton(
                        "Graficas");
        
        btnInventarioVenta.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.add(
                    new PanelInventarioVenta(
                            inventarioVenta));

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });
        
        btnInventarioPrestamo.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.add(
                    new PanelInventarioPrestamo(
                            inventarioPrestamo));

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });
        
        btnTorneos.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.add(
                    new PanelTorneosAdmin(
                            torneos,
                            inventarioVenta));

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });
        
        btnReportes.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.add(
                    new PanelReportes(
                            admin,
                            ventas));

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });
        
        btnGraficas.addActionListener(e -> {

            contenidoPanel.removeAll();

            JPanel panel =
                    new JPanel();

            JButton pastel =
                    new JButton(
                            "Pastel");

            JButton barras =
                    new JButton(
                            "Barras");
            
            JButton lineas =
                    new JButton(
                            "Lineas");

            pastel.addActionListener(ev -> {

                contenidoPanel.removeAll();

                contenidoPanel.add(

                    new PanelGraficaPastel(

                            inventarioPrestamo,
                            inventarioVenta,
                            "Catan"));

                contenidoPanel.revalidate();
                contenidoPanel.repaint();
            });

            barras.addActionListener(ev -> {

                contenidoPanel.removeAll();

                contenidoPanel.add(
                        new PanelGraficaBarras(
                                ventas));

                contenidoPanel.revalidate();
                contenidoPanel.repaint();
            });
            
            lineas.addActionListener(ev -> {

                contenidoPanel.removeAll();

                contenidoPanel.add(
                        new PanelGraficaLineas(
                                torneos));

                contenidoPanel.revalidate();
                contenidoPanel.repaint();
            });

            panel.add(pastel);
            panel.add(barras);
            panel.add(lineas);

            contenidoPanel.add(panel);

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });

        estilizarBoton(
                btnInventarioVenta);

        estilizarBoton(
                btnInventarioPrestamo);

        estilizarBoton(
                btnTorneos);

        estilizarBoton(
                btnSolicitudes);

        estilizarBoton(
                btnReportes);
        
        estilizarBoton(
                btnGraficas);

        menuPanel.add(
                btnInventarioVenta);

        menuPanel.add(
                btnInventarioPrestamo);

        menuPanel.add(
                btnTorneos);

        menuPanel.add(
                btnSolicitudes);

        menuPanel.add(
                btnReportes);
        
        menuPanel.add(
                btnGraficas);

        add(
            menuPanel,
            BorderLayout.WEST);
    }

    private void construirContenido() {

        contenidoPanel =
                new JPanel();

        contenidoPanel.setBackground(
                Color.WHITE);

        add(
            contenidoPanel,
            BorderLayout.CENTER);
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
    }
}