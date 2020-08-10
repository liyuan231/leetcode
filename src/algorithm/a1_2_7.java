package algorithm;

import java.util.Arrays;

public class a1_2_7 {
    public static void main(String[] args) {
        String s = "liyuan";
        System.out.println(mystery(s));
        System.out.println(reverse(s));
    }

    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) {
            return s;
        }
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }

    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        char temp;
        for (int i = 0; i < length / 2; i++) {
            temp = chars[i];
            chars[i] = chars[length - 1 - i];
            chars[length - i - 1] = temp;
        }
        return String.valueOf(chars);
    }
}
