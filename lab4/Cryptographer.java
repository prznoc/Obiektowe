package lab4;
import java.io.*;
import java.util.*;
public class Cryptographer {
    public static void cryptfile(File to_decode, File code, Algorithm alg) {
        try {
            Scanner in = new Scanner(to_decode);
			FileWriter out = new FileWriter(code);
            while (in.hasNextLine()) {
                Scanner in2 = new Scanner(in.nextLine());
                while (in2.hasNext()) {
                    String s = in2.next();
                    String s2 = alg.crypt(s);
					out.write(s2);
                }
				out.write("\n");
            }
			in.close();
			out.close();
        }
        catch (Exception e){
			 e.printStackTrace();
		}
    }
    public static void decryptfile(File code, File result, Algorithm alg){
		try {
            Scanner in = new Scanner(code);
			FileWriter out = new FileWriter(result);
            while (in.hasNextLine()) {
                Scanner in2 = new Scanner(in.nextLine());
                while (in2.hasNext()) {
                    String s = in2.next();
                    String s2 = alg.decrypt(s);
					out.write(s2);
                }
				out.write("\n");
            }
			in.close();
			out.close();
        }
        catch (Exception e){
			 e.printStackTrace();
		}
    }
}



