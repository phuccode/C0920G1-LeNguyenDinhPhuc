package on_tap;

import on_tap.controller.MainController;
import on_tap.manage.ProductManage;

import java.sql.Time;

public class Main {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.DisplayMenu();
        ProductManage productManage = new ProductManage();
        productManage.addNewProduct();



    }


}
