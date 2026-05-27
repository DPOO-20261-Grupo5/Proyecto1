package Interface;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import BoardGame.Torneo;

public class PanelGraficaLineas extends JPanel {

    public PanelGraficaLineas(
            List<Torneo> torneos) {

        setLayout(
                new BorderLayout());
        
        EstiloUI.panel(
                this);

        DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        for(Torneo t :
                torneos) {

            dataset.addValue(

                t.getTotalCuposOcupados(),

                "Reservas",

                t.getFecha());
        }

        JFreeChart chart =
                ChartFactory
                .createLineChart(

                    "Reservas Torneos",

                    "Fecha",

                    "Inscritos",

                    dataset);

        ChartPanel panel =
                new ChartPanel(
                        chart);

        add(
            panel,
            BorderLayout.CENTER);
    }
}