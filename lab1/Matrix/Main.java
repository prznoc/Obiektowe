import java.io.*;
public class Main {
	public static void main(String [] argv){
		double[] a1 = {3,5,7};
		double[] a2 = {2,3,4};
		double[] a3 = {7,3,4};
		double [][] tablica = {a1,a2,a3};
		double [][] tablica2 = {a3,a1,a2};
		Matrix m1 = new Matrix(tablica);
		Matrix m2 = new Matrix(tablica2);
		Matrix m3 = m1.mul(m2);
		for (int i = 0; i < m3.row; i++){
            for (int j = 0; j < m3.col; j++){
                    System.out.print(m3.data[i][j]+" ");
			}
			System.out.println();
		}
	}
}


