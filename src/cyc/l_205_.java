package cyc;

import java.util.Arrays;

public class l_205_ {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("ab", "aa"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] res1 = travsel(s);
        int[] res2 = travsel(t);
        System.out.println(Arrays.toString(Arrays.stream(res1).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(res2).toArray()));
        for (int i = 0; i < res1.length; i++) {
            if (res2[i] != res1[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] travsel(String s) {
        int[] nums = new int[26];
        int[] res = new int[s.length()];
        Arrays.fill(res, -1);
        Arrays.fill(nums,-1);
        for (int i = 0; i < s.length(); i++) {
            if (nums[s.charAt(i) - 'a'] != -1) {
                res[i] = nums[s.charAt(i) - 'a'];
            }
            nums[s.charAt(i) - 'a'] = i;
        }
        return res;
    }
}
