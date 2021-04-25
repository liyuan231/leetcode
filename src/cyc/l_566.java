package cyc;

public class l_566 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2},
                {3, 4}
        };
        int[][] ints = matrixReshape(nums, 1, 4);
        for (int i = 0; i < ints.length; i++) {
            for (int i1 = 0; i1 < ints[i].length; i1++) {
                System.out.print(ints[i][i1]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) {
            return nums;
        }
        int[] res = new int[nums.length * nums[0].length];
        for (int i = 0, j = 0; i < nums.length; i++) {
            for (int i1 = 0; i1 < nums[i].length; i1++) {
                res[j++] = nums[i][i1];
            }
        }
        int[][] result = new int[r][c];
        for (int i = 0, j = 0; i < result.length; i++) {
            for (int i1 = 0; i1 < result[i].length; i1++) {
                result[i][i1] = res[j++];
            }
        }
        return result;
    }
}
