package cyc;

import java.util.Arrays;
import java.util.Stack;

public class l_503 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Arrays.stream(nextGreaterElements(new int[]{-1, 0})).toArray()));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] tmp = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        for (int i = nums.length; i < tmp.length; i++) {
            tmp[i] = nums[i - nums.length];
        }
        boolean[] visited = new boolean[tmp.length];
        int[] res = new int[tmp.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tmp.length; i++) {
            while (!stack.isEmpty() && tmp[stack.peek()] < tmp[i]) {
                visited[stack.peek()] = true;
                res[stack.pop()] = tmp[i];
            }
            stack.push(i);
        }
        int[] r = new int[nums.length];
        System.out.println(Arrays.toString(visited));
        for (int i = 0; i < nums.length; i++) {
            r[i] = visited[i]?res[i]:-1;
        }
        return r;
    }
}
