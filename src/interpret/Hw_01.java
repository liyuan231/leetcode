package interpret;

import java.io.IOException;

public class Hw_01 {
    private static final int len = 20;
    private static final String[] table = new String[]{"begin", "end", "integer", "real"};
    private static final char[] codes = new char[]{'{', '}', 'a', 'c'};

    static class CodeVal {
        public char code;//单词的类别
        public String val;//单词值

        public CodeVal(char code, String val) {
            this.code = code;
            this.val = val;
        }

        public CodeVal() {

        }
    }

    /**
     * 查基本字表函数
     *
     * @param token
     * @return
     */
    public char reverse(String token) {
        for (int i = 0; i < codes.length; i++) {
            if (token.equals(table[i])) {
                return codes[i];
            }
        }
        return 'i';
    }

    public CodeVal scanner(String buf, int i) {
        CodeVal node = new CodeVal();
        StringBuilder token = new StringBuilder();
        if (buf.charAt(i) >= 'a' && buf.charAt(i) <= 'z') {
            while (buf.charAt(i) >= 'a' && buf.charAt(i) <= 'z' || buf.charAt(i) >= '0' && buf.charAt(i) <= '9') {
                token.append(buf.charAt(i++));
            }
            String s = token.toString();
            node.code = reverse(s);
            if (node.code == 'i') {
                node.val = s;
            }
            return node;
        } else if (buf.charAt(i) >= '0' && buf.charAt(i) <= '9') {
            while (buf.charAt(i) >= '0' && buf.charAt(i) <= '9') {
                token.append(buf.charAt(i++));
            }
            if (buf.charAt(i) == '.') {
                token.append(buf.charAt(i++));
                while (buf.charAt(i) >= '0' && buf.charAt(i) <= '9') {
                    token.append(buf.charAt(i++));
                }
                node.code = 'y';
            } else {
                node.code = 'x';
            }
            String s = token.toString();
            node.val = s;
        } else if (buf.charAt(i) == '.') {
            token.append(buf.charAt(i++));
            if (buf.charAt(i) >= '0' && buf.charAt(i) <= '9') {
                while (buf.charAt(i) >= '0' && buf.charAt(i) <= '9') {
                    token.append(buf.charAt(i++));
                }
                node.code = 'y';
                node.val = token.toString();
            } else {
                System.out.println("Error word->" + token);
                throw new IllegalArgumentException(token.toString());
            }
        }
        switch (buf.charAt(i)) {
            case ',': {
                node.code = ',';
                break;
            }
            case ';': {
                node.code = ';';
                break;
            }
            case '(': {
                node.code = '(';
                break;
            }
            case ')': {
                node.code = ')';
                break;
            }
            case '=': {
                node.code = '=';
                break;
            }
            case '+': {
                if (buf.charAt(++i) == '+') {
                    node.code = '$';
                } else {
                    node.code = '+';
                    i--;
                }
                break;
            }
            case '*': {
                node.code = '*';
                break;
            }
            case '#': {
                node.code = '#';
                break;
            }
            default: {
                throw new IllegalArgumentException(i + ":" + buf.charAt(i));
            }
        }
        i++;
        return node;

    }

    public static void main(String[] args) throws IOException, InterruptedException {
//        String[] strs = new String[]{"A", "B", "C", "D"};
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < strs.length; j++) {
//                int finalI = j;
//                Thread thread = new Thread(() -> {
//                    System.out.print(strs[finalI] + finalI + " ");
//                });
//                thread.start();
//                thread.join();
//            }
//            Thread.sleep(100);
//            System.out.println();
//        }
    }
}
