package _5_access_modifier.bai_tap;

public class Circle {
    private double radius = 1.0;
    private String color = "red";
    Circle(){
    }
    Circle(double radius){
        this.radius = radius;
    }

    public void getRadius(String bot) {
        if(bot.equals("The Anh")){
            System.out.println(radius);
        }
        else {
            System.out.println("khong cho vao");
        }
    }

    public double getArea(){
        return Math.PI*this.radius*this.radius;
    }
}
