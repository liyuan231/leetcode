package leetcode;

public class l_191 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(1));
    }

    public static int hammingWeight(int n) {
        int times=32;
        int ans=0;
        while (times!=0){
            times--;
            int tmp=n&1;
            if(tmp==1){
                ans++;
            }
            n=n>>1;
        }
        return ans;
    }
}
