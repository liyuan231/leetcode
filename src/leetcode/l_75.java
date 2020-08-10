package leetcode;

public class l_75 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        int[] bucket = new int[3];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }
        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] != 0) {
                bucket[i]--;
                nums[k++] = i;
            }
        }
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
