package cyc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l_451 {

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i) - 'a', map.getOrDefault(s.charAt(i) - 'a', 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> res = new ArrayList<>(map.entrySet());
        quickSort(res, 0, res.size() - 1);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            Map.Entry<Integer, Integer> entry = res.get(i);
            for (int j = 0; j < entry.getValue(); j++) {
                ans.append((char)(entry.getKey()+'a'));
            }
        }
        return ans.toString();
    }

    private static void quickSort(List<Map.Entry<Integer, Integer>> nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int par = partion(nums, lo, hi);
        quickSort(nums, lo, par - 1);
        quickSort(nums, par + 1, hi);
    }

    private static int partion(List<Map.Entry<Integer, Integer>> nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        Map.Entry<Integer, Integer> num = nums.get(lo);
        while (true) {
            while (i != hi && nums.get(++i).getValue() > num.getValue()) {
            }
            while (j != lo && nums.get(--j).getValue() < num.getValue()) {
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private static void swap(List<Map.Entry<Integer, Integer>> nums, int i, int j) {
        Map.Entry<Integer, Integer> integerIntegerEntry = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, integerIntegerEntry);
    }
}
