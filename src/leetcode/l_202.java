package leetcode;

public class l_202 {
    public static void main(String[] args) {
        System.out.println(isHappy(116));
    }


    public static int next(int n) {
        int i;
        int sum = 0;
        while (n != 0) {
            i = n % 10;
            sum += i * i;
            n = n / 10;
        }
        return sum;

    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = next(slow);
            fast = next(next(fast));
            if(slow==1||fast==1){
                return true;
            }
        }
        while (slow != fast);
        return false;
    }
}
