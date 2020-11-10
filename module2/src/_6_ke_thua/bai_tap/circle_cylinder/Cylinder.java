package _6_ke_thua.bai_tap.circle_cylinder;

public class Cylinder extends Circle{
    private double height;

    Cylinder(double radius, String color,double height){
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return getArea() * this.height;
    }

    @Override
    public String toString(){
        return "Chiều cao của hình trụ này là: "
                + getHeight()
                + " thể tích của hình trụ này là: "
                + getVolume()
                + " đây là lớp con của "
                + super.toString();
    }

    public static void main(String[] args) {

        Cylinder cylinder = new Cylinder(2,"red",2);
        System.out.println(cylinder);
    }
}
