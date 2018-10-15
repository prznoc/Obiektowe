package myPackage;
import otherPackage.*;
public class HelloWorld {
	public static
	void main(String[] args){
		App app = new App();
		double result;
		result = app.Start(1,0.1,50);
		System.out.println(result);
	}
}
