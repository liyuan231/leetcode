package designPattern.abstractFactory_;

public class Main {
    public static void main(String[] args) {
        ShapeAndColorFactory factory = new ShapeAndColorFactory();
        Color red = factory.getColor("red");
        red.fill();
        Shape shape = factory.getShape("rect");
        shape.draw();
        System.out.println(red);
        System.out.println(shape);
    }
}
