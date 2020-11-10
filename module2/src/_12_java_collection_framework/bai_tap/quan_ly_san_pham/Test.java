package _12_java_collection_framework.bai_tap.quan_ly_san_pham;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        boolean check = true;

        do{
            System.out.println("Nhập 1 để thêm sản phẩm");
            System.out.println("Nhập 2 để hiện thị danh sách sản phẩm");
            System.out.println("Nhập 3 để xóa sản phẩm");
            System.out.println("Nhập 4 để tìm kiếm sản phẩm");
            System.out.println("Nhập 5 để sửa thông tin sản phẩm");
            switch(getScan().nextInt()){
                case 1:{
                    manager.addProduct();
                    break;
                }
                case 2:{
                    manager.disPlay();
                    break;
                }
                case 3:{
                    manager.removeProduct();
                    break;
                }
                case 4:{
                    manager.findProduct();
                    break;
                }
                case 5:{
                    manager.editProduct();
                    break;
                }
            }
        }
        while (check);
    }
    //Tạo phương thức Scan để dễ sử dụng hàm Scanner
    public static Scanner getScan(){
        Scanner input = new Scanner(System.in);
        return input;
    }
}
