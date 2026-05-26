package Interface;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import BoardGame.*;

public class PanelGraficaBarras extends JPanel {

    public PanelGraficaBarras(
            List<Venta> ventas) {

        setLayout(
                new BorderLayout());

        DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        for(Venta v :
                ventas) {

            double juegos = 0;
            double cafeteria = 0;

            for(ItemVenta item :
                    v.getItems()) {

                Producto p =
                        item.getProducto();

                double subtotal =
                        item.calcularSubtotal();

                double sinIVA =
                        subtotal / 1.19;

                if(p instanceof JuegoVenta){

                    juegos += sinIVA;
                }

                else{

                    cafeteria += sinIVA;
                }
            }

            String dia =
                    v.getFecha()
                    .toString();

            dataset.addValue(
                    juegos,
                    "Juegos",
                    dia);

            dataset.addValue(
                    cafeteria,
                    "Cafeteria",
                    dia);
        }

        JFreeChart chart =
                ChartFactory
                .createBarChart(

                    "Ventas Juegos vs Cafeteria",

                    "Fecha",

                    "Ventas sin IVA",

                    dataset);

        ChartPanel panel =
                new ChartPanel(
                        chart);

        add(
            panel,
            BorderLayout.CENTER);
    }
}