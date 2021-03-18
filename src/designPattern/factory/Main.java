package designPattern.factory;

public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape circle = factory.getShape("y");
        circle.draw();
    }

}
