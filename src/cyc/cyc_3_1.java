package cyc;

public class cyc_3_1 {
    public static void main(String[] args) {
        String str1 = "AABCD";
        String str2 = "ABCD";
        System.out.println(solve(str1, str2));
    }

    private static boolean solve(String str1, String target) {
        if (target.length() > str1.length()) {
            return false;
        }
        String original = str1 + str1;
        for (int i = 0, j = 0; i <= original.length() - target.length(); i++) {
            int k = i;
            while (j < target.length() && target.charAt(j++) == original.charAt(k++)) {
//                System.out.println(1);
            }
            if (j == target.length()) {
                return true;
            }
            j = 0;
        }
        return false;
    }
}
