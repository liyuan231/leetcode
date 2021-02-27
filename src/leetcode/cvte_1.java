package leetcode;

import java.util.Arrays;

public class cvte_1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2};
        nums = new int[]{1,1,1};
        nums = new int[]{};
        System.out.println(flowers(nums));
    }

    private static int flowers(int[] scores) {
        int[] book = new int[scores.length];
        for (int i = 0; i < book.length; i++) {
            book[i] = 1;
        }
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[i - 1]) {
                book[i] = book[i - 1] + 1;
            }
        }
        for (int i = scores.length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                book[i] = book[i + 1] + 1;
            }
        }
        System.out.println(Arrays.toString(Arrays.stream(book).toArray()));
        int res=0;
        for (int i : book) {
            res+=i;
        }
        return res;

    }
}
