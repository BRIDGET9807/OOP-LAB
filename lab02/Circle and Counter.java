package lab02;
public class Circle {
    private static int count = 0;
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
        count++;
    }

    public Circle() { this(1.0); }          // default radius 1.0

    public static int getCount() { return count; }
    public double area() { return Math.PI * radius * radius; }

    public static void main(String[] args) {
        Circle a = new Circle(2.5);
        Circle b = new Circle();
        System.out.printf("a area=%.2f, b area=%.2f%n", a.area(), b.area());
        System.out.println("Circles created: " + Circle.getCount());
    }
}

