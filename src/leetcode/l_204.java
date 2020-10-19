package leetcode;

public class l_204 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
    }


    public static int countPrimes(int n) {
        if(n<=1){return 0;}
        boolean[]book = new boolean[n];
        int count=0;
        for(int i=2;i<n;i++){
            if(!book[i]){//若其是质数
                count++;
                for(int j=i+i;j<n;j+=i){
                    book[j] = true;//不是质数
                }
            }
        }
        return count;
    }
}
