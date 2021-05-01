package interpret;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class LexicalAnalysis {
    private static class CodeVal {
        int code;
        String val;
    }

    public static void main(String[] args) throws IOException {
        String filepath = "F:\\IdeaProjects\\leetcode\\src\\interpret\\test.txt";
        String text = pretreatment(filepath);
        scan(text);
        System.out.println(pretreatment);
    }

    /**
     * 词法分析，将输入字符串变为二元式表示
     *
     * @param text
     */
    private static void scan(String text) {
        while (true) {
            
        }
    }

    private static String pretreatment(String filepath) throws IOException {
        StringBuilder str = new StringBuilder();
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(filepath)))) {
            int val = -1;
            while ((val = dataInputStream.read()) != -1) {
                str.append((char) val);
            }
        }
        boolean stringFlag = false;
        int size = str.length();
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i > 0 && str.charAt(i) == ' ' && str.charAt(i - 1) == ' ') {
                continue;
            }
            if (str.charAt(i) == '"') {
                stringFlag = !stringFlag;
            }
            if (!stringFlag) {
                if (i < size - 1 && str.charAt(i) == '/' && str.charAt(i + 1) == '/') {
                    i++;
                    while (str.charAt(i) != '\r') {
                        i++;
                    }
                    i++;
                } else if (i < size - 3 && str.charAt(i + 1) == '*' && str.charAt(i + 2) == '*' && str.charAt(i) == '/') {
                    i = i + 3;
                    while (str.charAt(i + 2) != '/' && str.charAt(i + 1) != '*' && str.charAt(i) != '*') {
                        i++;
                    }
                    i = i + 4;
                } else if (i < size - 2 && str.charAt(i) == '/' && str.charAt(i + 1) == '*') {
                    i = i + 2;
                    while (str.charAt(i) != '*' && str.charAt(i + 1) != '/') {
                        i++;
                    }
                    i = i + 2;
                }
            }
            str.setCharAt(j, str.charAt(i));
            j++;
        }
        for (int i = 0; i <= j; i++) {
            if (str.charAt(i) == '\n' || str.charAt(i) == '\r') {
                str.setCharAt(i, ' ');
            }
        }
        int k = 0;
        for (int i = 0; i < j; i++) {
            if (i > 0 && str.charAt(i) == ' ' && str.charAt(i - 1) == ' ') {
                continue;
            }
            str.setCharAt(k, str.charAt(i));
            k++;
        }
        str.setCharAt(k, '#');
        if (str.charAt(0) == ' ') {
            return str.substring(1, k);
        }
        return str.substring(0, k + 1);
    }


}
