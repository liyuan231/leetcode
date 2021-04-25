package nowcoder;

import java.util.LinkedList;

public class cyc_41_2 {
    private LinkedList<Character> list = new LinkedList<>();
    int[] nums = new int[256];


    public static void main(String[] args) {
        cyc_41_2 cyc_41_2 = new cyc_41_2();
        String s = "google";
        for (int i = 0; i < s.toCharArray().length; i++) {
            cyc_41_2.Insert(s.charAt(i));
            System.out.println(cyc_41_2.FirstAppearingOnce());
        }
    }

    //Insert one char from stringstream
    public void Insert(char ch) {
        nums[ch]++;
        if (nums[ch] == 1) {
            list.add(ch);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (!list.isEmpty() && nums[list.getFirst()] > 1) {
            list.removeFirst();
        }
        Character res = list.peekFirst();
        return res == null ? '#' : res;
    }
}
