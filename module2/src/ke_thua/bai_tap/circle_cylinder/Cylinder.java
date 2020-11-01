package ke_thua.bai_tap.circle_cylinder;

public class Cylinder extends Circle{
    double height;
    Cylinder(){
    }

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
        return Math.PI * this.radius*this.radius * this.height;
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
        Cylinder cylinder = new Cylinder(2.0, "red", 5.0);
        System.out.println(cylinder);
    }
}
