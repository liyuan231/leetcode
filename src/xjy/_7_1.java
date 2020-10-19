package xjy;

import java.util.Scanner;

public class _7_1 {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();
        }
        System.out.println(solve(nums));
    }

    private static int solve(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] books = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            books[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    books[i] = Math.max(books[j] + 1, books[i]);
                }
            }
        }
        int ans = books[0];
        for (int num : books) {
            ans = Math.max(ans, num);
        }
        return ans;
    }
}
