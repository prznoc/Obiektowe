package lab5;

public class FormatException extends Exception{
    FormatException(String text, int line){
        super(text + " in line "+ line);
    }
}
