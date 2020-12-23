package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class l_228 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 3, 4, 6, 8, 9};
//        nums = new int[]{0, 1, 2, 4, 5, 7};
//        nums = new int[]{-1};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> stringList = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1 && (nums[i] != nums[i - 1] + 1)) {
                if (list.get(0) != nums[i - 1]) {
                    list.add(nums[i - 1]);
                }
                extract(stringList, list);
                list.clear();
            }
            if (list.size() == 0 || i == nums.length - 1) {
                list.add(nums[i]);
            }
        }
        if (list.size() != 0) {
            extract(stringList, list);
        }
        System.out.println(Arrays.toString(stringList.toArray()));
        return null;
    }

    private static void extract(List<String> stringList, List<Integer> l) {
        if (l.size() == 0) {
            return;
        }
        if (l.size() == 1) {
            stringList.add(l.get(0).toString());
        }
        if (l.size() == 2) {
            String s1 = l.get(0).toString();
            String s2 = l.get(1).toString();
            stringList.add(s1 + "->" + s2);
        }
    }
}
