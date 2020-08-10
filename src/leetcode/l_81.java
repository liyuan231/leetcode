package leetcode;

public class l_81 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int division = 0;
        for (division = 1; division < nums.length; division++) {
            if (nums[division] < nums[division - 1]) {
                break;
            }
        }
//        if (nums[0] > target && nums[division] > target) {
//            return false;
//        }
//        if (nums[division - 1] < target && nums[nums.length - 1] < target) {
//            return false;
//        }
        int left = 0;
        int right = division - 1;
        int middle = -1;
        //在第一部分二分搜索
        while (left <= right) {
            middle = right + (left - right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return true;
            }
        }
        //在第二部分二分搜索
        left = division;
        right = nums.length - 1;
        while (left <= right) {
            middle = right + (left - right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
