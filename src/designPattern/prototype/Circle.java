package designPattern.prototype;

public class Circle extends Shape {

    public Circle() {
        setType("circ");
    }

    @Override
    void draw() {
        System.out.println("drawing circle.");
    }
}
