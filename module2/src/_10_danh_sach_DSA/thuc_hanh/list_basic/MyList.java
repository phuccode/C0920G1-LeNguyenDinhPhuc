package _10_danh_sach_DSA.thuc_hanh.list_basic;

import java.util.Arrays;

public class MyList<E>{
    private int size = 0;
    // lưu số phần tử tối đa trong danh sách mặc định là không
    private static final int  DEFAULT_CAPACITY = 10;
    //Tạo mảng đối tượng có tên elements
    private Object elements[];

    //Đưa đối tượng elements vào mảng có số phần tử tối đa là 10
    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    //Tăng kích thước mảng lên gấp đôi
    private void ensureCapa(){
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements, newSize);
    }

    //Thêm một phần từr vào cuối danh sách
    //Tham số đầu vào là phần tử cần thêm vào danh sách
    public void add(E e){
        if(size == elements.length){
            ensureCapa();
        }
        elements[size++] = e;
    }
    //Trả về phần tử vừa ở vị trí thứ i trong danh sách
    //Tham số đầu vào là số nguyên chứa vị trí cần truy cập đến phần tử trong danh sách
    public E get (int i){
        if(i >= size || i<0){
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
}
