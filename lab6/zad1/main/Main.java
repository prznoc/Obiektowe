package lab6.zad1.main;
import lab6.zad1.rysownik.*;
import java.awt.Color;


public class Main {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame(500, 500);
        MyPanel rysunki = new MyPanel();
        frame.getContentPane().add(rysunki);
        frame.setVisible(true);
    }
}
