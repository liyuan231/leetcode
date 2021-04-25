package cyc;

public class l_51 {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 6, 4};
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
