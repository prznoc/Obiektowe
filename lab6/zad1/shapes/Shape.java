package lab6.zad1.shapes;
import java.awt.*;


public abstract class Shape {
    Color color;
    String name;
    boolean fill;
    public abstract void draw(Graphics g);
    Shape(String s, Color c, boolean bo){
        name = s;
        color = c;
        fill = bo;
    }
    public abstract boolean contain(int xx,int yy);
    public abstract void setX(int d);
    public abstract void setY(int d);
    public abstract int getX();
    public abstract int getY();
}

