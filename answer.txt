package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class answer_student {
    public static void main(String[] args) {
        String a, b;
        int True = 0;
        int False = 0;
        int i = 0;
        StringBuilder ture_nums = new StringBuilder();
        StringBuilder fasle_nums = new StringBuilder();

        try {
            FileReader fl1 = new FileReader("student_answer.txt");
            FileReader fl2 = new FileReader("answer.txt");
            BufferedReader buf1 = new BufferedReader(fl1);
            BufferedReader buf2 = new BufferedReader(fl2);
            PrintStream pr = new PrintStream(Files.newOutputStream(Paths.get("Grade.txt")));
            System.setOut(pr);

            while ((a = buf1.readLine()) != null) {
                b = buf2.readLine(); // 在这里读取正确答案
                if (a.equals(b)) {
                    True++;
                    ture_nums.append((i + 1)).append(",");
                } else {
                    False++;
                    fasle_nums.append((i + 1)).append(",");
                }
                i++;
            }

            System.out.println("Correct:" + True + "道题(" + ture_nums + ")");
            System.out.println("Wrong:" + False + "道题(" + fasle_nums + ")");
            buf1.close();
            buf2.close();
        } catch (IOException e) {
            System.out.println("出错");
        }
    }
}
