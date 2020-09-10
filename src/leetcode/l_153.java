package leetcode;

public class l_153 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                //此mid可能为最小值，所以不加一
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(mid);
        return nums[mid];
    }
}
