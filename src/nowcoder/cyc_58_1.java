package nowcoder;

public class cyc_58_1 {
    public static void main(String[] args) {
        String s = "nowcoder. a a123m I";
        System.out.println(ReverseSentence(s));
    }

    public static String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverseWord(chars, 0, chars.length - 1);
        for (int i = 0, start = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] == ' ') {
                reverseWord(chars, start, i - 1);
                start = i + 1;
            }
        }
        return new String(chars);
    }

    /**
     * 交换 [i,j]之间的字符
     *
     * @param chars
     * @param start
     * @param end
     */
    private static void reverseWord(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }

    private static void swap(char[] chars, int i, int i1) {
        char tmp = chars[i];
        chars[i] = chars[i1];
        chars[i1] = tmp;
    }
}
