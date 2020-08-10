package leetcode;

public class l_55 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};

    }

    public static boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i>reach){
                return false;
            }
            reach = Math.max(i + nums[i], reach);
        }
        return true;
    }
}
