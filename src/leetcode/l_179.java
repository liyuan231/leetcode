package leetcode;

import java.util.Arrays;

public class l_179 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 0, 0};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        int k = 0;
        for (int num : nums) {
            strings[k++] = String.valueOf(num);
        }
        Arrays.sort(strings, (o1, o2) -> {
            return (o1 + o2).compareTo(o2 + o1);
        });

//        for (String string : strings) {
//            System.out.print(string + " ");
//        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }
        int indexOfZero = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '0') {
                indexOfZero++;
            } else {
                break;
            }
        }
        if (indexOfZero != 0) {
            stringBuilder.delete(0, indexOfZero - 1);
        }
//        System.out.println();
        return stringBuilder.toString();
    }
}
