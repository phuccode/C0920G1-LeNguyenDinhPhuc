package _7_abstract_class_va_interface.bai_tap.interface_resizeable;

public class Circle implements Resizeable {
    private double radius;
    Circle(){
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return 2 * radius * Math.PI;
    }

    @Override

    public String toString(){
        return "Hình tròn này có bán kính là: "
                + getRadius()
                +" và có diện tích là: "
                + getArea();
    }
    @Override
    public void resize(double percent) {
        setRadius(Math.sqrt(getRadius() * percent / Math.PI));
    }
}
