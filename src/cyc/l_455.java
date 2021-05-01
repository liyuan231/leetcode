package cyc;

public class l_455 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{10, 9, 8, 7};
        int[] nums2 = new int[]{5, 6, 7, 8};
        System.out.println(findContentChildren(nums1, nums2));
    }

    public static int findContentChildren(int[] nums1, int[] nums2) {
        quickSort(nums1, 0, nums1.length - 1);
        quickSort(nums2, 0, nums2.length - 1);
        int count = 0;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] <= nums2[j]) {
                count++;
                j++;
                i++;
            } else {
                //»»Ò»¿é±ı¸É
                j++;
            }
        }
        return count;
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int par = partion(nums, lo, hi);
        quickSort(nums, lo, par - 1);
        quickSort(nums, par + 1, hi);
    }

    private static int partion(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int num = nums[lo];
        while (true) {
            while (i != hi && nums[++i] < num) {
            }
            while (j != lo && nums[--j] > num) {
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
