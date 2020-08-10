package leetcode;

import edu.princeton.cs.algs4.Counter;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,5,5,6,7,8};
        Counter counter = new Counter("liyuan's counter");
        System.out.println(search(nums, 2,counter));
        System.out.println("counter:"+counter.tally());
    }

    public static int search(int[] nums, int target, Counter counter) {
        int mid, left = 0, right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            System.out.println(nums[mid]);
            counter.increment();
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid -1 ;
            } else {
                left = mid -1;
            }
        }
        return -1;
    }
}
