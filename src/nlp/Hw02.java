package nlp;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现维比特算法
 */
public class Hw02 {
    public static void main(String[] args) throws IOException {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        String s = input.readLine();
//        String[] observation = s.split(" ");

        //状态转移概率分布矩阵
        double[][] transfer = new double[][]{
                {0, 0, 0, 48636, 0, 19},
                {1973, 0, 426, 187, 0, 38},
                {43322, 0, 1326, 17314, 0, 185},
                {1067, 3720, 42470, 11773, 614, 21392},
                {6072, 42, 4758, 1476, 129, 1522},
                {8016, 75, 4656, 1329, 954, 0}
        };
        //发射概率
        double[][] launch = new double[][]{
                {0, 0, 0, 10, 43, 0},
                {0, 10065, 0, 0, 0, 0},
                {0, 0, 0, 36, 133, 0},
                {0, 0, 5484, 0, 0, 0},
                {0, 0, 0, 382, 0, 0},
                {0, 0, 0, 108, 4, 0},
                {69016, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 48809}
        };
        //初始状态的概率
        laplas(launch);
        laplas(transfer);
        double[] init = new double[]{0.2, 0.1, 0.1, 0.2, 0.3, 0.1};
        String[] sources = new String[]{"bear", "is", "move", "on", "president", "progress", "the", "."};
        String[] states = new String[]{"AT", "BEZ", "IN", "NN", "VB", "PERIOD"};
        String[] observation = new String[]{"the", "bear", "is", "on", "the", "move", "."};
//        Map<String, Integer> indecies = new HashMap<>();
//        for (int i = 0; i < sources.length; i++) {
//            indecies.put(sources[i], i);
//        }
        System.out.println(Arrays.toString(Arrays.stream(observation).toArray()));
        int[] viterbi = viterbi(states, observation, init, transfer, launch, sources);
//        System.out.println(Arrays.toString(Arrays.stream(viterbi).toArray()));
        for (int i = 0; i < viterbi.length; i++) {
            System.out.print(states[viterbi[i]] + " ");
        }
        System.out.println();
    }

    private static int[] viterbi(String[] states, String[] observation, double[] init, double[][] transfer, double[][] launch, String[] helpSource) {
        int[][] path = new int[observation.length][states.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < helpSource.length; i++) {
            map.put(helpSource[i], i);
        }
        double[][] nodes = new double[observation.length][states.length];
        for (int i = 0; i < nodes[0].length; i++) {
            nodes[0][i] = init[i] * launch[map.get(observation[i])][i];
        }
        for (int i = 1; i < nodes.length; i++) {
            for (int j = 0; j < states.length; j++) {
                double max = 0;
                int index = 0;
                for (int k = 0; k < states.length; k++) {
                    double tmp;
                    if ((tmp = nodes[i - 1][k] * transfer[k][j]) > max) {
                        max = tmp;
                        index = k;
                    }
                }
                path[i][j] = index;
                nodes[i][j] = max * launch[map.get(observation[i])][j];
            }
        }
        int[] res = new int[nodes.length];
        int lastIndex = 0;
        double prob = 0;
        for (int i = 0; i < states.length; i++) {
            if (nodes[states.length - 1][i] > prob) {
                prob = nodes[nodes.length - 1][i];
                lastIndex = i;
            }
        }
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = lastIndex;
            lastIndex = path[i][lastIndex];
        }
        return res;
    }

    private static void laplas(double[][] launch) {
        int count = 0;
        for (int i = 0; i < launch.length; i++) {
            for (int i1 = 0; i1 < launch[i].length; i1++) {
                count += launch[i][i1] + 1;
            }
        }
        for (int i = 0; i < launch.length; i++) {
            for (int i1 = 0; i1 < launch[i].length; i1++) {
                launch[i][i1] = (launch[i][i1] + 1) / count;
            }
        }
    }


    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 10, 3, 8, 5, 6, 7, 4, 9, 2};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
    }

    private void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    private void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int par = partion(nums, lo, hi);
        quickSort(nums, lo, par - 1);
        quickSort(nums, par + 1, hi);
    }

    private int partion(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int num = nums[lo];
        while (true) {
            while (i != hi && nums[++i] < num) {
            }
            while (j != lo && nums[--j] > num) {
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
