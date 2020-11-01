package abstract_class_va_interface.bai_tap.interface_resizeable;

import java.util.Arrays;

public class ResizeableTest {
    public static void main(String[] args) {
        //tính phần trăm
        double percent = Math.random()*100;
        //Tạo mảng có kiểu Resizeable chứa 3 phần tử
        Resizeable[] resizeables = new Resizeable[3];
        //Đưa vào từng phần tử vào mảng
        resizeables[0] = new Circle(4);
        resizeables[1] = new Rectangle(2,3);
        resizeables[2] = new Square(1);
        System.out.println("Diện tích trước khi tay đổi");
        for( Resizeable resizeable : resizeables){
            System.out.println(resizeable);
        }

        System.out.println("Diện tích sau khi thay đổi");
        for( Resizeable resizeable : resizeables) {
            resizeable.resize(percent);
            System.out.println(resizeable);
        }



    }
}
