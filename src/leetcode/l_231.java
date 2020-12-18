package leetcode;

public class l_231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(6));
    }

    public static boolean isPowerOfTwo(int n) {
        return (n > 0) && (n&-n)==n;
    }
}
