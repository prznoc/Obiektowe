package lab6.zad2.main;
import lab6.zad2.poly.*;
import lab6.zad1.rysownik.MyFrame;

public class Main {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame(1550, 850);
        int[] wspol = {4,3,2,1}; // tablica wspolczynnikow, wspak. wspol[0] to wyraz wolny.
        int [] zakres = new int[2];
        zakres[0] = -10;
        zakres[1] = 10;
        double hz = 0.1;
        Poly poly = new Poly(wspol, zakres, hz);
        frame.add(poly);
        frame.setVisible(true);
    }
}
