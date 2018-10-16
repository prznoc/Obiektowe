package pkg2;
import pkg1.*;
public class Main{
	public static void main(String [] argv){
		A a = new A (23,"aaa");
		B b = new B (14,"bee");
		C c = new C (3,"cee");
		a.callDecrement();
		b.callDecrement();
		c.callDecrement();
		a.callIncrement();
		b.callIncrement();
		c.callIncrement();
		a.callchangeName("name_a");
		b.callchangeName("name_b");
		c.callchangeName("name_c");
		a.display_name();
		b.display_name();
		c.display_name();
		a.display_number();
		b.display_number();
		c.display_number();
	}
}
