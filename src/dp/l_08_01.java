package dp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class l_08_01 {
    private static int count = 0;
    public static void main(String[] args) {
//        System.out.println(waysToStep(61));
        System.out.println(f(10));
        System.out.println(count);
        InputStreamReader inputStreamReader = new InputStreamReader(new BufferedInputStream(System.in));
    }

    public static int waysToStep(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (n == 2) {
            return 2;
        }
        int[] book = new int[n];
        book[0] = 1;
        book[1] = 2;
        book[2] = 4;
//        book[3] = 3;
        for (int i = 3; i < book.length; i++) {
            book[i] = ((book[i - 1] + book[i - 2]) % 1000000007 + book[i - 3]) % 1000000007;
        }
        return book[book.length - 1];
    }

    private static int f(int n) {
        count++;
        if (n <= 2) {
            return n;
        }
        return f(n - 2) + f(n - 4) + 1;
    }
}
