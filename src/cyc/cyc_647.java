package cyc;

public class cyc_647 {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(solve(s));
    }

    public static int solve(String s) {
        StringBuilder tmp = new StringBuilder();
        boolean[] visited = new boolean[s.length()];
        backtrack(s, tmp, 0, visited);
        return count;
    }

    private static int count = 0;

    private static void backtrack(String s, StringBuilder tmp, int curIndex, boolean[] visited) {
        if (huiwen(tmp.toString())) {
            count++;
        }
        if (tmp.length() == s.length()) {
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) {
                return;
            }
            tmp.append(s.charAt(i));
            visited[i] = true;
            backtrack(s, tmp, i + 1, visited);
            visited[i] = false;
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    private static boolean huiwen(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(s.length() - i - 1) != s.charAt(i)) {
                return false;
            }
        }
        System.out.println(s);
        return true;
    }
}
