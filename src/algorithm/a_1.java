package algorithm;

import edu.princeton.cs.algs4.*;
import org.junit.Assert;
import org.junit.Test;

public class a_1 {
    private final static int[] nums = new int[]{1, 2, 3};


    public static void main(String[] args) {
//        Bag
//        Transaction
        int N = 1000;
        for (int i = 0; i < N; i++) {
            double x = Math.random();
            double y = Math.random();
            Point2D point2D = new Point2D(x,y);
            point2D.draw();

        }


    }

    @Test
    public void test1() {

    }
}
