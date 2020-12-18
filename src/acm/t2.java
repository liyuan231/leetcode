package acm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[][][] nums = new double[n][][];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new double[input.nextInt()][2];
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j][0] = input.nextInt();
                nums[i][j][1] = input.nextInt();
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                double[] ints = nums[i][j];//j个弓箭手以及他们对应的位置
                Map<Double, Integer> map = new HashMap<>();//计算出所有点的斜率。
                for (int z = 0; z < ints.length; z++) {
                    double x1 = ints[0];
                    double y1 = ints[1];
                    for (int a = 1; a < ints.length; a++) {
                        double k = (y1 - ints[1]) / (x1 - ints[0]);
//                        map.put();
                    }
                }
                System.out.println(ints[0] + "<->" + ints[1]);//需要在此处做处理

            }

        }
    }
}
