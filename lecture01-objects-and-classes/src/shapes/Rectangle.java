package shapes;

public class Rectangle implements Shape, Comparable<Shape> {

    private double width;
    private double length;
    private ShapeType shapeType;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
        this.shapeType = ShapeType.RECTANGLE;
    }

    @Override
    public double getArea() {
        return this.width * this.length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.width + this.length);
    }

    @Override
    public int compareTo(Shape o) {
        return Double.compare(getPerimeter(), o.getPerimeter());
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", shapeType=" + shapeType +
                ", perimeter=" + getPerimeter() +
                ", area=" + getArea() +
                '}';
    }
}
