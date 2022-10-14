package shapes;

public class Circle implements Shape, Comparable<Shape> {

    private double radius;
    private ShapeType shapeType;

    public Circle(double radius) {
        this.radius = radius;
        this.shapeType = ShapeType.CIRCLE;
    }

    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public int compareTo(Shape o) {
        return Double.compare(getPerimeter(), o.getPerimeter());
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", shapeType=" + shapeType +
                ", perimeter=" + getPerimeter() +
                ", area=" + getArea() +
                '}';
    }
}
