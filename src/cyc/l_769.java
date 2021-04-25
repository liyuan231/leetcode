package cyc;

public class l_769 {
    public static void main(String[] args) {
        int[]nums = new int[]{1,0,2,3,4};
        System.out.println(maxChunksToSorted(nums));
    }

    public static int maxChunksToSorted(int[] nums) {
        int count = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right = Math.max(right, nums[i]);
            if (right == i) {
                count++;
            }
        }
        return count;
    }
}
