package algorithm;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Comparator;

public class a1_2_1 implements Comparator,Comparable {
    public static void main(String[] args) {
        int n = 3;
        ArrayList<Point2D> point2DS = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            Point2D point2D = new Point2D(x, y);
            point2DS.add(point2D);
            point2D.draw();
        }
        double min = 1;
        for (int i = 0; i < point2DS.size(); i++) {
            for (int j = i + 1; j < point2DS.size(); j++) {
                min = Math.min(min,point2DS.get(i).distanceTo(point2DS.get(j)));
            }
        }
        System.out.println(min);
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

























































}
