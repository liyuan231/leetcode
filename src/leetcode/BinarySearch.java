package leetcode;

import edu.princeton.cs.algs4.Counter;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        Counter counter = new Counter("liyuan's counter");
        System.out.println(search(nums, -11,counter));
        System.out.println("counter:"+counter.tally());
    }

    public static int search(int[] nums, int target, Counter counter) {
        int mid, left = 0, right = nums.length - 1;
        while (left <= right) {
            System.out.println(1);
            mid = left + (right - left) / 2;
//            System.out.println(nums[mid]);
            counter.increment();
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid -1 ;
            } else {
                left = mid +1;
            }
        }
        return -1;
    }
}
