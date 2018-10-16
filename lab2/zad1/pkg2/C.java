package pkg2;
import pkg1.*;
public class C extends B{
	public C(int numer, String nazwa){super(numer, nazwa);}
	void changeName (String nazwa){System.out.println("cannot change name");} //metoda nie ma dostepu do pola name 
}
