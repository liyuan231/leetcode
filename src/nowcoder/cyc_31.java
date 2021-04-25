package nowcoder;


import java.util.Stack;

public class cyc_31 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        int[] nums2 = new int[]{4, 3, 5, 2, 1};
        System.out.println(IsPopOrder(nums1, nums2));
    }

    public static boolean IsPopOrder(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < nums1.length; i++) {
            stack.push(nums1[i]);
            while (!stack.isEmpty() && stack.peek().equals(nums2[j])) {
                stack.pop();
                j++;
            }

        }
        return stack.isEmpty();
    }
}
