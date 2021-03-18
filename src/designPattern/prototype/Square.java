package designPattern.prototype;

public class Square extends Shape{
    public Square() {
        setType("square");
    }

    @Override
    void draw() {
        System.out.println("drawing a square.");
    }
}
