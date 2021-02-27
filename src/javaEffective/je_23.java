package javaEffective;

public class je_23 {
    public static void main(String[] args) {
//        new je_24.Class2()
    }
}

abstract class Figure {
    abstract double area();
}

class Circle extends Figure {
    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Figure {
    final double length;
    final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return width * length;
    }
}
