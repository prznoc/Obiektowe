package lab6.zad1.shapes;
import java.awt.*;
import java.awt.geom.*;

public class Kolo extends Shape {
    private int r;
    private int x,y;
    private Ellipse2D kolo;
    public Kolo(String s, int rr, int xx, int yy, Color c, boolean bo){
        super(s,c,bo);
        r = rr;
        x = xx;
        y = yy;
    }
    public boolean contain(int xx, int yy){
        return kolo.contains(xx,yy);
    }
    public void draw(Graphics g){
        kolo = new Ellipse2D.Float(x,y,r*2,r*2);
        Graphics2D grap = (Graphics2D) g;
        grap.setColor(color);
        if (!fill) grap.draw(kolo);
        else grap.fill(kolo);
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public void setX(int d){x = d;}
    public void setY(int d){y = d;}
}
