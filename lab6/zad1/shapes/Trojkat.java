package lab6.zad1.shapes;
import java.awt.*;


public class Trojkat extends Shape {
    private int x1,y1,x2,y2,x3,y3;  //wspolrzedne punktow 1,2,3
    private Polygon troj;
    public Trojkat(String s, int a, int b, int c, int d, int e, int f,Color col,boolean bo){
        super(s,col,bo);
        x1 = a;
        y1 = b;
        x2 = c;
        y2 = d;
        x3 = e;
        y3 = f;
    }
    public boolean contain(int xx, int yy){
        return troj.contains(xx,yy);
    }
    public void draw(Graphics g){
        troj = new Polygon ();
        troj.addPoint(x1,y1);
        troj.addPoint(x2,y2);
        troj.addPoint(x3,y3);
        Graphics2D grap = (Graphics2D) g;
        grap.setColor(color);
        if (!fill) grap.draw(troj);
        else grap.fill(troj);
    }
    public int getX(){return x1;}
    public int getY(){return y1;}
    public void setX(int d){
        x1 = d;
        x2 = x2 - x1 + d;
        x3 = x3 - x1 +d;
    }
    public void setY(int d){
        y1 = d;
        y2 = y2 - y1 + d;
        y3 = y3 - y1 + d;
    }
}
