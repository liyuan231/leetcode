package cyc;

public class l_268 {
    public static void main(String[] args) {
        int[] nums = new int[]{ 0, 1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int[] buckets = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i]]++;
        }
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == 0) {
                return i;
            }
        }
        return -1;

    }
}
