package data_mining;

public class ID3 {
    public static void main(String[] args) {
        String[] s = new String[]{"不买", "不买", "买", "买", "买", "不买", "买", "不买", "买", "买", "买", "买", "买", "不买"};
        int count_buy = 0;
        int count_not_buy = 0;
        for (String s1 : s) {
            if (s1.equals("买")) {
                count_buy++;
            } else {
                count_not_buy++;
            }
        }
        double p1 = count_buy/(count_buy+count_not_buy);
        System.out.println(p1);
    }
}
