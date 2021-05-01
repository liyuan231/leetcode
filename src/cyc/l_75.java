package cyc;

import java.util.Arrays;

public class l_75 {
    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
    }

    public static void sortColors(int[] nums) {
//        Arrays.sort(nums);
        int[] buckets = new int[3];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i]]++;
        }
        for (int i = 0, j = 0; i < buckets.length; i++) {
            while (buckets[i] > 0) {
                nums[j++] = i;
                buckets[i]--;
            }
        }
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
    }

}
