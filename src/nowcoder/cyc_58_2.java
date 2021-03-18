package nowcoder;

public class cyc_58_2 {

    public static void main(String[] args) {
        String s = "abcXYZdef";
        int k = 3;
        System.out.println(LeftRotateString(s, k));
    }

    public static String LeftRotateString(String str, int n) {
        if (str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    /**
     * 反转[i,j]之间的字符
     *
     * @param chars
     * @param i
     * @param j
     */
    private static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
