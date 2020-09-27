package leetcode;

public class l_172 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(trailingZeroes(n));
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int N = i;
            while (N > 0) {
                if (N % 5 == 0) {
                    N = N / 5;
                    count++;
                }else {
                    break;
                }
            }
        }
        return count;
    }
}
