package cyc;

public class l_565 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 0, 3, 1, 6, 2};
        System.out.println(arrayNesting(nums));
    }

    public static int arrayNesting(int[] nums) {
        int[] book = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean[] mark = new boolean[nums.length];
            while (!mark[i] && book[i] == 0) {
                count++;
                mark[i] = true;
                i = nums[i];
            }
            count = book[i]==0?count:book[i];
            max = Math.max(max, count);
        }
        return max;
    }
}
