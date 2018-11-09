package lab5;

public class SequenceException extends Exception {
    SequenceException(String text, int line){
        super(text + " in line "+ line);
    }
}
