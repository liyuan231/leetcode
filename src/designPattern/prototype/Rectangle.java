package designPattern.prototype;

public class Rectangle extends Shape{
    public Rectangle() {
        setType("RECT");
    }

    @Override
    void draw() {
        System.out.println("drawing a rect.");
    }
}
