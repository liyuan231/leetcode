package leetcode;

import java.util.Arrays;

public class l_offer_51 {
    private int[] copy;
    private int count;

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,3,1};
        l_offer_51 l_offer_51 = new l_offer_51();
        l_offer_51.mergeSort(nums);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
        System.out.println(l_offer_51.count);
    }

    private void mergeSort(int[] nums) {
        copy = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            copy[k] = nums[k];
        }
        int k = left;
        while (i <= mid && j <= right) {
            if (copy[i] <= copy[j]) {
                nums[k++] = copy[i++];
                //是这里吗？？
            } else {
                count += mid-i+1;
                nums[k++] = copy[j++];
            }
        }
        while (i <= mid) {
            nums[k++] = copy[i++];
        }
        while (j <= right) {
            nums[k++] = copy[j++];
        }
    }
}
