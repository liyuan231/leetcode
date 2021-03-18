package interview;

import java.util.Arrays;
import java.util.LinkedList;

public class l_reverse {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6,7};
        nums = new int[]{1,2};
        int i =3;
//        i=1;
        System.out.println(Arrays.toString(Arrays.stream(rever(nums, i)).toArray()));
    }

    private static int[] rever(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        if(nums.length==1||k==0||nums.length==k){return nums;}
        k = k%nums.length;
        for (int i = nums.length - k; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < nums.length - k; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.pollFirst();
        }
        return nums;


    }
}
