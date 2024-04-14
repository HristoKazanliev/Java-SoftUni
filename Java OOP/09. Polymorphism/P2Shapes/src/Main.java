public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(3.0, 5.5);
        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());

        Shape circle = new Circle(8.5);
        System.out.println(circle.calculatePerimeter());
        System.out.println(circle.calculateArea());
    }
}