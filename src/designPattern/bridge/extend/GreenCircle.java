package designPattern.bridge.extend;

public class GreenCircle extends Circle{
    public GreenCircle(int x, int y, int radius) {
        super(x, y, radius);
    }

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing green circle!");
    }
}
