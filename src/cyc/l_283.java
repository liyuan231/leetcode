package cyc;

import java.util.Arrays;

public class l_283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
    }

    public static void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                continue;
            }
            nums[i++] = nums[j];
        }
        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
