package Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import BoardGame.ReporteVentas;
import BoardGame.Venta;
import Roles.Administrador;

public class PanelReportes extends JPanel {

    public PanelReportes(
            Administrador admin,
            List<Venta> ventas) {

        setLayout(
                new BorderLayout());
        
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

        ReporteVentas reporte =
                admin.generarReporte(
                        ventas);

        JPanel centro =
                new JPanel(
                        new GridLayout(
                                4,
                                1,
                                20,
                                20));

        JLabel comida =
                new JLabel(

                    "Ventas comida: "
                    + reporte.getVentasComida(),

                    JLabel.CENTER);

        JLabel juegos =
                new JLabel(

                    "Ventas juegos: "
                    + reporte.getVentasJuegos(),

                    JLabel.CENTER);

        JLabel impuestos =
                new JLabel(

                    "Impuestos: "
                    + reporte.getImpuestosTotales(),

                    JLabel.CENTER);

        JLabel propinas =
                new JLabel(

                    "Propinas: "
                    + reporte.getPropinasTotales(),

                    JLabel.CENTER);

        Font fuente =
                new Font(
                        "Arial",
                        Font.BOLD,
                        22);

        comida.setFont(
                fuente);

        juegos.setFont(
                fuente);

        impuestos.setFont(
                fuente);

        propinas.setFont(
                fuente);

        centro.add(
                comida);

        centro.add(
                juegos);

        centro.add(
                impuestos);

        centro.add(
                propinas);

        add(
            centro,
            BorderLayout.CENTER);
    }
}