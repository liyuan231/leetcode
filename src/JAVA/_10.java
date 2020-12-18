package JAVA;

import org.junit.Test;

import java.awt.*;
import java.util.Objects;

public class _10 {
    public static void main(String[] args) {
//        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        ColorPoint p = new ColorPoint(1, 2, Color.RED);
        System.out.println(p.equals(cp));
        System.out.println(cp.equals(p));
//        Arrays.equals()
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class ColorPoint {
        private Point point;
        private Color color;

        public ColorPoint(int x, int y, Color color) {
            this.point = new Point(x, y);
            this.color = Objects.requireNonNull(color);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ColorPoint cp = (ColorPoint) o;
            return cp.point.equals(point) && cp.color.equals(color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(point, color);
        }
    }
    @Test
    public void tets01() {
        PhoneNumber phoneNumber1 = new PhoneNumber((short) 1, (short) 2, (short) 3);
        PhoneNumber phoneNumber2 = new PhoneNumber((short) 1, (short) 2, (short)4);

        System.out.println(phoneNumber1.equals(phoneNumber2));
    }

}


final class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 999, "line num");
    }

    private short rangeCheck(short val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber) o;
        return areaCode == pn.areaCode &&
                prefix == pn.prefix &&
                lineNum == pn.lineNum;
    }




}
