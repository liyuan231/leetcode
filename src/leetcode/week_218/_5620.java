package leetcode.week_218;

import org.junit.Test;

public class _5620 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(concatenatedBinary(n));
    }

    public static int concatenatedBinary(int n) {
        int ans = 0;
        int mod = 1000000007;
        for (int i = 1; i <= n; i++) {
            String b = Integer.toBinaryString(i);
            int len = b.length();
            ans = (int) (ans * Math.pow(2, len) % mod);
            ans = (ans + i) % mod;
        }
        return ans;
    }

    @Test
    public void test01() {
        String _12 = "1101110010111011110001001101010111100";
        int v = (int) (Math.pow(10, 9) + 7);
        System.out.println(v);
        String s = Integer.toBinaryString(v);
        System.out.println(_12);
        System.out.println(s);
        System.out.println(_12.length());
        System.out.println(s.length());

        Integer integer1 = Integer.valueOf(_12);
        System.out.println(integer1);
        System.out.println(Integer.valueOf(s));
        System.out.println(Long.parseLong("1101111101100111000100101000010111011", 2));
    }
}
/**
 * 1101110010111011110001001101010111100
 * 0000000111011100110101100101000000111
 * 1101111101100111000100101000010111011
 * ----%
 */
