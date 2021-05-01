package cyc;

import java.util.*;

public class l_347 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        int k = 2;
        System.out.println(Arrays.toString(Arrays.stream(topKFrequent(nums, k)).toArray()));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() >= k) {
                res.add(entry);
//            }
        }
        quickSort(res, 0, res.size() - 1);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = res.get(i).getKey();
        }
        return ans;
    }

    private static void quickSort(List<Map.Entry<Integer, Integer>> res, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int par = partion(res, lo, hi);
        quickSort(res, lo, par - 1);
        quickSort(res, par + 1, hi);
    }

    private static int partion(List<Map.Entry<Integer, Integer>> res, int lo, int hi) {
        int i = lo, j = hi + 1;
        Map.Entry<Integer, Integer> num = res.get(lo);
        while (true) {
            while (i != hi && res.get(++i).getValue() > num.getValue()) {
            }
            while (j != lo && res.get(--j).getValue() < num.getValue()) {
            }
            if (i >= j) {
                break;
            }
            swap(res, i, j);
        }
        swap(res, lo, j);
        return j;
    }

    private static void swap(List<Map.Entry<Integer, Integer>> res, int i, int j) {
        Map.Entry<Integer, Integer> t = res.get(i);
        res.set(i, res.get(j));
        res.set(j, t);
    }
}
