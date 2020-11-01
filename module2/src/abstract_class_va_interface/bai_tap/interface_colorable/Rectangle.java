package abstract_class_va_interface.bai_tap.interface_colorable;

public class Rectangle{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea(){
        return this.height * this.width;
    }
    @Override
    public String toString() {
        return "Dien tich hinh chu nhat la: " + getArea();
    }

}
