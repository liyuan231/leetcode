package leetcode;

import java.util.Arrays;

public class l_260 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(Arrays.stream(singleNumber(nums)).toArray()));
    }

    public static int[] singleNumber(int[] nums) {
        int z = nums[0];
        for (int i = 1; i < nums.length; i++) {
            z ^= nums[i];
        }
        System.out.println(z);
        int bitmask = z & -z;
        System.out.println(bitmask);
        int x = -1;
        for (int i = 0; i < nums.length; i++) {
            if ((bitmask & nums[i]) != 0) {
                if (x == -1) {
                    x = nums[i];
                } else {
                    x ^= nums[i];
                }
            }
        }
        return new int[]{x,z^x};
    }
}
