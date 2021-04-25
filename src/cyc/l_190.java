package cyc;

public class l_190 {
    public static void main(String[] args) {
        System.out.println(reverseBits(2));
    }

    public static int reverseBits(int n) {
        int times = 32;
        int res = 0;
        while (times-- != 0) {
            res = res << 1;
            res += n & 1;
            n = n >> 1;
        }
        return res;
    }
}
