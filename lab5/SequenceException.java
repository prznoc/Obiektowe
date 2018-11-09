package lab5;

public class SequenceException extends Exception {
    SequenceException(String text, int line, String in){
        super(text + " in line "+ line + "\n" + in);
    }
}
