package cyc;

public class cyc_2_17 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(solve(s, k));
    }

    private static String solve(String s, int k) {
        char[] chars = s.toCharArray();
        int l = s.length() - k;
        reverse(chars, 0, l);
        reverse(chars, l, s.length());
        reverse(chars, 0, s.length());
        return new String(chars);
    }

    private static void reverse(char[] chars, int lo, int hi) {
        for (int i = lo; i < (lo + hi) / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[hi - i + lo - 1];
            chars[hi - i + lo - 1] = tmp;
        }
    }
}
