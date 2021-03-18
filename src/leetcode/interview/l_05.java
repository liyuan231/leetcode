package leetcode.interview;

public class l_05 {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("hello world");
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(StringBuffer str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        char[] res = new char[str.length() + 3 * count];
        int j = res.length - 1, i = str.length();
        while (i-- > 0) {
            char c1 = str.charAt(i);
            if (c1 == ' ') {
                res[j--] = '0';
                res[j--] = '2';
                res[j--] = '%';
            } else {
                res[j--] = c1;
            }
        }
        System.out.println(res.toString());
        return new String(res);
    }
}
