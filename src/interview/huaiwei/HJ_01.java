package interview.huaiwei;

import java.util.Scanner;

public class HJ_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(solve(s));
    }

    private static int solve(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return s.length() - i -1 ;
            }
        }
        return s.length();
    }
}
