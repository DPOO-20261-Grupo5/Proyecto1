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

        JuegoVenta j1 =
                new JuegoVenta(
                        catan,
                        180000,
                        5);

        inventarioVenta
                .agregarJuegoVenta(
                        j1);

        CopiaJuego copia1 =
                new CopiaJuego(
                        1,
                        catan,
                        "Bueno");

        inventarioPrestamo
                .agregarCopia(
                        copia1);

        Torneo torneo1 =
                new Torneo(
                        1,
                        "Viernes",
                        "Competitivo",
                        12,
                        catan,
                        null);

        torneos.add(
                torneo1);
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
