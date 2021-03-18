package interview;

import java.util.BitSet;

public class MyBloomFilter {
    private static final int DEFAULT_SIZE = 2 << 24;
    //通过这个数组可以创建6个不同的hash函数
    private static final int[] SEEDS = new int[]{3, 13, 46, 71, 91, 134};
    private BitSet bits = new BitSet(DEFAULT_SIZE);
    private SimpleHash[] func = new SimpleHash[SEEDS.length];


    public MyBloomFilter() {
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    public void add(Object value) {
        for (SimpleHash simpleHash : func) {
            bits.set(simpleHash.hash(value), true);
        }
    }

    public boolean contains(Object value) {
        boolean ret = true;
        for (SimpleHash simpleHash : func) {
            ret = ret && bits.get(simpleHash.hash(value));
        }
        return ret;
    }


    public static class SimpleHash {
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }
    }

    public static void main(String[] args) {
        String value1 = "https://www.baidu.com";
        String value2 = "https://www.bilibili.com";
        MyBloomFilter bloomFilter = new MyBloomFilter();
        System.out.println(bloomFilter.contains(value1));
        System.out.println(bloomFilter.contains(value2));
        bloomFilter.add(value1);
        bloomFilter.add(value2);
        System.out.println(bloomFilter.contains(value1));
        System.out.println(bloomFilter.contains(value2));
    }

}
