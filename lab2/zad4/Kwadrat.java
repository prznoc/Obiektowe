public class Kwadrat{
	protected double a;
	public Kwadrat(double a){this.a = a;}
	public double get_a(){return this.a;}
	public void set_a(double a) {this.a = a;}
	public boolean isBigger (Kwadrat be){
		if( be.a > this.a) return true;
		else return false;
	}
	public double area(){return a*a;}
}
