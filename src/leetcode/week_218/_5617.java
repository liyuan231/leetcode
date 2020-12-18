package leetcode.week_218;

public class _5617 {
    public static void main(String[] args) {
        String command = "GGG";
        System.out.println(interpret(command));
    }

    public static String interpret(String command) {
        StringBuilder stringBuilder = new StringBuilder();
        char c2 = 0;
        for (int i = 0; i < command.length() - 1; i++) {
            char c1 = command.charAt(i);
            c2 = command.charAt(i + 1);
            if (c1 == 'G') {
                stringBuilder.append(c1);
                continue;
            }
            if (c1 == '(' && c2 == ')') {
                stringBuilder.append('o');
                i++;
                continue;
            }
            stringBuilder.append("al");
            i = i + 3;
        }
        if (command.charAt(command.length() - 1) == 'G') {
            stringBuilder.append('G');
        }
        return stringBuilder.toString();
    }

}
