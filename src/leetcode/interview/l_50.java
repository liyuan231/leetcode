package leetcode.interview;

import java.util.BitSet;

public class l_50 {
    public static void main(String[] args) {
        BitSet set = new BitSet();
        String s = "google";
        System.out.println(FirstNotRepeatingChar(s));
    }

    public static int FirstNotRepeatingChar(String str) {
        int[] nums = new int[128];
        int[] counts = new int[128];
        for (int i = 0; i < str.length(); i++) {
            nums[str.charAt(i)] = i;
            counts[str.charAt(i)]++;
        }
        int i = nums.length;
        for (int j = 0; j < counts.length; j++) {
            if (counts[j] == 1) {
                i = Math.min(nums[j], i);
            }
        }
        return i==nums.length?-1:i;
    }
}
