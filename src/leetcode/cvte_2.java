package leetcode;

public class cvte_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 5, 1, 1};
        nums = new int[]{3,2,1,0,5,1};
        System.out.println(cloudLadderGame(nums));
    }

    public static boolean cloudLadderGame(int[] buff) {
//        int[] book = new int[buff.length];
        int i = 0;
        while (i < buff.length) {
            if(i>=buff.length-1){return true;}
            if(i!=buff.length-1&&buff[i]==0){return false;}
            int step = buff[i];
            int max = 0;
            int next = -1;
            for (int j = i + 1; j <= i + step&&j<buff.length; j++) {
                if (buff[j] + j - i > max) {
                    max = buff[j] + j - i;
                    next = j;
                }
            }
            i = next;
            System.out.println(i + " - >" + max);
        }
        return false;

    }
}

