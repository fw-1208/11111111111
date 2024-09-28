package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class answer {
    public static void main(String[] args) {
        String a, b, f;
        try {
            FileReader in = new FileReader("exercises.txt");
            BufferedReader buf1 = new BufferedReader(in);
            PrintStream out = new PrintStream("answer.txt");
            System.setOut(out);
            
            while ((a = buf1.readLine()) != null) {
                String[] c = a.split(" ");
                String[] d = new String[c.length - 2];
                number_string.zhen_fen_change(c);

                System.arraycopy(c, 1, d, 0, d.length);
                
                b = operation.last(d);
                f = Number.ture_fraction(b);
                System.out.println(f);
            }
            buf1.close();
        } catch (IOException e) {
            System.out.println("文件出错");
            System.exit(-1);
        }
    }
}
