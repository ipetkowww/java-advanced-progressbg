package shapes;

import java.util.Arrays;

public class ShapeTest {

    public static void main(String[] args) {
        Shape shape1 = new Circle(5);
        Shape shape3 = new Rectangle(5, 2);
        Shape shape4 = new Circle(10);
        Shape shape5 = new Circle(2);
        Shape shape2 = new Rectangle(10, 30);

        Shape[] shapes = {shape1, shape2, shape3, shape4, shape5};
        print(shapes);
        Arrays.sort(shapes);
        print(shapes);
    }

    public static void print(Shape[] shapes) {
        System.out.println(Arrays.toString(shapes));
    }
}
