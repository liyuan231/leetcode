package leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class l_146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }

    static class LRUCache {
        /**
         * stack中仅保存key值
         */
        private Deque<Integer> deque = null;
        /**
         * map中保存key以及value值
         */
        private Map<Integer, Integer> map;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            deque = new ArrayDeque<>();
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            Integer orDefault = map.getOrDefault(key, -1);
            if (orDefault != -1) {
                deque.remove(key);
                deque.addLast(key);
            }
            return orDefault;
        }

        public void put(int key, int value) {
            if (map.get(key) != null) {//重key值
                map.put(key, value);
                deque.remove(key);
                deque.addLast(key);
                return;
            }
            if (map.size() == capacity) {
                Integer keyInDeque = deque.pollFirst();
                map.remove(keyInDeque);
            }
            map.put(key, value);
            deque.addLast(key);
        }
    }

    @Test
    public void test() {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.get(-1));
    }

}
