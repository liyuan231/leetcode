package interview.huaiwei;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class DNA {
    public static void main(String[] args) {
        String s = "AACTGTGCACGACCTGA";
        int len = 5;
        Scanner input = new Scanner(System.in);
        len = input.nextInt();
        s = input.next();
        if (s.length() < len) {
            System.out.println(s);
            return;
        }
        Queue<Character> queue = new ArrayDeque<>(len);
        int count = 0;
        int max = 0;
        int i =len-1;
        for (int k = 0; k < s.length(); k++) {
            char c = s.charAt(k);
            if (k < len) {
                queue.add(s.charAt(k));
                if (c == 'G' || c == 'C') {
                    count++;
                    max++;
                }
                continue;
            }
            Character poll = queue.poll();
            if (isValid(poll)) {
                count--;
            }
            queue.add(c);
            if (isValid(c)) {
                count++;
            }
            if (count > max) {
                max = count;
                i = k;
            }
        }
        i++;
        String res = s.substring(i - len, i);
        System.out.println(res);
    }


    private static boolean isValid(char c) {
        if (c == 'G' || c == 'C') {
            return true;
        }
        return false;
    }
}
