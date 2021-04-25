package cyc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cyc_696 {
    public static void main(String[] args) {
        String s = "10101";
        System.out.println(countBinarySubstrings(s));
    }

    public static int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
            } else {
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        System.out.println(Arrays.toString(list.toArray()));
        int res = 0;
        for (int i = 1; i < list.size(); i++) {
            res += Math.min(list.get(i), list.get(i - 1));
        }
        return res;
    }
}
