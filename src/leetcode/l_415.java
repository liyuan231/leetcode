package leetcode;

public class l_415 {

    public static void main(String[] args) {
        String s1 = "789";
        String s2 = "6789";
        System.out.println(addStrings(s1, s2));
    }

    public static String addStrings(String num1, String num2) {
        char[] c1s = num1.toCharArray();
        char[] c2s = num2.toCharArray();
        int i = c1s.length - 1, j = c2s.length - 1;
        boolean flag = false;
        int times = Math.max(i, j) + 1;
//        char[] ans = new char[times + 1];
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? c1s[i] - '0' : 0;
            int y = j >= 0 ? c2s[j] - '0' : 0;
            int tmp = x + y + (flag ? 1 : 0);
            int left = tmp % 10;
            int i1 = left + '0';
            flag = tmp >= 10;
            res.append((char)i1);
            j--;
            i--;
            times--;
        }
        if (flag) {
//            ans[times] = '1';
            res.append('1');
        }
        return res.reverse().toString();
    }
}
