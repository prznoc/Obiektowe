package lab6.zad1.rysownik;
import lab6.zad1.shapes.*;

import java.util.LinkedList;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;

public class MyPanel extends java.awt.Panel implements MouseListener, MouseMotionListener   {
    private static LinkedList<Shape> obiekty;
    private int x,y;
    private Shape temp = null;
    public MyPanel(){
        obiekty = new LinkedList<>();
        obiekty.add(new Kolo("kolo",50,32,123,Color.red,true));
        obiekty.add(new Trojkat("troj",20,10,60,55,125,55,Color.blue,true));
        obiekty.add(new Kwadrat("kwad",50,50,60,Color.green,true));
        obiekty.add(new Prostokat("pros", 30,70,215,330,Color.cyan,true));
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void add(Shape sh){
        obiekty.add(sh);
    }
    public void paint(Graphics g) {
        super.paint(g);
        for (Shape sh: obiekty){
            sh.draw(g);
        }
    }
    public void mousePressed(MouseEvent e){
        x = e.getX();
        y = e.getY();
        for (int i =0; i<obiekty.size();++i){
            if (obiekty.get(i).contain(x,y)) {
                temp = obiekty.get(i);
                obiekty.remove(obiekty.get(i));
                obiekty.add(obiekty.size(),temp);
            }
        }
    }
    public void mouseDragged(MouseEvent e){
        if(temp != null) {
            int dx = e.getX() - x;
            int dy = e.getY() - y;
            temp.setX(temp.getX() + dx);
            temp.setY(temp.getY() + dy);
            x += dx;
            y += dy;
            repaint();
        }
    }
    public void mouseReleased(MouseEvent e){
        temp = null;
    }
    public void mouseClicked(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }
    public void mouseMoved(MouseEvent e){
    }


}
