package lab5;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Delayer {
    static void delay(String in,String out, int delay, int fps) throws Exception {
        Scanner source = new Scanner(new File(in));
        FileWriter output = new FileWriter(new File(out));
        int line = 0;
        while (source.hasNextLine()) {
            line += 1;
            String in2 = source.nextLine();
            String s2 = change(in2,delay, fps, line);
            output.write(s2);
            output.write('\n');
        }
        source.close();
        output.close();
        }
    private static String change(String in, int delay, int fps, int line)throws Exception{
        String[] temp = in.split("}");
        Integer begin, end;
        if ((Pattern.matches("\\{[[0-9]]*", temp[0]))&& (Pattern.matches("\\{[[0-9]]*", temp[1]))){
            temp[0] = temp[0].substring(1);
            temp[1] = temp[1].substring(1);
            begin = Integer.parseInt(temp[0]);
            end = Integer.parseInt(temp[1]);
            if (begin >= end) {
                throw new SequenceException("Wrong sequence, subtitle ends before it begins", line, in);
            }
            begin += delay*fps /1000;
            end += delay*fps / 1000;
            return "{" + begin.toString() + "}{" + end.toString() + "}" + temp[2];
        }
        else throw new FormatException("Invalid format of timing", line, in);
    }
}
