package leetcode;

public class l_69 {
    public static void main(String[] args) {
        for(int i=2;i<=15;i++){
            System.out.println(i);
            System.out.println(i+":"+mySqrt(i));
        }
    }

    public static int mySqrt(int x) {
        long left = 0;
        long right = x / 2 + 1;
        long mid = -1;
        while (left < right) {
            mid = left + (right - left + 1) / 2;
            long ans = mid * mid;
            if (ans > x) {
                right = (mid - 1);
            } else {
                left = mid;
            }
        }
        return (int) left;
    }
}
