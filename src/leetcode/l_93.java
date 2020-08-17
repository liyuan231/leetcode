package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 */
public class l_93 {
    public static void main(String[] args) {
        String s = "25525511135";
        List<String> strings = restoreIpAddresses(s);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> result = new LinkedList<>();
        backtrack(s, stringBuilder, result, 0);
        return result;
    }

    private static void backtrack(String s, StringBuilder stringBuilder, List<String> result, int depth) {
        if (depth == 4) {
            return;
        }
        System.out.println(stringBuilder.toString());
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            backtrack(s, stringBuilder, result, depth + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
