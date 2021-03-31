package interview.huaiwei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HJ_4 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String str = null;
        while ((str = input.readLine()) != null) {
            solve(str);
        }
//        input.close();
    }

    private static void solve(String str) {
        int i = 8;
        int j = 8;
//        StringBuilder strBuilder = new StringBuilder(str);
        if (str.length() <= j) {
            while ((str.length()) < j) {
                str += "0";
            }
            System.out.println(str);
        } else {
            int start = 0, end = 8;
            while (end < str.length()) {
                System.out.println(str.substring(start, end));
                start += j;
                end += j;
            }
            if (start < str.length()) {
                solve(str.substring(start));
            }
        }


    }
}
