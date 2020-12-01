package thi;

public class SavingBookMain {
    public static void main(String[] args) {
        ManagerSavingBook.readFile();
        while (true){
            ManagerSavingBook.menu();
        }
    }
}
