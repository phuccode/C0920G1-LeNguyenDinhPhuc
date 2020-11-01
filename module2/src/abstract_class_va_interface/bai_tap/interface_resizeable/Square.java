package abstract_class_va_interface.bai_tap.interface_resizeable;

public class Square implements Resizeable{
    private double width;
    public Square(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea(){
        return width * width;
    }

    @Override
    public String toString() {
        return "Diện tích hình vuông là " + getArea();
    }

    @Override
    public void resize(double percent) {
        setWidth(getWidth()*getWidth() * percent);
    }
}
