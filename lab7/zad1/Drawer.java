package lab7.zad1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Drawer extends Application {
    final private Poly poly;
    public Drawer(Poly p){poly = p;}
    public void start(Stage stage) {
        stage.setTitle("Polynominal");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Polynominal");
        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i<poly.x_axis.length; ++i){
            series.getData().add(new XYChart.Data(poly.x_axis[i],poly.y_axis[i]));
        }
        lineChart.setCreateSymbols(false);
        Scene scene = new Scene(lineChart, 1500, 800);
        lineChart.getData().add(series);
        stage.setScene(scene);
        stage.show();
    }
}

