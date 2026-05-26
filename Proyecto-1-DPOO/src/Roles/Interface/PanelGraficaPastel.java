package Interface;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import BoardGame.CopiaJuego;
import BoardGame.InventarioPrestamo;
import BoardGame.InventarioVenta;

public class PanelGraficaPastel extends JPanel {

    public PanelGraficaPastel(

            InventarioPrestamo inventarioPrestamo,
            InventarioVenta inventarioVenta,
            String nombreJuego) {

        setLayout(
                new BorderLayout());

        int venta = 0;
        int prestamo = 0;

        // venta

        if(inventarioVenta
                .buscarJuego(
                        nombreJuego)
                != null){

            venta =
                    inventarioVenta
                    .buscarJuego(
                            nombreJuego)
                    .getStockDisponible();
        }

        // prestamo

        for(CopiaJuego c :
                inventarioPrestamo
                .getCopias()) {

            if(c.getJuego()
                    .getNombre()
                    .equalsIgnoreCase(
                            nombreJuego)) {

                prestamo++;
            }
        }

        DefaultPieDataset dataset =
                new DefaultPieDataset();

        dataset.setValue(
                "Venta",
                venta);

        dataset.setValue(
                "Prestamo",
                prestamo);

        JFreeChart chart =
                ChartFactory
                .createPieChart(

                    "Distribucion " + nombreJuego,

                    dataset,

                    true,
                    true,
                    false);

        ChartPanel panel =
                new ChartPanel(
                        chart);

        add(
            panel,
            BorderLayout.CENTER);
    }
}
