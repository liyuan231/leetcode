package designPattern.abstractFactory_;

public class ShapeAndColorFactory implements AbstractFactory {
    @Override
    public Color getColor(String color) {
        switch (color) {
            case "red": {
                return new Red();
            }
            case "blue": {
                return new Blue();
            }
            case "green": {
                return new Green();
            }
            default:
                throw new IllegalArgumentException(color);
        }
    }

    @Override
    public Shape getShape(String shape) {
        switch (shape) {
            case "rect": {
                return new Rectangle();
            }
            case "square": {
                return new Square();
            }
            default:
                throw new IllegalArgumentException(shape);
        }
    }
}
