package lab7.zad1;

public class Poly{
    public double xMin;    //podany zakres
    public double xMax;
    public double yMin;
    public double yMax;
    public double[] x_axis;
    public double[] y_axis;

    public Poly(int[] wspol, double[] zakres, double hz) {
        if ((zakres[0] >= zakres[1]) || hz < 0) throw new UnsupportedOperationException("Wrong boundaries");
        else {
            xMin = zakres[0];
            double si = (zakres[1] - zakres[0]) / hz + 1;
            int size = (int) si;
            x_axis = new double[size];
            y_axis = new double[size];
            xMax = (int) (zakres[0] + ((size - 1) * hz));
            for (int i = 0; i < size; ++i) {
                x_axis[i] = zakres[0] + i * hz;
                y_axis[i] = value(x_axis[i], wspol, i);
            }
            if (yMin == yMax) {
                yMin -= 0.5;
                yMax += 0.5;
            }
            if (yMax - yMin >= 20) {   //Dla estetyki wykresu
                yMin = Math.floor(yMin);
                yMax = Math.ceil(yMax);
            }
        }

    }

    private double value(double x, int[] wspol, int flag) {
        double result = 0;
        for (int i = 0; i < wspol.length; ++i) {
            result += wspol[i] * Math.pow(x, i);
        }
        if (flag == 0) {
            yMin = yMax = result;
        } else {
            if (result < yMin) yMin = result;
            if (result > yMax) yMax = result;
        }
        return result;
    }

    public void test_display(){
        System.out.println("x   y");
        for (int i = 0; i < x_axis.length; ++i) {
            System.out.println(x_axis[i] + " " + y_axis[i]);
        }
        System.out.println(yMin);
        System.out.println(yMax);
    }
}