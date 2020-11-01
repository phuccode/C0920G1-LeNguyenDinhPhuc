package abstract_class_va_interface.bai_tap.interface_colorable;

public class Square extends Rectangle implements Colorable {
    private String color;

    public Square(double width, double height, String color) {
        super(width, height);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString(){
        return "Mau cua hinh nay la " + getColor();
    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}
