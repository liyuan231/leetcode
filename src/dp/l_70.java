package dp;

public class l_70 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        if(n<2){
            return n;
        }
        int[] book = new int[n+1];
        book[1] = 1;
        book[2] = 2;
        for (int i = 3; i <= n; i++) {
            book[i] = book[i - 1] + book[i - 2];
        }
        return book[n];
    }
}
