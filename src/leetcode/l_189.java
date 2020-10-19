package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class l_189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
    }

    public static void rotate(int[] nums, int k) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int num : nums) {
            linkedList.add(num);
        }
        for(int i=0;i<k;i++){
            linkedList.addFirst(linkedList.pollLast());
        }
        for (int i=0;i<nums.length;i++){
            nums[i] = linkedList.pollFirst();
        }
       // System.out.println(Arrays.toString(linkedList.toArray()));

    }
}
