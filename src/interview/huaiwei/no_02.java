package interview.huaiwei;

public class no_02 {
    public static void main(String[] args) {
        String str = "ABCDACDDCADCEFA";
        boolean[][] book = new boolean[ str.length()][str.length()];
        int max = 1;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i - j < 2) {
                    book[i][j] = str.charAt(i) == str.charAt(j);
                } else {
                    book[i][j] = book[i - 1][j + 1] && str.charAt(i) == str.charAt(j);
                }
                if (book[i][j] && i - j + 1 > max) {
                    max = i - j + 1;
                    start = i;
                }
            }
        }
        System.out.println(str.substring(start-max+1,start+1));
    }
}
