package exercise;

public class ResizableCircle extends Circle implements Resizable {

    private int percentResize;

    public ResizableCircle(double radius, int percentResize) {
        super(radius);
        resize(percentResize);
    }

    @Override
    public double getArea() {
        return super.getArea() * this.percentResize;
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter() * this.percentResize;
    }

    @Override
    public void resize(int percent) {
        this.percentResize = percent;
    }

    @Override
    public String toString() {
        return "ResizableCircle{" +
                "radius=" + getRadius() +
                ", percentResize=" + percentResize +
                '}';
    }
}
