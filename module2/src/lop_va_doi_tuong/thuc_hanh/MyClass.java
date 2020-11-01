package lop_va_doi_tuong.thuc_hanh;

public class MyClass {
     public int X = 2;

    public static void main(String[] args) {
        MyClass o1 = new MyClass();
        MyClass o2 = new MyClass();
        o2.X = 5;
        System.out.printf("x=%d, y=%d", o1.X, o2.X);
    }
}
