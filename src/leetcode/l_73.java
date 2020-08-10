package leetcode;

import java.util.ArrayList;
import java.util.Map;

public class l_73 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,1,1,1},
                {1,0,0,1},
                {1,2,3,4}
        };
        setZeroes(nums);
    }

    public static void setZeroes(int[][] matrix) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                   arrayList.add(new int[]{i,j});
                }
            }
        }
       for(int i=0;i<arrayList.size();i++){
           int[] tmp = arrayList.get(i);
           for(int j=0;j<matrix.length;j++){
               matrix[j][tmp[1]] = 0;
           }
           for(int j=0;j<matrix[0].length;j++){
               matrix[tmp[0]][j] = 0;
           }
       }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
