package abstract_class_va_interface.bai_tap.interface_resizeable;

public class Rectangle implements Resizeable {
    private double width ;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea(){
        return width * length;
    }

    @Override
    public String toString() {
        return "Diện tích hình chữ nhật là: " + getArea();
    }

    @Override
    public void resize(double percent) {
        setWidth(getWidth() * percent);
        setLength(getLength() * percent);
    }
}
