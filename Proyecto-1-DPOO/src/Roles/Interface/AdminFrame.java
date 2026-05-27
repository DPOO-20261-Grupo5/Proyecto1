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
    private List<SolicitudCambioTurno> solicitudes;

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
        
        solicitudes =
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

        Juego monopoly =
                new Juego(
                        "Monopoly",
                        1935,
                        "Hasbro",
                        2,
                        6,
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
                        monopoly,
                        130000,
                        6);

        JuegoVenta j5 =
                new JuegoVenta(
                        dixit,
                        110000,
                        7);

        JuegoVenta j6 =
                new JuegoVenta(
                        exploding,
                        90000,
                        9);

        JuegoVenta j7 =
                new JuegoVenta(
                        risk,
                        175000,
                        3);
        
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
                        monopoly,
                        "Nuevo");

        CopiaJuego c5 =
                new CopiaJuego(
                        5,
                        dixit,
                        "Bueno");

        CopiaJuego c6 =
                new CopiaJuego(
                        6,
                        exploding,
                        "Desaparecido");

        CopiaJuego c7 =
                new CopiaJuego(
                        7,
                        risk,
                        "Nuevo");
        
        Turno turno1 =
                new Turno(
                        "Lunes",
                        java.time.LocalTime.of(8,0),
                        java.time.LocalTime.of(16,0));

        Turno turno2 =
                new Turno(
                        "Martes",
                        java.time.LocalTime.of(10,0),
                        java.time.LocalTime.of(18,0));

        SolicitudCambioTurno s1 =
                new SolicitudCambioTurno(
                        1,
                        admin,
                        turno1,
                        turno2,
                        "CAMBIO");

        solicitudes.add(
                s1);
        
        Turno turno3 =
                new Turno(
                        "Miercoles",
                        java.time.LocalTime.of(12,0),
                        java.time.LocalTime.of(20,0));

        SolicitudCambioTurno s2 =
                new SolicitudCambioTurno(
                        2,
                        admin,
                        turno2,
                        turno3,
                        "INTERCAMBIO");

        SolicitudCambioTurno s3 =
                new SolicitudCambioTurno(
                        3,
                        admin,
                        turno3,
                        turno1,
                        "CAMBIO");

        solicitudes.add(s2);
        solicitudes.add(s3);
        
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
        
        Torneo t3 =
                new Torneo(
                        3,
                        "Domingo",
                        "Amistoso",
                        10,
                        monopoly,
                        null);

        Torneo t4 =
                new Torneo(
                        4,
                        "Jueves",
                        "Competitivo",
                        8,
                        dixit,
                        null);

        Torneo t5 =
                new Torneo(
                        5,
                        "Lunes",
                        "Amistoso",
                        14,
                        risk,
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
        
        Venta v6 =
                new Venta(
                        6,
                        LocalDate.now().minusDays(4));

        v6.agregarItem(
                new ItemVenta(
                        new Bebida(
                                "Chocolate",
                                15000,
                                false,
                                true),
                        2,
                        15000));

        ventas.add(v6);
        
        Venta v7 =
                new Venta(
                        7,
                        LocalDate.now().minusDays(3));

        v7.agregarItem(
                new ItemVenta(
                        j4,
                        1,
                        j4.getPrecio()));

        ventas.add(v7);
        
        Venta v8 =
                new Venta(
                        8,
                        LocalDate.now().minusDays(2));

        v8.agregarItem(
                new ItemVenta(
                        new Pasteleria(
                                "Cheesecake",
                                14000),
                        3,
                        14000));

        ventas.add(v8);
        
        Venta v9 =
                new Venta(
                        9,
                        LocalDate.now().minusDays(1));

        v9.agregarItem(
                new ItemVenta(
                        j5,
                        2,
                        j5.getPrecio()));

        ventas.add(v9);
        
        Venta v10 =
                new Venta(
                        10,
                        LocalDate.now());

        v10.agregarItem(
                new ItemVenta(
                        new Bebida(
                                "Capuccino",
                                13000,
                                false,
                                true),
                        2,
                        13000));

        ventas.add(v10);
        
        Venta v11 =
                new Venta(
                        11,
                        LocalDate.now());

        v11.agregarItem(
                new ItemVenta(
                        j6,
                        1,
                        j6.getPrecio()));

        ventas.add(v11);
        
        Venta v12 =
                new Venta(
                        12,
                        LocalDate.now());

        v12.agregarItem(
                new ItemVenta(
                        new Pasteleria(
                                "Croissant",
                                10000),
                        4,
                        10000));

        ventas.add(v12);
        
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
        torneos.add(t3);
        torneos.add(t4);
        torneos.add(t5);
        
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
        
        inventarioPrestamo.agregarCopia(c3);
        inventarioPrestamo.agregarCopia(c4);
        inventarioPrestamo.agregarCopia(c5);
        inventarioPrestamo.agregarCopia(c6);
        inventarioPrestamo.agregarCopia(c7);
        
        inventarioVenta.agregarJuegoVenta(j3);
        inventarioVenta.agregarJuegoVenta(j4);
        inventarioVenta.agregarJuegoVenta(j5);
        inventarioVenta.agregarJuegoVenta(j6);
        inventarioVenta.agregarJuegoVenta(j7);
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
        		new Color(
        		        223,
        		        230,
        		        233));

        titulo.setHorizontalAlignment(
                JLabel.CENTER);
        
        titulo.setFont(
                EstiloUI.TITULO);

        menuPanel.add(titulo);
        
        JButton btnInicio =
                new JButton(
                        "🏠 Inicio");

        JButton btnInventarioVenta =
                new JButton(
                        "📦 Inventario Venta");

        JButton btnInventarioPrestamo =
                new JButton(
                        "📚 Inventario Prestamo");

        JButton btnTorneos =
                new JButton(
                        "🏆 Torneos");

        JButton btnSolicitudes =
                new JButton(
                        "📋 Solicitudes");

        JButton btnReportes =
                new JButton(
                        "📊 Reportes");
        
        JButton btnGraficas =
                new JButton(
                        "📈 Graficas");
        
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
        
        btnSolicitudes.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.add(
                    new PanelSolicitudesAdmin(
                            solicitudes));

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
        
        btnInicio.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.setLayout(
                    new BorderLayout());

            contenidoPanel.add(

                new PanelHomeAdmin(

                        ventas.size(),
                        torneos.size()),

                BorderLayout.CENTER);

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });

        EstiloUI.boton(
                btnInventarioVenta);

        EstiloUI.boton(
                btnInventarioPrestamo);

        EstiloUI.boton(
                btnTorneos);

        EstiloUI.boton(
                btnSolicitudes);

        EstiloUI.boton(
                btnReportes);
        
        EstiloUI.boton(
                btnGraficas);
        
        EstiloUI.boton(
                btnInicio);
        
        menuPanel.add(
                btnInicio);

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
                EstiloUI.FONDO);
        
        add(
            contenidoPanel,
            BorderLayout.CENTER);
        
        contenidoPanel.setLayout(
                new BorderLayout());

        contenidoPanel.add(

                new PanelHomeAdmin(

                        ventas.size(),
                        torneos.size()),

                BorderLayout.CENTER);
    }
}  
 

