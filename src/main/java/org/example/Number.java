package org.example;

import java.util.Random;

public class Number {
    // 生成随机数
    public String ramdom(int num) {
        Random a = new Random();
        int b = a.nextInt(num);
        return Integer.toString(b);
    }

    // 产生随机的运算符
    public String ramdom_yunsuanfu() {
        Random r1 = new Random();
        int b = r1.nextInt(4);
        switch (b) {
            case 0:
                return "×";
            case 1:
                return "÷";
            case 2:
                return "+";
            default:
                return "−";
        }
    }

    // 产生题目中运算数字的量（2或3）
    public int beiyunsuan_number() {
        Random a = new Random();
        return a.nextInt(2) + 2; // 生成 2 或 3
    }

    // 生成分数
    public String fraction(String b) {
        Random a = new Random();
        int c = a.nextInt(4);
        int d = c + a.nextInt(6);
        
        if (c == 3) {
            if (b.equals("0")) {
                return c + "/" + d; // 直接返回分数
            } else {
                return b + "'" + c + "/" + d; // 返回带分数
            }
        }
        return b; // 否则返回原始字符串
    }

    // 假分数转换为真分数
    public String false_fraction(String b) {
        String[] a = b.split("'");
        String[] c = a[1].split("/");
        int d = Integer.parseInt(a[0]);
        int e = Integer.parseInt(c[0]);
        int f = Integer.parseInt(c[1]);
        int g = d * f + e;
        return g + "/" + f; // 返回真分数
    }

    // 假分数转换为真分数
    public static String ture_fraction(String b) {
        String[] a = b.split("/");
        int d = Integer.parseInt(a[0]);
        int e = Integer.parseInt(a[1]);

        if (d == 0) {
            return "0"; // 处理 0
        } else if (e == 1) {
            return a[0]; // 处理整数
        } else if (d >= e) {
            int f = d / e; // 整数部分
            int g = d % e; // 余数
            if (g == 0) {
                return String.valueOf(f); // 整数
            } else {
                int h = operation.gongyinzi(g, e);
                return f + "'" + g / h + "/" + e / h; // 返回带分数
            }
        }
        return b; // 返回原始分数
    }
}
