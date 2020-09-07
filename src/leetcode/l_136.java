package leetcode;

public class l_136 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 1, 0, 1, 99};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i :nums) {
//            a^=nums[i];
            b = (b ^ i) & ~a;
            a = (a ^ i) & ~b;
        }
        System.out.println("a:"+a);
        System.out.println("b:"+b);
        return b;
    }
}
