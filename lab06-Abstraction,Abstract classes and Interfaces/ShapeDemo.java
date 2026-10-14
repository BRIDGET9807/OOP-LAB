/** Exercise 1: abstract Shape with Circle, Rectangle, Square. */
abstract class Shape {
    abstract double area();
    abstract double perimeter();
    public String toString() {
        return String.format("%s area=%.2f perimeter=%.2f", getClass().getSimpleName(), area(), perimeter());
    }
}
class Circle extends Shape {
    private final double r;
    Circle(double r) { this.r = r; }
    double area() { return Math.PI * r * r; }
    double perimeter() { return 2 * Math.PI * r; }
}
class Rectangle extends Shape {
    protected final double w, h;
    Rectangle(double w, double h) { this.w = w; this.h = h; }
    double area() { return w * h; }
    double perimeter() { return 2 * (w + h); }
}
class Square extends Rectangle {
    Square(double side) { super(side, side); }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(3), new Rectangle(4, 5), new Square(4) };
        for (Shape s : shapes) System.out.println(s);
    }
}


 
