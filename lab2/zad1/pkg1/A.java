package pkg1;
import java.io.*;
public class A{
	protected int number;
	String name;
	public A(int num, String nazwa){
		this.number = num;
		this.name = nazwa;
	}
	public void callDecrement(){ this.number = this.number -2;}
	public void callchangeName(String nazwa){ this.name = nazwa;}
	public void callIncrement(){ this.number = this.number +1;}
	private void Increment(){this.number = this.number+1;}
	protected void Decrement(){ this.number = this.number -1;}
	void changeName (String nazwa){ this.name = nazwa;}
	public void display_name(){System.out.println(name);}
	public void display_number(){System.out.println(number);}
}


