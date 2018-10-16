package pkg1;
import java.io.*;
public class A{
	protected int number;
	String name;
	public A(int num, String nazwa){
		this.number = num;
		this.name = nazwa;
	}
	public void callDecrement(){Decrement(); }
	public void callchangeName(String nazwa){ changeName(nazwa);}
	public void callIncrement(){ Increment();}
	private void Increment(){this.number += 2;}
	protected void Decrement(){ this.number -= 3;}
	void changeName (String nazwa){ this.name = nazwa;}
	public void display_name(){System.out.println(name);}
	public void display_number(){System.out.println(number);}
}


