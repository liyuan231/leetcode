package cyc;

import java.util.Arrays;

public class l_205 {
    public static void main(String[] args) {
        solve(new int[]{1, 2, 2, 2, 3, 3, 4, 4, 5, 5});
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {

        }
        return false;
    }


    public static void solve(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[j]){
                continue;
            }
            nums[++j] = nums[i];
        }
        int[] res = new int[j];
        for (int ii = 0; ii < res.length; ii++) {
            res[ii] = nums[ii];
        }
        System.out.println(Arrays.toString(Arrays.stream(res).toArray()));
    }
}
