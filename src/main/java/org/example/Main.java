package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("请输入生成题目个数和数字的范围（多少以内）");
        System.out.println("以空格分开，按下回车键以确定");
        Scanner sc = new Scanner(System.in);

        try {
            System.setOut(new PrintStream("exercises.txt"));
        } catch (FileNotFoundException e1) {
            System.out.println("找不到指定的文件");
            System.exit(-1);
        }

        String first = sc.nextLine();
        String[] string = first.split(" ");

        if (string.length < 2) {
            System.out.println("请输入两个参数");
            System.exit(-1);
        }

        int str0 = 0;
        int num = 0;

        try {
            str0 = Integer.parseInt(string[0]);
            num = Integer.parseInt(string[1]);
        } catch (NumberFormatException e3) {
            System.out.println("请输入整数");
            System.exit(-1);
        }

        if (num > 10 || num < 0) {
            System.out.println("请输入10以内的整数");
            System.exit(-1);
        }

        // 设置题目数量
        String[] str_num = new String[str0];
        for (int k = 0; k < str0; k++) {
            Number s1 = new Number();
            int t = s1.beiyunsuan_number();
            String[] number = new String[t];
            String[] symbol = new String[t - 1];
            String[] sum = new String[4 * t - 3];

            for (int i = 0; i < t; i++) {
                number[i] = s1.fraction(s1.ramdom(num));
            }
            for (int i = 0; i < t - 1; i++) {
                symbol[i] = s1.ramdom_yunsuanfu();
            }
            for (int i = 0; i < 4 * t - 3; i++) {
                if (i % 4 == 0) {
                    int c = i - 2; // 排除0为除数
                    if (c > 0 && symbol[i / 4 - 1].equals("÷") && number[i / 4].equals("0")) {
                        number[i / 4] = "1";
                    }
                    sum[i] = number[i / 4];
                } else if (i % 4 == 2) {
                    sum[i] = symbol[(i + 2) / 4 - 1];
                } else {
                    sum[i] = " ";
                }
            }

            number_string s2 = new number_string();
            String jieguo = s2.Number_string(sum);
            number_string.zhen_fen_change(sum);
            String jieguo2 = operation.last(sum);

            boolean flag = true;
            // 查重
            for (int i = 0; i < str0; i++) {
                if (str_num[i] != null && str_num[i].equals(jieguo2)) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                k--;
            } else {
                String jieguo3 = (k + 1) + ". " + jieguo + " =";
                System.out.println(jieguo3);
                str_num[k] = jieguo2; // 记录生成的结果以防重复
            }
        }
        sc.close();
    }
}
