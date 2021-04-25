package interview.huaiwei;

public class l_1209 {
    public static void main(String[] args) {
        String str = "abcd";
        int k = 2;
        System.out.println(removeDuplicates(str, k));

    }

    public static String removeDuplicates(String s, int k) {
        StringBuilder strs = new StringBuilder(s);
        int count = 1;
        for (int i = 1; i < strs.length(); i++) {
            count = strs.charAt(i) == strs.charAt(i - 1) ? count + 1 : 1;
            if (count == k) {
                strs.delete(i - k + 1, i + 1);
                count = 1;
                i = 0;
            }
        }
        return strs.toString();
    }
}
