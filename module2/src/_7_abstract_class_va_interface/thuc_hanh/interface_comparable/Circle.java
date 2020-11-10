package _7_abstract_class_va_interface.thuc_hanh.interface_comparable;

public class Circle {
    private double radius;
    private String color;

    Circle(){
    }

    Circle(double radius, String color){
        this.radius = radius;
        this.color = color;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return 2 * radius * Math.PI;
    }

    @Override

    public String toString(){
        return "Hình tròn này có bán kính là: "
                + getRadius()
                +", màu của hình tròn này là: "
                + getColor()
                +" và có diện tích là: "
                + getArea();
    }
}
