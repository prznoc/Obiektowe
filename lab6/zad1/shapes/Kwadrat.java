package lab6.zad1.shapes;
import java.awt.*;
import java.awt.geom.*;

public class Kwadrat extends Shape {
    private int a;
    private int x,y;
    private Rectangle2D.Float kwad;
    public Kwadrat(String s, int bok, int xx, int yy,Color c,boolean bo){
        super(s,c,bo);
        a = bok;
        x = xx;
        y = yy;
    }
    public boolean contain(int xx, int yy){
        return kwad.contains(xx,yy);
    }
    public void draw(Graphics g) {
        kwad = new Rectangle2D.Float(x,y,a,a);
        Graphics2D grap = (Graphics2D) g;
        grap.setColor(color);
        if (!fill) grap.draw(kwad);
        else grap.fill(kwad);
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public void setX(int d){x = d;}
    public void setY(int d){y = d;}
}

