package lab6.zad2_v2.poly;
import lab7.zad1.Poly;

import java.awt.*;
import javax.swing.*;

public class DrawPoly extends JPanel{
    private Poly p;
    private final int gap = 50;

    public DrawPoly(Poly poly) {
        p = poly;
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
        for (int i = 1; i < p.x_axis.length; ++i) {
            x1 =  (int) (((p.x_axis[i - 1]-p.xMin)*dimX)/(p.xMax-p.xMin) + gap);
            x2 =  (int) (((p.x_axis[i]-p.xMin)*dimX)/(p.xMax-p.xMin) + gap);
            y1 = dimY - (int) (((p.y_axis[i - 1]-p.yMin)*dimY)/(p.yMax-p.yMin) - gap);
            y2 = dimY - (int) (((p.y_axis[i]-p.yMin)*dimY)/(p.yMax-p.yMin) - gap);
            g.drawLine(x1, y1, x2, y2);
        }
        g.setColor(Color.BLACK);
        g2.drawLine(gap, getHeight() - gap, gap, gap);
        g2.drawLine(gap, getHeight() - gap, getWidth() - gap, getHeight() - gap);
        double y_step = (this.getHeight() - 2*gap) /20.0;
        double x_step = (this.getWidth()- 2*gap) / 20.0;
        double var;
        double _var;
        String var_;
        double y_dif = (p.yMax-p.yMin)/20.0;
        double x_dif = (p.xMax-p.xMin)/20.0;
        for (int i = 0; i <= 20; ++i) {
            var = p.yMin + i*y_dif;
            _var = (double) Math.round(var * 100d)/100d;
            var_ =  Double.toString(_var);
            int x00 = gap + 15;
            int y0 = (int) (getHeight() - gap - (i*y_step));
            g2.drawLine(gap, y0, x00, y0);
            g2.drawString(var_, gap - 45, y0);
        }
        for (int i = 0; i <= 20; ++i) {
            var = p.xMin + i*x_dif;
            _var = (double) Math.round(var * 100d)/100d;
            var_ =  Double.toString(_var);
            int x0 =  (int)(gap + (i*x_step));
            int y0 = getHeight() - gap;
            int y00 = getHeight() - gap - 15;
            g2.drawLine(x0, y0, x0, y00);
            g2.drawString(var_, x0 - 10, getHeight() - gap + 35);
        }
    }
}
