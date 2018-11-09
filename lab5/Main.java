package lab5;

public class Main {
    public static void main(String[] args) {
        try{
            int delay = Integer.parseInt(args[2]);
            int fps = Integer.parseInt(args[3]);
            Delayer.delay(args[0],args[1],delay,fps) ;
        }
        catch (SequenceException | FormatException e){
            System.err.println(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
