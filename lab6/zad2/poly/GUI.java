package lab6.zad2.poly;
import lab6.zad1.rysownik.MyFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI implements ActionListener{
    private JFrame ramka;
    private JButton button;
    private JTextField text1, text2, text3;

    public void start() {
        ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(400, 200);
        button = new JButton();
        button.setText("Pokaż wykres");
        button.addActionListener(this);
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(1,1));
        jp.add(button);
        JPanel jp2 = new JPanel();
        jp2.setLayout(new GridLayout(4,1));
        text1 = new JTextField("Tutaj wpisujesz współczynniki wielomianów (postać np: '2,3,5,6')");
        text2 = new JTextField("Tutaj wpisujesz zakres osi X( np.'-10-10)");
        text3 = new JTextField("Tutaj wpisz częstotliwość próbkowania");
        jp2.add(text1);
        jp2.add(text2);
        jp2.add(text3);
        jp2.add(jp);
        ramka.add(jp2);
        ramka.setVisible(true);
    }


    public void actionPerformed(ActionEvent akcja) {
        if (akcja.getSource() == button){
            try {
                String str1, str2, str3;
                str1 = text1.getText();
                str2 = text2.getText();
                str3 = text3.getText();
                String[] s1 = str1.split(",");
                String[] s2 = str2.split(",");
                if (s2.length != 2) throw new UnsupportedOperationException();
                int[] wspol = new int[s1.length];
                int[] zakres = new int[2];
                for (int i = s1.length; i>0; --i){
                    wspol[i-1] = Integer.parseInt(s1[s1.length - i]);
                }
                for (int i = 0; i<2; ++i){
                    zakres[i] = Integer.parseInt(s2[i]);
                }
                double hz = Double.parseDouble(str3);
                MyFrame frame = new MyFrame(1550, 850);
                Poly poly = new Poly(wspol, zakres, hz);
                frame.add(poly);
                frame.setVisible(true);
            }
            catch(Exception e){
                System.err.println("Something went wrong");
            }
        }
        else
            return;

    }

}