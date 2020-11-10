package _5_access_modifier.bai_tap;

public class TestCircle extends Circle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.getArea();
        circle.getRadius("The Anh");
        System.out.println(circle.getArea());
    }
}
