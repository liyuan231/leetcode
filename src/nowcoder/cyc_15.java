package nowcoder;

public class cyc_15 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(10));
    }

    public static int NumberOf1(int n) {
//        String s = Integer.toBinaryString(n);
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
