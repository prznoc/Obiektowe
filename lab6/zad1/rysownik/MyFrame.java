package lab6.zad1.rysownik;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
    public MyFrame(int width, int height){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width,height);
        this.setLocationByPlatform(true);
    }
}
