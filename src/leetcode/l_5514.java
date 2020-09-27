package leetcode;

public class l_5514 {
    public static void main(String[] args) {
        String s1 = "34521";
        String s2 = "23415";
        System.out.println(isTransformable(s1, s2));
    }

    public static boolean isTransformable(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < s.length(); i++) {
            s1 = s1 ^ s.charAt(i);
            s2 = s2 ^ t.charAt(i);
        }
        return s1 == s2;

    }

}
