package leetcode;

public class l_58 {
    public static void main(String[] args) {
        String str = "";
        System.out.println(lengthOfLastWord(str));
    }

    public static int lengthOfLastWord(String s) {
//        if (s.equals("")) {
//            return 0;
//        }
        int len = 0;
        boolean mark = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ' && mark) {
                break;
            }
            if (c != ' ') {
                mark = true;
                len++;
            }
        }
        System.out.println(len);
        return len;
    }
}
