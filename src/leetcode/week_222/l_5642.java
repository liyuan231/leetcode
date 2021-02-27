package leetcode.week_222;

import java.util.Arrays;

public class l_5642 {
    public static void main(String[] args) {
        int[] delicious = new int[]{1, 3, 5, 7, 9};
        delicious = new int[]{1, 1, 1, 3, 3, 3, 7};
        System.out.println(countPairs(delicious));
    }

    public static int countPairs(int[] deliciousness) {
        int count = 0;
        Arrays.sort(deliciousness);
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                if (check((deliciousness[i] + deliciousness[j]))) {
                    System.out.println(deliciousness[i] + "-" + deliciousness[j]);
                    count++;
                }
            }
        }
        System.out.println(count);
        return count % 1000000007;
    }


    private static boolean check(int num) {
        while (num != 1) {
            int i = num % 2;
            num = num / 2;
            if (i == 1) {
                return false;
            }
        }
        return true;
    }
}
