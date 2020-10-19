package leetcode;

public class l_01 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(tribonacci(n));
    }

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int t_0 = 0;
        int t_1 = 1;
        int t_2 = 1;
        int t_3 = t_2 + t_1 + t_0;
        for (int i = 3; i <= n; i++) {
            t_3 = t_2 + t_1 + t_0;
            t_0 = t_1;
            t_1 = t_2;
            t_2 = t_3;
        }
        return t_3;
    }
}
