package cyc;

public class l_461 {
    public static void main(String[] args) {
        int x = 1,y=4;
        System.out.println(hammingDistance(x, y));
    }

    public static int hammingDistance(int x, int y) {
        int t = x ^ y;
        int count = 0;
        while (t != 0) {
            t = t & (t - 1);
            count++;
        }
        return count;
    }
}
