import java.util.*;
public class Test{
	static LinkedList<Prostokat> figury = new LinkedList<Prostokat>();
	public static void main(String [] argv){
		System.out.println("options: add, display, sum, exit");
		String command = "";
		while (command != "exit"){
			System.out.print("enter your command: ");
	      	Scanner get = new Scanner(System.in);
	      	command=get.nextLine();
			switch (command){
				case "add" : add(); break;
				case "display": display(); break;
				case "sum": sum(); break;
				case "exit": return;
			}	
		}		
	}
	public static void add(){
		double aa, bb;
		try{
			System.out.print("side a: ");
			Scanner reader = new Scanner(System.in);
			aa= reader.nextDouble(); 
			System.out.print("side b: ");
			reader = new Scanner(System.in);
			bb= reader.nextDouble();
		}
		catch (Exception e){
			System.out.println("wrong length");
			return;
			}
		Prostokat pro = new Prostokat(aa,bb);
		figury.add(pro);
		System.out.println("added");
	}
	public static void display(){
		for (int i = 0; i< figury.size(); ++i){
			Prostokat a = figury.get(i);
			int b = i+1;
			System.out.println("rectangle nb "+b+" "+a.get_a()+"/"+a.get_b());
		}
	}
	public static void sum(){
		double suma = 0;
		Prostokat a;
		for (int i = 0; i< figury.size(); ++i){
			a = figury.get(i);
			suma = suma + a.area();
		}
		System.out.println("sum: "+suma);
	}
}


