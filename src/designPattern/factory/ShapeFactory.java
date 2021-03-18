package designPattern.factory;

public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if ("circle".equals(shapeType)) {
            return new Circle();
        } else if ("rect".equals(shapeType)) {
            return new Rectangle();
        } else if ("square".equals(shapeType)) {
            return new Square();
        }
        throw new IllegalArgumentException(shapeType);
    }

}
