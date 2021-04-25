package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class cyc_40 {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(Arrays.toString(GetLeastNumbers_Solution(nums, 3).toArray()));
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k>nums.length){return list;}
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < k ; i++) {
            list.add(nums[i]);
        }
        return list;
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
        swap(nums, j, lo);
        return j;
    }

    private static void swap(int[] nums, int j, int lo) {
        int tmp = nums[j];
        nums[j] = nums[lo];
        nums[lo] = tmp;
    }

}
