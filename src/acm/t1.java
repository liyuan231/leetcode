package acm;

import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < nums.length; i++) {
            nums[i][0] = input.nextInt();
            nums[i][1] = input.nextInt();
        }
        int[] weight = new int[n];
        for (int i = 0; i < weight.length; i++) {
            weight[i] = input.nextInt();
        }
        int q = input.nextInt();
        int[] query = new int[q];
        for (int i = 0; i < query.length; i++) {
            query[i] = input.nextInt();
        }


    }
}
