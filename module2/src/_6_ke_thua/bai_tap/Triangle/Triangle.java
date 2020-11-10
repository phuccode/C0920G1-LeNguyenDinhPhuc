package _6_ke_thua.bai_tap.Triangle;

import java.util.Scanner;

public class Triangle extends Shape{
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    Triangle(){
    }

    Triangle(String color, boolean isFilled, double side1, double side2, double side3){
        super(color,isFilled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter(){
        return this.side1 + this.side2 + this.side3;
    }

    public double getArea(){
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p - this.side1)*(p - this.side2)*(p - this.side3));
    }

    public String toString(){
        return "Diện tích của tam giác là "
                + getArea()
                + " Chu vi của tam giác là "
                + getPerimeter()
                + super.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập cạnh");
        double side1 = scanner.nextDouble();
        System.out.println("Nhập cạnh");
        double side2 = scanner.nextDouble();
        System.out.println("Nhập cạnh");
        double side3 = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập màu");
        String color = scanner.nextLine();
        Triangle triangle = new Triangle(color,true,side1,side2,side3);
        System.out.println(triangle);
    }
}
