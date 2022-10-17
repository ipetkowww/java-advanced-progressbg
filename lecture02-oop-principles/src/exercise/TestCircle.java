package exercise;

public class TestCircle {

    public static void main(String[] args) {
        Circle[] circles = {
                new Circle(10),
                new ResizableCircle(10, 5),
                new Circle(2),
                new ResizableCircle(3, 100),
                new ResizableCircle(7, 2),
                new Circle(9),
                new Circle(100)
        };

        for (Circle circle : circles) {
            System.out.println(circle);
            System.out.println("Perimeter = " + circle.getPerimeter());
            System.out.println("Area = " + circle.getArea());
            System.out.println("=====================================");
        }

        Circle c = new ResizableCircle(1, 5);
        System.out.println(c.getArea()); // executes method from ResizableCircle
        System.out.println(c.getPerimeter()); // executes method from ResizableCircle
    }
}
