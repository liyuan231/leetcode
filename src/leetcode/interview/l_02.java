package leetcode.interview;

public class l_02 {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        int[] duplicate = new int[1];
        duplicate(nums, nums.length, duplicate);
    }

    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        if(numbers==null||numbers.length==0){
            duplication[0] = -1;
            return  false;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != numbers[numbers[i]]) {
                int tmp1 = numbers[i];
                int tmp2 = numbers[numbers[i]];
                numbers[numbers[i]] = tmp1;
                numbers[i] = tmp2;
//                i--;
            } else if (numbers[i] == i) {
            } else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
