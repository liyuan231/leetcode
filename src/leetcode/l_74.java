package leetcode;

public class l_74 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23,30,34,50}
        };
        System.out.println(searchMatrix(nums, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int mid = -1;
        while (top <= bottom) {
            mid = top + (bottom - top) / 2;
            if (matrix[mid][0] > target) {
                bottom = mid - 1;
            } else if (matrix[mid][0] < target) {
                top = mid + 1;
            } else {
                return true;
            }
        }
//        while ()
        System.out.println("top:" + top);
        System.out.println("bottom:" + bottom);
            int left = 1;
            int right = matrix[0].length-1;
            while (left<=right){
                mid = left + (right - left) / 2;
                if (matrix[bottom][mid] > target) {
                    right = mid - 1;
                } else if (matrix[bottom][mid] < target) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
        return false;
    }
}
