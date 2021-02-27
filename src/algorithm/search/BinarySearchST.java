package algorithm.search;

import java.util.ArrayList;
import java.util.Iterator;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void put(Key key, Value value) {
        int i = rank(key);//[0,i)即为key大于的元素
        //若能找到该键,即已经存在了
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        //若该键不存在，则放入
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j -1];
        }
//        for (int j = N; j > i; j--) {
//            keys[j] = keys[j - 1];
//            values[j] = values[j - 1];
//        }
        keys[i] = key;
        values[i] = value;
        N++;
        if (N >= this.keys.length) {
            resize();
        }
    }

    private void resize() {
        int oldCap = this.keys.length;
        int newCap = oldCap << 1;
        Key[] newKeys = (Key[]) new Comparable[newCap];
        Value[] newValues = (Value[]) new Comparable[newCap];
        for (int i = 0; i < this.keys.length; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        this.keys = newKeys;
        this.values = newValues;
    }

    private int rank(Key key) {
        return rank(key, 0, N - 1);
    }

    private int rank(Key key, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int i = keys[mid].compareTo(key);
            if (i == 0) {
                return mid;
            } else if (i < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }


    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key ceiling(Key key) {
        return keys[rank(key)];
    }

    public Key floor(Key key) {
        return keys[N - rank(key) - 1];
    }

    public void delete(Key key) {
        int index = rank(key);
        if (index == -1) {
            return;
        }
        for (int i = index; i < N - 1; i++) {
            values[i] = values[i + 1];
            keys[i] = keys[i - 1];
        }
        N--;
    }

    public Iterable<Key> keys() {
        ArrayList<Key> keys = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            keys.add(this.keys[i]);
        }
        return keys;
    }

    public static void main(String[] args) {
        BinarySearchST<Integer, String> map = new BinarySearchST<>(50);
        int[] nums = new int[]{79, 26, 3, 0, 36, 95, 79, 37, 1, 0, 95, 87, 26, 24, 81};
        for (int num : nums) {
            map.put(num, String.valueOf(num));
        }
        System.out.println(map.max());
        System.out.println(map.min());
        Iterable<Integer> keys = map.keys();
        Iterator<Integer> iterator = keys.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next + "->" + map.get(next));
        }
    }
}
