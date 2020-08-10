package leetcode;

public class l_67 {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        int aLen = a.length();
        int bLen = b.length();
        char A;
        char B;
        StringBuilder result = new StringBuilder();
        char supplement = '0';
        char bitAns = '1';
        while (maxLen > 0) {
            maxLen--;
            A = '0';
            B = '0';
            if (aLen > 0) {
                A = a.charAt(aLen - 1);
                aLen--;
            }
            if (bLen > 0) {
                B = b.charAt(bLen - 1);
                bLen--;
            }
            System.out.println(A + ":" + B);
            if (supplement == '0') {
                if (A == '1' && B == '1') {
                    bitAns = '0';
                    supplement = '1';
                } else if (A == '0' && B == '0') {
                    bitAns = '0';
                    supplement = '0';
                } else {
                    bitAns = '1';
                    supplement = '0';
                }
            } else {
                if (A == '1' && B == '1') {
                    bitAns = '1';
                    supplement = '1';
                } else if (A == '0' && B == '0') {
                    bitAns = '1';
                    supplement = '0';
                } else {
                    bitAns = '0';
                    supplement = '1';
                }
            }
            result.append(bitAns);
        }
        if (supplement == '1') {
            result.append('1');
        }
        for (int i = 0; i < result.length() / 2; i++) {
            A = result.charAt(i);
            result.setCharAt(i, result.charAt(result.length() - 1 - i));
            result.setCharAt(result.length() - 1 - i, A);
        }
        return result.toString();
    }
}
