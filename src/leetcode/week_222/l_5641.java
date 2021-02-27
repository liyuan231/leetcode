package leetcode.week_222;

import java.util.Arrays;
import java.util.Comparator;

public class l_5641 {
    public static void main(String[] args) {
        int[][] boxTypes = new int[][]{
                {1, 3}, {2, 2}, {3, 1}
        };
        boxTypes =new int[][]{
                {5,10},
                {2,5},
                {4,7},
                {3,9}
        };
        int truckSize = 4;
        truckSize = 10;
        System.out.println(maximumUnits(boxTypes, truckSize));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        //使用可装载最大容量进行排序
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -o1[1] + o2[1];
            }
        });
        for (int[] boxType : boxTypes) {
            System.out.println(Arrays.toString(Arrays.stream(boxType).toArray()));
        }
        int res = 0;
        for (int[] boxType : boxTypes) {
            if (boxType[0] <= truckSize) {
                truckSize = truckSize - boxType[0];
                res += boxType[0] * boxType[1];
            } else {
                res += truckSize * boxType[1];
                truckSize = 0;
            }
        }
        return res;
    }

}
