package lab4;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args){
        File read = new File(args[0]);
        File write = new File(args[1]);
		String command = "";
		boolean flag = true;
		int cipher_flag = 0;
		int decision_flag = 0;
		boolean break_flag = false;
		System.out.println("Avaliable ciphers:\n1: ROT11\n2: polibiusz");
		while (flag == true){
			System.out.print("Choose cipher:");
			Scanner get = new Scanner(System.in);
	    	command = get.nextLine();	
			switch (command){
				case "1" : cipher_flag = 1 ; flag = false; break;
				case "2":cipher_flag = 2; flag = false; break;
				case "exit":flag = false; break_flag = true; break;
				default: System.out.println("Unknown command, try again");
			}
		}
		flag = true;
		if (break_flag == false )System.out.println("Avaliable options:\n1: crypt\n2: decrypt");
		while (flag == true && break_flag == false){
			System.out.print("Choose option:");
			Scanner get = new Scanner(System.in);
	    	command = get.nextLine();	
			switch (command){
				case "1" : decision_flag = 1 ; flag = false; break;
				case "2": decision_flag = 2; flag = false; break;
				case "exit":flag = false; break;
				default: System.out.println("Unknown option, try again");
			}
		}
		switch (cipher_flag){
			case 1: if (decision_flag==1) Cryptographer.cryptfile(read, write, new ROT11()); 
					if (decision_flag==2) Cryptographer.decryptfile(read, write, new ROT11()); 
					break; 
			case 2: if (decision_flag==1) Cryptographer.cryptfile(read, write, new Polibiusz()); 
					if (decision_flag==2) Cryptographer.decryptfile(read, write, new Polibiusz()); 
					break;
		}
    }
}
