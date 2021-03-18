package leetcode.interview;

import java.util.Arrays;
import java.util.Scanner;

public class l_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        String[] strs = new String[num];
        for (int i = 0; i < num; i++) {
            strs[i] = input.next();
        }
        String[] solve = solve(strs);
//        System.out.println(Arrays.toString());
        System.out.println("yybeetxjjpddsrxxkyyowwkyyxpplwwivvsnrvvclyydhaayiic");
        for (int i = 0; i < solve.length; i++) {
            System.out.println(solve[i]);
        }
    }

    /**
     * yyybeettxjjjpppddsrxxxkkkyyyooowwwwwkyyxxppplllwwwiivvssnrvvvccclyydddhaaayiic
     * yybeetxjjpddsrxxkyyowwkyyxpplwwivvsnrvvclyydhaayiic
     * @param strings
     * @return
     */

    public static String[] solve(String[] strings) {
        String[] res = new String[strings.length];
        int z = 0;
        for (String string : strings) {
            StringBuilder tmp = new StringBuilder(string);
            for (int i = 0; i < tmp.length(); i++) {
                if (i >= 2 && tmp.charAt(i) == tmp.charAt(i - 1) && tmp.charAt(i) == tmp.charAt(i - 2)) {
                    tmp.deleteCharAt(i-- - 2);
                }
            }
            for (int i = 0; i < tmp.length(); i++) {
                if (i >= 3 && (tmp.charAt(i - 3) == tmp.charAt(i - 2)) && tmp.charAt(i - 1) == tmp.charAt(i)) {
                    tmp.deleteCharAt(i-- - 1);
                }
            }
            res[z++] = tmp.toString();
        }
        return res;
    }
}
