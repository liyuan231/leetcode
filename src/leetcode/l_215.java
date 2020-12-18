package leetcode;

public class l_215 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k =  4;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        sort(nums, 0, nums.length - 1);
        return nums[Math.max(nums.length - k, 0)];
    }

    private static void sort(int[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private static int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1;
        int v = nums[l];
        while (true) {
            while (nums[++i] < v) {
                if (i == h) {
                    break;
                }
            }
            while (v < nums[--j]) {
                if (j == l) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int tmp = nums[l];
        nums[l] = nums[j];
        nums[j] = tmp;
        return j;
    }
}
