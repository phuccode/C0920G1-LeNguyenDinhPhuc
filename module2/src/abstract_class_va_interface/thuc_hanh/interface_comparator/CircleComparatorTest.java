package abstract_class_va_interface.thuc_hanh.interface_comparator;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circle = new Circle[3];
        circle[0] = new Circle(3.6,"red");
        circle[1] = new Circle();
        circle[2] = new Circle(3.6,"indigo");

        System.out.println("Pre-sorted: ");
        for(Circle circle1 : circle){
            System.out.println(circle1);
        }

        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circle, circleComparator);

        System.out.println("After-sorted: ");
        for (Circle circle1: circle){
            System.out.println(circle1);
        }
    }
}
