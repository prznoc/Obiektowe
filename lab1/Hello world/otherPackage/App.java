package otherPackage;
import java.io.*;
public class App{
	public static String getString(){
		String text = null;
		try{
			InputStreamReader rd = new InputStreamReader(System.in);
			BufferedReader bfr = new BufferedReader(rd);
			text = bfr.readLine();
		}
		catch (IOException e){e.printStackTrace();}
		return text;
	}
	public void Start(String[] args){
		if(number<1 || width < 0.1 || width > 0.5 || distance <10 || distance >30) return -1;
		else if(number == 1) return 0;
		else return ((number-1)*separat+(number-2)*width);
	}
}


