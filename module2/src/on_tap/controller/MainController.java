package on_tap.controller;

import on_tap.manage.ProductManage;
import on_tap.model.ImportedProduct;

import java.util.Scanner;

public class MainController {
    ProductManage productManage = new ProductManage();

    public void DisplayMenu(){
        System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM");
        System.out.println("Chọn chức năng theo số (để tiếp tục): ");
        System.out.println("1. Thêm mới");
        System.out.println("2. Xóa");
        System.out.println("3. Xem danh sách sản phẩm");
        System.out.println("4. Tìm kiếm");
        System.out.println("5. Thoát");
        System.out.println("Chọn chức năng");

        switch (getScan().nextLine()){
            case "1":
                System.out.println("1. Thêm sản phẩm cho nhập khẩu");
                System.out.println("2. Thêm sản phẩm cho xuất khẩu");
                switch (getScan().nextLine()){
                    case "1":
                        productManage.addNewImported();
                        DisplayMenu();
                        break;
                    case "2":
                        productManage.addNewExport();
                        DisplayMenu();
                        break;
                }
                break;
            case "2":
                productManage.deleteImported();
                break;
            case "3":
                productManage.readDataExport();
                productManage.readDataImported();
                System.out.println("1. Xem danh sách sản phẩm nhậu khẩu");
                System.out.println("2. Xem danh sách sản phẩm xuất khẩu");
                switch (getScan().nextLine()){
                    case "1":
                        productManage.showImported();
                        DisplayMenu();
                        break;
                    case "2":
                        productManage.showExport();
                        DisplayMenu();
                        break;
                }
                break;
            case "4":
            case "5":
                //
        }
    }

    public Scanner getScan(){
        Scanner input = new Scanner(System.in);
        return input;
    }
}
