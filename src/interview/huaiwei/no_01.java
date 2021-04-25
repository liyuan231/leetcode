package interview.huaiwei;

public class no_01 {
    public static void main(String[] args) {
        int[][] nums1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] nums2 = new int[][]{
                {4, 5},
                {7, 8},
                {9, 10}
        };

        int sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1[i].length; j++) {
                sum += nums1[i][j] * nums2[j][i];
            }
        }
        System.out.println(sum);
    }
}
