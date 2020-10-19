package leetcode;

import java.util.HashMap;
import java.util.Map;

public class l_205 {
    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> s_map = new HashMap<>();
        Map<Character, Integer> t_map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            Integer s_index = s_map.getOrDefault(charS, i);
            s_map.put(charS, s_index);
            Integer t_index = t_map.getOrDefault(charT, i);
            t_map.put(charT, t_index);
            if (!s_index.equals(t_index)) {
                return false;
            }
        }
        return true;
    }
}
