package leetcode;

public class l_190 {
    public static void main(String[] args) {
        int i = -3;
        System.out.println(reverseBits(i));
    }

    public static int reverseBits(int n) {
        int times = 32;
        int ans=0;
        while (times != 0) {
            times--;
            ans = ans<<1;
            ans+=n&1;
            n=n>>1;
        }
        return ans;
    }
}
