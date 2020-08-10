package leetcode;

public class l_70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }

    public static int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int[] book = new int[n + 1];
        book[0] = 1;
        book[1] = 1;
        for (int i = 2; i < book.length; i++) {
            book[i] = book[i - 1] + book[i - 2];
        }
        return book[book.length - 1];
    }
}
