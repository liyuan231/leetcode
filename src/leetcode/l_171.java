package leetcode;

public class l_171 {
    public static void main(String[] args) {
        String s = "A";
        System.out.println(titleToNumber(s));
    }

    public static int titleToNumber(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum += Math.pow(26, s.length() - i - 1) * (s.charAt(i) - 'A' + 1);
        }
        return sum;
    }
}
