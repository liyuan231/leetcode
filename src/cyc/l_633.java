package cyc;

public class l_633 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(1));
    }

    public static boolean judgeSquareSum(int c) {
        int lo = 0, hi = (int) Math.sqrt(c);
        while (lo <= hi) {
            int sum = lo * lo + hi * hi;
            if (sum == c) {
                System.out.println(lo+"<->"+hi);
                return true;
            } else if (sum < c) {
                lo++;
            } else {
                hi--;
            }
        }

        return false;
    }

}
