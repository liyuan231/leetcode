package leetcode;

public class l_80 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 2, 3, 3, 3,4};
        System.out.println("ans:" + removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int j = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[j - 2] != nums[i]) {
                nums[j++] = nums[i];
            }
        }
        for (int i = 0; i < j; i++) {
            System.out.print(nums[i] + " ");
        }
        return -1;
    }
}
