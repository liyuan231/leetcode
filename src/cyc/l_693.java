package cyc;

public class l_693 {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
    }

    public static boolean hasAlternatingBits(int n) {
        boolean pre = (n & -n) == 1;
        n=n>>1;
        while (n != 0) {
            boolean now = (n & -n) == 1;
            if (now == pre) {
                return false;
            }
            pre = now;
            n = n >> 1;
        }
        return true;
    }
}
