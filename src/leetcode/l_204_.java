package leetcode;

public class l_204_ {
    public static void main(String[] args) {
        int n=10;
        System.out.println(countPrimes(n));
    }

    public static int countPrimes(int n) {
        if(n<=1){
            return 0;
        }
        boolean[]book = new boolean[n];
        for(int i=2;i*i<n;i++){
            if(!book[i]){
                for(int j=i*i;j<n;j+=i){
                    book[j]=true;
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(book[i]){
                count++;
            }
        }
        return count;
    }

}
