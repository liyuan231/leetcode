package algorithm.priority;

import java.util.Iterator;

public class MaxPQ<Key extends Comparable<Key>> implements Iterable<Key> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ() {
        pq = (Key[]) new Comparable[10];
    }

    /**
     * 创建一个初始容量为max的优先级队列
     *
     * @param maxN
     */
    public MaxPQ(int maxN) {
        this.pq = (Key[]) new Comparable[maxN + 1];
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key max() {
        return null;
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{5, 11, 14, 20, 33, 53, 78, 89, 65, 82,};
        MaxPQ<Integer> maxPQ = new MaxPQ<>(integers.length);
        for (int i = 0; i < integers.length; i++) {
            maxPQ.insert(integers[i]);
        }
        for (Integer integer : maxPQ) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());

    }

    @Override
    public Iterator<Key> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Key> {
        private int cur = 1;

        @Override
        public boolean hasNext() {
            return cur != N + 1;
        }

        @Override
        public Key next() {
            return pq[cur++];
        }
    }
}
