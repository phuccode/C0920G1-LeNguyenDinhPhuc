package case_study.views;

import case_study.controllers.MainController;
import case_study.libs.ServiceManage;

public class Main {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }
}
