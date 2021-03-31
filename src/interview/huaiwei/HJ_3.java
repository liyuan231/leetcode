package interview.huaiwei;

import java.util.Scanner;

public class HJ_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = -1;
        while (input.hasNext()) {
            num = input.nextInt();
            int[] nums = new int[num];
            for (int i = 0; i < nums.length; i++) {
//                while (input.hasNextInt()) {
                int  s = input.nextInt();
                nums[i] = s;
//                }
            }
            int[] res = solve(nums);
            for (int re : res) {
                System.out.println(re);
            }
        }
    }

    private static int[] solve(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
//            nums[j] = nums[i];
            if (nums[i] == nums[j]) {
                continue;
            }
            nums[++j] = nums[i];
        }
        int[] ints = new int[j + 1];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = nums[i];
        }
        return ints;

    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int par = partion(nums, lo, hi);
        quickSort(nums, lo, par - 1);
        quickSort(nums, par + 1, hi);
    }

    private static int partion(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int num = nums[lo];
        while (true) {
            while (i != hi && nums[++i] < num) {
            }
            while (j != lo && nums[--j] > num) {
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private static void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }
}
