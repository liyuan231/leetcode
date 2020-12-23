package leetcode.week_220;

public class l_5629 {
    public static void main(String[] args) {
        String number = "1-23-45 6";
        number = "123 4-5678";
        number = "12";
        number="123 4-567";
        System.out.println(reformatNumber(number));

    }

    public static String reformatNumber(String number) {
        if (number.length() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == ' ' || number.charAt(i) == '\'' || number.charAt(i) == '-') {
                continue;
            }
            stringBuilder.append(number.charAt(i));
        }
        number = stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        for (int i = 0; i < number.length(); ) {
            int remainLen = number.length() - i;
            if (remainLen > 4 || remainLen == 3) {
                stringBuilder.append(number.charAt(i++)).append(number.charAt(i++)).append(number.charAt(i++)).append('-');
                continue;
            }
            if (remainLen == 4) {
                stringBuilder.append(number.charAt(i++)).append(number.charAt(i++))
                        .append('-').append(number.charAt(i++)).append(number.charAt(i++)).append('-');
                continue;
            }
            if (remainLen == 2) {
                stringBuilder.append(number.charAt(i++)).append(number.charAt(i++)).append('-');
            }
            if (remainLen == 1) {
                stringBuilder.append(number.charAt(i++)).append('-');
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder.toString());
        return "-1";
    }
}
