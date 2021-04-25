package cyc;

import java.util.Arrays;

public class l_260 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        int[] ints = singleNumber(nums);
        System.out.println(Arrays.toString(Arrays.stream(ints).toArray()));
    }

    public static int[] singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        int bitmask = num & -num;
        int res1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if ((bitmask & nums[i] )!= 0) {
                if(res1==-1){
                    res1 = nums[i];
                    continue;
                }
                res1^=nums[i];
            }
        }
        return new int[]{res1,num^res1};
    }
}
