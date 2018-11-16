package lab6.zad1.shapes;
import java.awt.*;
import java.awt.geom.Rectangle2D;


public class Prostokat extends Shape {
    private int a,b;
    private int x,y;
    private Rectangle2D.Float pros;
    public Prostokat(String s, int aa, int bb, int xx, int yy,Color c,boolean bo){
        super(s,c,bo);
        a = aa;
        b = bb;
        x = xx;
        y = yy;
    }
    public boolean contain(int xx, int yy){
        return pros.contains(xx,yy);
    }
    public void draw(Graphics g){
        pros = new Rectangle2D.Float(x,y,a,b);
        Graphics2D grap = (Graphics2D) g;
        grap.setColor(color);
        if (!fill) grap.draw(pros);
        else grap.fill(pros);
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public void setX(int d){x = d;}
    public void setY(int d){y = d;}
}
