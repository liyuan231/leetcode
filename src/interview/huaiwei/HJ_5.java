package interview.huaiwei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ_5 {
    public static void main(String[] args) throws IOException {
        int[] maps = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                s = s.substring(2);
                int res = 0;
                for (int i = s.length() - 1; i >= 0; i--) {
                    char c = s.charAt(i);
                    int n = (c >= '0' && c <= '9') ? c - '0' : c - 'A' + 10;
//                    if (c >= '0' && c <= '9') {
                    res += n * Math.pow(16, s.length() - i - 1);
//                    } else {
//                    res += () * Math.pow();
//                    }

                }
                System.out.println(res);
            }
        }

    }
}
