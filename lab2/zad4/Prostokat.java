public class Prostokat extends Kwadrat{
	protected double b;
	public Prostokat(double aa, double bb){
		super(aa);
		this.b = bb;
	}
	public double get_b(){return this.b;}
	public void set_b(double b) {this.b = b;}
	public double area(){return a*b;}
	public boolean isBigger (Prostokat be){
		if( be.a*be.b > this.a*this.b) return true;
		else return false;
	}
}
