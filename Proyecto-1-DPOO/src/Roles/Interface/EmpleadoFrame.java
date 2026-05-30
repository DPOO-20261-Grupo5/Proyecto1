package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Roles.Cliente;
import Roles.Mesero;
import BoardGame.*;

public class EmpleadoFrame extends JFrame {

    private JPanel menuPanel;
    private JPanel contenidoPanel;

    private Mesero empleado;
    private Cliente clienteEmpleado;

    private InventarioPrestamo inventarioPrestamo;
    private InventarioVenta inventarioVenta;
    private List<Torneo> torneos;
    private List<SolicitudCambioTurno> solicitudes;
    private List<Prestamo> prestamosEmpleado;
    private List<String> sugerencias;

    public EmpleadoFrame() {

        setTitle("Dulces & Dados - Empleado");
        setSize(1000,650);
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

        solicitudes =
                new ArrayList<>();
        
        prestamosEmpleado =
                new ArrayList<>();
        
        sugerencias =
                new ArrayList<>();

        Turno turno =
                new Turno(
                        "Lunes",
                        LocalTime.of(8,0),
                        LocalTime.of(16,0));
        
        Turno turnoNuevo =
                new Turno(
                        "Martes",
                        LocalTime.of(10,0),
                        LocalTime.of(18,0));

        SolicitudCambioTurno s1 =
                new SolicitudCambioTurno(
                        1,
                        empleado,
                        turno,
                        turnoNuevo,
                        "INTERCAMBIO");

        solicitudes.add(
                s1);

        empleado =
                new Mesero(
                        "Juan",
                        "001",
                        turno,
                        "juan",
                        "123");
        
        clienteEmpleado =
                new Cliente(
                        999,
                        empleado.getNombre(),
                        "empleado",
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
                        dixit,
                        110000,
                        7);

        JuegoVenta j4 =
                new JuegoVenta(
                        carcassonne,
                        150000,
                        4);

        inventarioVenta
                .agregarJuegoVenta(
                        j1);
    
        inventarioVenta
        		.agregarJuegoVenta(
        				j2);
        
        inventarioVenta
        		.agregarJuegoVenta(
        				j3);

        inventarioVenta
        		.agregarJuegoVenta(
        				j4);
    	
    

        CopiaJuego copia1 =
                new CopiaJuego(
                        1,
                        catan,
                        "Bueno");
        
        CopiaJuego copia2 =
                new CopiaJuego(
                        2,
                        uno,
                        "Nuevo");

        CopiaJuego copia3 =
                new CopiaJuego(
                        3,
                        dixit,
                        "Bueno");

        CopiaJuego copia4 =
                new CopiaJuego(
                        4,
                        carcassonne,
                        "Desaparecido");

        inventarioPrestamo
                .agregarCopia(
                        copia1);
        
        inventarioPrestamo
        		.agregarCopia(
        				copia2);

        inventarioPrestamo
        		.agregarCopia(
        				copia3);

        inventarioPrestamo
        		.agregarCopia(
        				copia4);

        Torneo torneo1 =
                new Torneo(
                        1,
                        "Viernes",
                        "Competitivo",
                        12,
                        catan,
                        null);
        
        Torneo torneo2 =
                new Torneo(
                        2,
                        "Sabado",
                        "Amistoso",
                        8,
                        uno,
                        null);

        Torneo torneo3 =
                new Torneo(
                        3,
                        "Domingo",
                        "Competitivo",
                        10,
                        dixit,
                        null);

        torneos.add(
                torneo1);
        
        torneos.add(
                torneo2);

        torneos.add(
                torneo3);
        
        Prestamo p1 =
                new Prestamo(
                        1,
                        java.time.LocalDate.now()
                        .minusDays(2),
                        copia1);

        prestamosEmpleado.add(
                p1);
        
        sugerencias.add(
                "Agregar mas juegos cooperativos");

        sugerencias.add(
                "Promocion cafe + juego");

        sugerencias.add(
                "Torneo mensual de Dixit");
    }

    private void construirMenu() {

        menuPanel =
                new JPanel();

        menuPanel.setLayout(
                new GridLayout(
                        10,
                        1,
                        10,
                        10));

        menuPanel.setPreferredSize(
                new Dimension(
                        220,
                        650));

        menuPanel.setBackground(
                new Color(
                        45,
                        52,
                        54));

        JLabel titulo =
                new JLabel(
                        "EMPLEADO");

        titulo.setForeground(
        		new Color(
        		        223,
        		        230,
        		        233));

        titulo.setHorizontalAlignment(
                JLabel.CENTER);
        
        titulo.setFont(
                EstiloUI.TITULO);

        menuPanel.add(
                titulo);
        
        JButton btnInicio =
                new JButton(
                        "🏠 Inicio");
        
        JButton btnTurno =
                new JButton(
                        "⏰ Mi Turno");

        JButton btnPrestamos =
                new JButton(
                        "🎲 Prestamos");

        JButton btnCompra =
                new JButton(
                        "🛒 Compra");

        JButton btnTorneos =
                new JButton(
                        "🏆 Torneos");

        JButton btnSugerencia =
                new JButton(
                        "💡 Sugerencias");
        
        btnTurno.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.add(

                new PanelTurnoEmpleado(
                        empleado,
                        solicitudes));

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });
        
        btnPrestamos.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.add(

                new PanelPrestamosEmpleado(
                        empleado,
                        inventarioPrestamo,
                        prestamosEmpleado));

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });
        
        btnCompra.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.add(

                new PanelCompraEmpleado(
                        empleado,
                        inventarioVenta));

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });
        
        btnTorneos.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.add(

                new PanelTorneosEmpleado(
                        clienteEmpleado,
                        torneos));

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });
        
        btnSugerencia.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.add(

                new PanelSugerenciaEmpleado(
                        sugerencias));

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });
        
        btnInicio.addActionListener(e -> {

            contenidoPanel.removeAll();

            contenidoPanel.setLayout(
                    new BorderLayout());

            contenidoPanel.add(

                new PanelHomeEmpleado(
                        empleado),

                BorderLayout.CENTER);

            contenidoPanel.revalidate();
            contenidoPanel.repaint();
        });

        EstiloUI.boton(btnTurno);
        EstiloUI.boton(btnPrestamos);
        EstiloUI.boton(btnCompra);
        EstiloUI.boton(btnTorneos);
        EstiloUI.boton(btnSugerencia);
        EstiloUI.boton(
                btnInicio);
        
        menuPanel.add(btnInicio);
        menuPanel.add(btnTurno);
        menuPanel.add(btnPrestamos);
        menuPanel.add(btnCompra);
        menuPanel.add(btnTorneos);
        menuPanel.add(btnSugerencia);

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

                new PanelHomeEmpleado(
                        empleado),

                BorderLayout.CENTER);
    }


}
