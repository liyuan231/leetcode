package leetcode;

import java.util.ArrayList;

public class l_59 {
    public static void main(String[] args) {
        int n = 3;
        int[][] ints = generateMatrix(n);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int top = 0;
        int bottom = nums.length - 1;
        int left = 0;
        int right = nums[0].length-1;
        int num = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                nums[top][i] = num++;
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                nums[i][right] = num++;
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                nums[bottom][i] = num++;
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                nums[i][left] = num++;
            }
            if (++left > right) {
                break;
            }
        }
        return nums;
    }
}
