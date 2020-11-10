package _4_lop_va_doi_tuong.bai_tap.phuong_trinh_bac_2;

public class QuadraticEquation {
    private double a,b,c;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    void getDiscriminant(){
        double delta, n1, n2;
        delta = this.b*2 - 4*this.a*this.c;
        if(delta < 0){
            System.out.println("Phương trình vô nghiệm");
        }
        else if( delta==0 ){
            n1 = n2 = -this.b/(2*this.a);
            System.out.println("Phương trình có nghiệm kép: " +  "\nx1 = x2 =" + n1);
        }else {
            n1 = (-this.b + Math.sqrt(delta))/(2*this.a);
            n2 = (-this.b - Math.sqrt(delta))/(2*this.a);
            System.out.println("Phương trình có 2 nghiệm phân biệt"
                    + "\nX1 = " + n1 + "\nX2 = " + n2);
        }
    }
}
