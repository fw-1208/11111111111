package org.example;

public class number_string {
    public String Number_string(String[] a) {
        StringBuilder b = new StringBuilder(); // 使用 StringBuilder 提高效率
        for (String value : a) {
            b.append(value);
        }
        return b.toString();
    }

    // 分数转换为真分数和整数转化为分数
    public static void zhen_fen_change(String[] a) {
        Number s = new Number();
        for (int i = 0; i < a.length; i++) {
            if (a[i].contains("'")) {
                a[i] = s.false_fraction(a[i]);
            }
            if (!a[i].contains("/") && !a[i].equals("×") && !a[i].equals("÷") && 
                !a[i].equals("-") && !a[i].equals("+") && !a[i].equals(" ")) {
                a[i] = a[i] + "/1"; // 将整数转化为分数
            }
        }
    }
}
