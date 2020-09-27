package leetcode;

public class l_168 {
    public static void main(String[] args) {
        int n = 701;
        System.out.println(convertToTitle(n));
    }

    public static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n != 0) {
            n--;
            int remainder = n % 26;
            result.append((char)(remainder+'A'));
            n = n / 26;
        }
        return result.reverse().toString();
    }
}
