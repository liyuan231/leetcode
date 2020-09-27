package leetcode;

import java.util.*;

public class l_5513 {


    public static void main(String[] args) {
        int[][] points = new int[][]{
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };
        System.out.println(minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {
        IdentityHashMap<Integer, Integer> map = new IdentityHashMap<>();
        int fare = 0;
        for (int i = 0; i < points.length; i++) {
           
        }
        return fare;
    }

    private static int calculate(int[] point, int[] point1) {
        return Math.abs(point[0] - point1[0]) + Math.abs(point[1] - point1[1]);
    }
}
