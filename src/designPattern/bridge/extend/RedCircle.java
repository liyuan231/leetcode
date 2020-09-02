package designPattern.bridge.extend;

public class RedCircle extends Circle {
    @Override
    public void drawCircle(int radius, int x, int y) {
//        super.drawCircle(radius, x, y);
        System.out.println("Drawing red circle!");
    }

    public RedCircle(int x, int y, int radius) {
        super(x, y, radius);

    }
}
