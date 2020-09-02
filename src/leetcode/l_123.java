package leetcode;

public class l_123 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (!isValid(chars[i])) {
                i++;
                continue;
            }
            if (!isValid(chars[j])) {
                j--;
                continue;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isValid(char aChar) {
        if (aChar < 48 || (aChar > 57 && aChar < 97) || aChar > 122) {
            return false;
        }
        return true;
    }

}
