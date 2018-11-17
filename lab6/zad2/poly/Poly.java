package lab6.zad2.poly;
import java.awt.*;
import javax.swing.*;

public class Poly extends JPanel {
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;
    private double x_axis[];
    private double y_axis[];
    private final int gap = 50;
    Poly(int wspol[], int zakres[], double hz) {
        if ((zakres[0] >= zakres[1]) || hz < 0) throw new UnsupportedOperationException("Wrong boundaries");
        else {
            xMin = zakres[0];
            double si = (zakres[1] - zakres[0]) / hz + 1;
            int size = (int) si;
            x_axis = new double[size];
            y_axis = new double[size];
            xMax = (int) (zakres[0] + ((size - 1) * hz));
            boolean flag;
            for (int i = 0; i < size; ++i) {
                if (i == 0) flag = true;
                else flag = false;
                x_axis[i] = zakres[0] + i * hz;
                y_axis[i] = value(x_axis[i], wspol, flag);
            }
        }

    }

    private double value(double x, int wspol[], boolean flag) {
        double result = 0;
        for (int i = 0; i < wspol.length; ++i) {
            result += wspol[i] * Math.pow(x, i);
        }
        if (flag) {
            yMin = yMax = (int)result;
        } else {
            if (result < yMin) yMin = (int)result;
            if (result > yMax) yMax = (int)result;
        }
        return result;
    }

    public void paint(Graphics g) {
        this.paintComponent(g);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        int dimX = this.getWidth() - gap*2;
        int dimY = this.getHeight() - gap*2;
        setBackground(Color.WHITE);
        g.setColor(Color.RED);
        int x1 , y1, x2 , y2;
        for (int i = 1; i < x_axis.length; ++i) {
            x1 =  (int) (((x_axis[i - 1]-xMin)*dimX)/(xMax-xMin) + gap);
            x2 =  (int) (((x_axis[i]-xMin)*dimX)/(xMax-xMin) + gap);
            y1 = dimY - (int) (((y_axis[i - 1]-yMin)*dimY)/(yMax-yMin) - gap);
            y2 = dimY - (int) (((y_axis[i]-yMin)*dimY)/(yMax-yMin) - gap);
            g.drawLine(x1, y1, x2, y2);
        }
        g.setColor(Color.BLACK);
        g2.drawLine(gap, getHeight() - gap, gap, gap);
        g2.drawLine(gap, getHeight() - gap, getWidth() - gap, getHeight() - gap);
        int y_step = (this.getHeight() - 2*gap) /20;
        int x_step = (this.getWidth()- 2*gap) / 20;
        double var;
        String var_;
        double y_dif = (yMax-yMin)/20;
        double x_dif = (xMax-xMin)/20;
        for (int i = 0; i <= 20; ++i) {
            var = yMin + i*y_dif;
            var_ =  Double.toString(var);
            int x0 = gap;
            int x00 = gap + 15;
            int y0 = getHeight() - gap - (i*y_step);
            g2.drawLine(x0, y0, x00, y0);
            g2.drawString(var_, gap - 45, y0);
        }
        for (int i = 0; i <= 20; ++i) {
            var = xMin + i*x_dif;
            var_ =  Double.toString(var);
            int x0 =  gap + (i*x_step);
            int y0 = getHeight() - gap;
            int y00 = getHeight() - gap - 15;
            g2.drawLine(x0, y0, x0, y00);
            g2.drawString(var_, x0 - 10, getHeight() - gap + 35);
        }
    }
        public void test_display(){
            for (int i = 0; i < x_axis.length; ++i) {
                System.out.println(x_axis[i] + " " + y_axis[i]);
            }
            System.out.println(yMin);
            System.out.println(yMax);
        }
    }
