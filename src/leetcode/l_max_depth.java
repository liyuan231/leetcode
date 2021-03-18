package leetcode;

public class l_max_depth {
    public static void main(String[] args) {
        String s = "(())(((())))((()))";
        char[] chars = s.toCharArray();
        int max = 0;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
            } else {
                count--;
            }
            max = Math.max(count, max);
        }
        System.out.println(max);

        System.out.println("========");
        String sn = "-0";
        char[] chars1 = sn.toCharArray();
        boolean positive = true;
        int i = 0;
        if (chars1[0] == '-') {
            positive = false;
            i++;
        }

        int res = 0;
        for (; i < chars1.length; i++) {
            int i1 = chars1[i] - '0';
            res = res * 10 + i1;
        }
        System.out.println(positive?res:-res);

    }
}
