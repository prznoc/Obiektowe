package lab5;

public class FormatException extends Exception{
    FormatException(String text, int line, String in){
        super(text + " in line "+ line+ "\n" + in);
    }
}
