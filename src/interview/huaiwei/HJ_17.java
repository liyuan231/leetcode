package interview.huaiwei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ_17 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        String[] splits = str.split(";");
        int x = 0, y = 0;
        for (int i = 0; i < splits.length; i++) {
            String command = splits[i];
            char c;
            if (command.length() < 2 || !isValidCharacter(c = command.charAt(0)) || !isValid(command)) {
                continue;
            }
            Integer num = Integer.parseInt(command.substring(1));
            if (c == 'A') {
                x -= num;
            } else if (c == 'S') {
                y -= num;
            } else if (c == 'D') {
                x += num;
            } else if (c == 'W') {
                y += num;
            }
        }
        System.out.println(x + "," + y);
    }

    private static boolean isValidCharacter(char c) {
        switch (c) {
            case 'A':
                return true;
            case 'S':
                return true;
            case 'D':
                return true;
            case 'W':
                return true;
        }
        return false;
    }

    private static boolean isValid(String num) {
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) < '0' || num.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
