package case_study.views;

import case_study.controllers.MainController;

public class Main {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }
}
