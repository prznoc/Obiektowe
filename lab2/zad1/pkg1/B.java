package pkg1;
public class B extends A{
	public B(int numer, String nazwa){super(numer, nazwa);}
	private void Increment(){this.number = this.number+3;}
	protected void Decrement(){ this.number = this.number -5;}
	void changeName (String nazwa){ this.name = this.name + nazwa;}
}
