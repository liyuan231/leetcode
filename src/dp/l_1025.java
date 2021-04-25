package dp;

import java.util.Arrays;

public class l_1025 {
    public static void main(String[] args) {
        System.out.println(massage(new int[]{2, 1}));
    }

    public static int massage(int[] nums) {
        if(nums.length==0){return 0;}
        if(nums.length==1){return nums[0];}
        int[] book = new int[nums.length];
        book[0] = nums[0];
        book[1] = nums[1];
        int res = Math.max(book[0],book[1]);
        for (int i = 2; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i - 1; j++) {
                max = Math.max(max, book[j]);
            }
            book[i] = max + nums[i];
            res = Math.max(res,book[i]);
        }
        System.out.println(Arrays.toString(Arrays.stream(book).toArray()));
        return res;
    }
}
