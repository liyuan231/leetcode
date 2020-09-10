package leetcode;


import java.util.Stack;

public class l_151 {
    public static void main(String[] args) {
        String str = "";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String str) {
        char[] chars = str.toCharArray();
        Stack<String> stack = new Stack<>();
        int start = 0;
        int end = 0;
        char[] copy = null;
        while (start <= chars.length - 1) {
            if (chars[start] == ' ') {
                start++;
                continue;
            }
            end = start;
            while (end < chars.length && chars[end] != ' ') {
                end++;
            }
            copy = new char[end - start];
            System.arraycopy(chars, start, copy, 0, end - start);
            stack.push(String.valueOf(copy));
            start = end;
        }
        if (stack.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop()).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
