package interview.huaiwei;


import java.util.Stack;

public class no_03 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 7, 5, 9};
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
            if (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i];
            } else {
                stack.push(i);
            }
        }
    }
}
