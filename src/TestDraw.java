import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import org.junit.Test;

import java.util.LinkedList;

public class TestDraw {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(0.005);
        StdDraw.enableDoubleBuffering();

        Point2D[] points = new Point2D[12];
        points[0] = new Point2D(72, 84);
        points[1] = new Point2D(50, 63);
        points[2] = new Point2D(81, 77);
        points[3] = new Point2D(74, 78);
        points[4] = new Point2D(94, 90);
        points[5] = new Point2D(86, 75);
        points[6] = new Point2D(59, 49);
        points[7] = new Point2D(83, 79);
        points[8] = new Point2D(65, 77);
        points[9] = new Point2D(33, 52);
        points[10] = new Point2D(88, 74);
        points[11] = new Point2D(81, 90);

        // draw p = (x0, x1) in red
//        Point2D p = new Point2D(0, 0);
//        StdDraw.setPenColor(StdDraw.RED);
//        StdDraw.setPenRadius(0.02);
//        p.draw();

        // draw line segments from p to each point, one at a time, in polar order
        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.BLUE);
//        Arrays.sort(points, p.polarOrder());
        int sumX = 0;
        int sumY = 0;
        for (int i = 0; i < points.length; i++) {
            sumX += points[i].x();
            sumY += points[i].y();
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setPenRadius(0.02);
            points[i].draw();
            StdDraw.pause(100);
        }
        Point2D point2D0 = new Point2D(0, 32.12884);
        Point2D point2D1 = new Point2D(100, 90.28284);
        StdDraw.setPenRadius(0.001);
        point2D0.drawTo(point2D1);
        StdDraw.show();
        System.out.println(sumX / 12);
        System.out.println(sumY / 12);
    }

    @Test
    public void test0() {
        Point2D[] points = new Point2D[12];
        points[0] = new Point2D(72, 84);
        points[1] = new Point2D(50, 63);
        points[2] = new Point2D(81, 77);
        points[3] = new Point2D(74, 78);
        points[4] = new Point2D(94, 90);
        points[5] = new Point2D(86, 75);
        points[6] = new Point2D(59, 49);
        points[7] = new Point2D(83, 79);
        points[8] = new Point2D(65, 77);
        points[9] = new Point2D(33, 52);
        points[10] = new Point2D(88, 74);
        points[11] = new Point2D(81, 90);

        int avgX = 0;
        int avgY = 0;
        for (Point2D point : points) {
            avgX += point.x();
            avgY += point.y();
        }
        avgX = avgX / points.length;
        avgY = avgY / points.length;


        double up = 0d;
        double down = 0d;
        for (Point2D point : points) {
            up += (point.x() - avgX) * (point.y() - avgY);
            down += Math.pow(point.x() - avgX, 2);
        }
        System.out.println(up);
        System.out.println(down);
        double b1 = up / down;
        System.out.println("b1=" + b1);


        double b0 = avgY - avgX * b1;
        System.out.println("b0=" + b0);


    }
    @Test
    public void test01(){
//        LinkedList
    }
}
