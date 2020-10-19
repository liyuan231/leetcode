package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class l_02 {
    public static void main(String[] args) {
        String s = "a/*comment\", \"line\", \"more_comment*/b";
        String[] strings = s.split(",");
        System.out.println(Arrays.toString(removeComments(strings).toArray()));
    }

    public static List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < source.length; i++) {
            int i1 = source[i].indexOf("/*");
            int i2 = source[i].indexOf("*/");
            //0代表 /*
            //1 代表 */
            if (i1 != -1) {
                stack.add(new int[]{0,i, i1});
            }
            if (i2 != -1) {
                stack.add(new int[]{1,i, i2});
            }
        }
        for (int[] ints : stack) {

            System.out.println(Arrays.toString(Arrays.stream(ints).toArray()));
        }
        return result;
    }
}
