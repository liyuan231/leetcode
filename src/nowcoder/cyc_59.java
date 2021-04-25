package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class cyc_59 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int width = 3;
        ArrayList<Integer> arrayList = maxInWindows(nums, width);
        System.out.println(Arrays.toString(arrayList.toArray()));
    }

    public static ArrayList<Integer> maxInWindows(int[] nums, int size) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        ArrayList<Integer> res = new ArrayList<>(nums.length - size + 1);
        for (int i = 0; i < nums.length; i++) {
            integers.add(nums[i]);
            if (integers.size() == size) {
                res.add(integers.peek());
                integers.remove(nums[i - size + 1]);
            }
        }
        return res;
    }

    private static class MaxPQ<Key extends Comparable<Key>> {
        private final Key[] pq;
        private int N = 0;

        public MaxPQ(int maxN) {
            pq = (Key[]) new Comparable[maxN + 1];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public void insert(Key key) {
            pq[++N] = key;
            swim(N);
        }

        public Key delMax() {
            Key max = pq[1];
            swap(1, N--);
            pq[N + 1] = null;
            sink(1);
            return max;
        }

        private void sink(int k) {
            while (2 * k <= N) {
                int j = 2 * k;
                if (j < N && pq[j].compareTo(pq[j + 1]) < 0) {
                    j++;
                }
                if (pq[k].compareTo(pq[j]) > 0) {
                    break;
                }
                swap(k, j);
                k = j;
            }
        }

        private void swim(int k) {
            while (k > 1 && pq[k / 2].compareTo(pq[k]) < 0) {
                swap(k / 2, k);
                k = k / 2;
            }
        }


        private void swap(int i, int i1) {
            Key tmp = pq[i];
            pq[i] = pq[i1];
            pq[i1] = tmp;

        }

        public Comparable[] toArray() {
            Comparable[] vs = new Comparable[N];
            for (int i = 0; i < vs.length; i++) {
                vs[i] = pq[i + 1];
            }
            return vs;
        }
    }
}
