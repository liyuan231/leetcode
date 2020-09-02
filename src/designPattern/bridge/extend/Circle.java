package designPattern.bridge.extend;

import designPattern.bridge.DrawApi;

public class Circle implements DrawApi {
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing circle!");
    }
}
