package Interface;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

    public LoginFrame() {

        setTitle(
                "Dulces & Dados");

        setSize(
                450,
                300);

        setDefaultCloseOperation(
                EXIT_ON_CLOSE);

        setLocationRelativeTo(
                null);

        setLayout(
                new BorderLayout());

        construir();
        
        getContentPane()
        .setBackground(
                Color.WHITE);

        setVisible(
                true);
    }

    private void construir() {

        JPanel centro =
                new JPanel(
                        new GridLayout(
                                5,
                                2,
                                10,
                                10));
        
        EstiloUI.panel(
                centro);

        JLabel logo =
                new JLabel(
                        new ImageIcon(
                                "src/Roles/imagenes/dado.png"));

        logo.setHorizontalAlignment(
                JLabel.CENTER);

        JLabel titulo =
                new JLabel(
                        "DULCES & DADOS",
                        JLabel.CENTER);

        titulo.setFont(
                EstiloUI.TITULO);

        titulo.setForeground(
                new Color(
                        45,
                        52,
                        54));

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        titulo.setForeground(
                new Color(
                        45,
                        52,
                        54));

        JTextField txtUsuario =
                new JTextField();

        JPasswordField txtPass =
                new JPasswordField();

        JButton ingresar =
                new JButton(
                        "Ingresar");
        
        EstiloUI.boton(
                ingresar);

        centro.add(
                new JLabel(
                        "Usuario"));

        centro.add(
                txtUsuario);

        centro.add(
                new JLabel(
                        "Contraseña"));

        centro.add(
                txtPass);

        JPanel arriba =
                new JPanel(
                        new BorderLayout());

        arriba.setBackground(
                EstiloUI.FONDO);

        arriba.add(
                logo,
                BorderLayout.CENTER);

        arriba.add(
                titulo,
                BorderLayout.SOUTH);

        add(
            arriba,
            BorderLayout.NORTH);

        add(
            centro,
            BorderLayout.CENTER);

        add(
            ingresar,
            BorderLayout.SOUTH);

        ingresar.addActionListener(e -> {

            String usuario =
                    txtUsuario
                    .getText();

            String pass =
                    new String(
                            txtPass
                            .getPassword());

            // ADMIN

            if(usuario.equals(
                    "admin")

                    &&

                    pass.equals(
                            "123")) {

                dispose();

                new BienvenidaFrame(

                        "Bienvenido Admin",

                        () -> new AdminFrame());
            }

            // EMPLEADO

            else if(usuario.equals(
                    "juan")

                    &&

                    pass.equals(
                            "123")) {

                dispose();

                new BienvenidaFrame(

                        "Bienvenido Juan",

                        () -> new EmpleadoFrame());
            }

            // CLIENTE

            else if(usuario.equals(
                    "laura")

                    &&

                    pass.equals(
                            "123")) {

                dispose();

                new BienvenidaFrame(

                        "Bienvenida Laura",

                        () -> new ClienteFrame());
            }

            else {

                JOptionPane
                .showMessageDialog(

                        this,

                        "Credenciales invalidas");
            }
        });
    }
}
