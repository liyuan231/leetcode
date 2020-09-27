package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class l_187 {
    public static void main(String[] args) {
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> repeatedDnaSequences = findRepeatedDnaSequences(str);
        for (String repeatedDnaSequence : repeatedDnaSequences) {
            System.out.println(repeatedDnaSequence);
        }
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String source = s.substring(i, i + 10);
            if (set.contains(source)) {
                result.add(source);
            } else {
                set.add(source);
            }
        }
        List<String> ans = new ArrayList<>();
        ans.addAll(result);
        return ans;
    }
}
