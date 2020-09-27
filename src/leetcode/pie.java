package leetcode;

public class pie {
    public static void main(String[] args) {
        int numberOfPie = 3;
        int numberOfFriends = 3;
        int[] radius = new int[]{4, 3, 3};
        System.out.println(pie(numberOfPie, numberOfFriends + 1, radius));
    }

    private static double pie(int numberOfPie, int numberOfFriends, int[] radius) {
        double sum = 0d;
        double[] eachSums = new double[radius.length];
        for (int i = 0; i < numberOfPie; i++) {
            eachSums[i] = radius[i] * radius[i];
            sum += eachSums[i];
        }

        double left = 0;
        double right = sum / numberOfFriends;
        double mid = 0;
        while (right - left > 1e-7) {
            mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < numberOfPie; i++) {
                count += eachSums[i] / mid;
            }
            if (count < numberOfFriends) {
                right = mid;
            } else {
                left = mid;
            }
            System.out.println(mid * Math.PI);
        }
        System.out.println(mid * Math.PI);
        return -1;

    }
}
