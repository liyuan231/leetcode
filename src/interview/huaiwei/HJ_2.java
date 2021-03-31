package interview.huaiwei;

import java.util.Scanner;

public class HJ_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char target = input.next().charAt(0);
        System.out.println(solve(s, target));
    }

    private static int solve(String s, char target) {
        int[] numsAlpha = new int[26];
        int[] numsNumber = new int[10];
        int space = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                space++;
            } else if (c >= '0' && c <= '9') {
                numsNumber[c - '0']++;
            } else {
                c = Character.toLowerCase(s.charAt(i));
                numsAlpha[c - 'a']++;
            }
        }
        if (target == ' ') {
            return space;
        }
        if (target >= '0' && target <= '9') {
            return numsNumber[target - '0'];
        }
        return numsAlpha[Character.toLowerCase(target)-'a'];
    }
}
