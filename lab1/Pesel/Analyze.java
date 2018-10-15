import java.io.*;
public class Analyze {
	public static void main(String [] argv){
		String pesel = "73021398765";	
		System.out.println(Pesel.Check(pesel));
	}
}


class Pesel{
	public static boolean Check(String numer){
		if (numer.length() > 11) return false;
		int a;
		int[] digits = new int[11];
		String string[] = numer.split("\\B");
		for (int i = 0; i<11; ++i){
			try{
				a = Integer.parseInt(string[i]);
				digits[i] = a;
			}
			catch(Exception e) {return false;}
		}
		int suma = 9*digits[0]+7*digits[1]+3*digits[2]+digits[3]+9*digits[4]+7*digits[5]+3*digits[6]+digits[7]+9*digits[8]+7*digits[9];
		if (suma %10 == digits[10]) return true;
		return false;
	}
}
