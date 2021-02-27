package algorithm.search;//package algorithm.search;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

public class FrequencyCounter {
    public static void main(String[] args) {
        int minLen = Integer.parseInt(args[0]);
        ST<String, Integer> strings = new ST<>();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minLen) {
                continue;
            }
            if (!strings.contains(word)) {
                strings.put(word, 1);
            } else {
                strings.put(word, strings.get(word) + 1);
            }
        }
        String max = "";
        strings.put(max, 0);
        for (String key : strings.keys()) {
            System.out.println(key + "->" + strings.get(key));
            if (strings.get(key) > strings.get(max)) {
                max = key;
            }
        }
        System.out.println(max + "->" + strings.get(max));
    }
}
