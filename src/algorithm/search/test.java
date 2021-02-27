package algorithm.search;

import org.junit.Test;

public class test {
    private int search2(double[] nums, double target, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println("lo:"+lo);
        System.out.println("hi:"+hi);
        return lo;
    }
    @Test
    public void test1() {
        double[] nums = new double[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        System.out.println(search2(nums, 100, 0, nums.length- 1));
    }
}
