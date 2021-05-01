package cyc;

public class l_345 {
    public static void main(String[] args) {
        String str = "ai";
        System.out.println(reverseVowels(str));
    }

    public static String reverseVowels(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int i = -1, j = chars.length;
        while (i < j) {
            while (i != s.length() - 1 && !isVowel(chars[++i])) {

            }
            while (j != 0 && !isVowel(chars[--j])) {

            }
            if (i > j) {
                break;
            }
            swap(chars, i, j);
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
//        chars[i] = (char) (chars[i] ^ chars[j]);
//        chars[j] = (char) (chars[i] ^ chars[j]);
//        chars[i] = (char) (chars[i] ^ chars[j]);
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    private static boolean isVowel(Character c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
