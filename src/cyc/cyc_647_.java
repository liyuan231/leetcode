package cyc;

public class cyc_647_ {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String tmp = s.substring(i, j);
                if (huiwen(tmp)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean huiwen(String tmp) {
        for (int i = 0; i < tmp.length() / 2; i++) {
            if (tmp.charAt(i) != tmp.charAt(tmp.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
