package interview.huaiwei;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class TestHuawei {
    public static void main(String[] args) {
        System.out.println(findNumberOf1(5));
    }

    public static int findNumberOf1(int num) {
        String s = Integer.toBinaryString(num);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }


    @Test
    public void test01() {
        String s = "AACTGTGCACGACCTGA";
        int len = 5;
        Scanner input = new Scanner(System.in);
        s = input.next();
        len = input.nextInt();
        Queue<Character> queue = new ArrayDeque<>(len);
        int count = 0;
        int max = 0;
        int i = 0;
        for (int k = 0; k < s.length() - len; k++) {
            char c = s.charAt(k);
            if (k < len) {
                queue.add(s.charAt(k));
                if (c == 'G' || c == 'C') {
                    count++;
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
        String res = s.substring(i - 5, i);
        System.out.println(res);
    }

    private boolean isValid(char c) {
        if (c == 'G' || c == 'C') {
            return true;
        }
        return false;
    }
}
