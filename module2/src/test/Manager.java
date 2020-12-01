package test;

import on_tap_2.Maincontrol;
import on_tap_2.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    public static List<SavingMoneyTime> moneyTimeList = new ArrayList<>();
    public static List<SavingMoneyNotTime> moneyNotTimeList = new ArrayList<>();
    private static final String P = ",";
    public static String fileShort = "src/thi_module2/shortTerm.csv";
    public static String fileLong = "src/thi_module2/longTerm.csv";

    public static void addShortTerm(){
            int id = (moneyTimeList.size() > 0 ) ? (moneyTimeList.size() + 1) : 1;
            System.out.println("Id = " + id);
            String gift = null;
            SavingMoneyTime savingMoneyTime = new SavingMoneyTime(id,codeName(),inputStartRentDay(),inputTimeToSaving()
                    ,inputRentDay(),inputMoneySaving(),inputMoneyDeposits(),gift);
            moneyTimeList.add(savingMoneyTime);
            String line = savingMoneyTime.getId() + P + savingMoneyTime.getCodeCustomer() + P
                    + savingMoneyTime.getStartRentDay() + P
                    + savingMoneyTime.getStartRentTime() + P + savingMoneyTime.getTimeToSaving()
                    + P + savingMoneyTime.getMoneySaving()  + P + savingMoneyTime.getMoneyDeposits();
            ReadAndWrite.writeFile(fileShort,line);
    }

    public static void addLongTerm(){
        int id = (moneyNotTimeList.size() > 0 ) ? (moneyNotTimeList.size() + 1) : 1;
        System.out.println("Id = " + id);
        SavingMoneyNotTime savingMoneyNotTime = new SavingMoneyNotTime(id,codeName(),inputStartRentDay(),inputTimeToSaving()
                ,inputMoneySaving(),inputMoneyDeposits(),inputGift());
        moneyNotTimeList.add(savingMoneyNotTime);
        String line = savingMoneyNotTime.getId() + P + savingMoneyNotTime.getCodeCustomer() + P
                + savingMoneyNotTime.getStartRentDay() + P
                + savingMoneyNotTime.getStartRentTime()
                + P + savingMoneyNotTime.getMoneySaving()  + P + savingMoneyNotTime.getMoneyDeposits()
                + P + savingMoneyNotTime.getGift();
        ReadAndWrite.writeFile(fileLong,line);
    }

    public static void deleteShort() {
        System.out.println("Nhập id muốn xóa");
        int choose = Maincontrol.getScan().nextInt();
        for (int i = 0; i < moneyTimeList.size(); i++) {
            if (choose == moneyTimeList.get(i).getId()) {
                ReadAndWrite.removeFile(fileShort);
                moneyTimeList.remove(i);
                for (SavingMoney savingMoneyTime : moneyTimeList) {
                    String line = savingMoneyTime.getId() + P + savingMoneyTime.getCodeCustomer() + P
                            + savingMoneyTime.getStartRentDay() + P
                            + savingMoneyTime.getStartRentTime() + P + savingMoneyTime.getTimeToSaving()
                            + P + savingMoneyTime.getMoneySaving() + P + savingMoneyTime.getMoneyDeposits();
                    ReadAndWrite.writeFile(fileShort, line);
                }
            }
        }
    }

    public static void deleteLong() {
        System.out.println("Nhập id muốn xóa");
        int choose = Maincontrol.getScan().nextInt();
        for (int i = 0; i < moneyNotTimeList.size(); i++) {
            if (choose == moneyNotTimeList.get(i).getId()) {
                ReadAndWrite.removeFile(fileLong);
                moneyNotTimeList.remove(i);
                for (SavingMoney savingMoneyTime : moneyNotTimeList) {
                    String line = savingMoneyTime.getId() + P + savingMoneyTime.getCodeCustomer() + P
                            + savingMoneyTime.getStartRentDay() + P
                            + savingMoneyTime.getStartRentTime()
                            + P + savingMoneyTime.getMoneySaving()  + P + savingMoneyTime.getMoneyDeposits()
                            + P + savingMoneyTime.getGift();
                    ReadAndWrite.writeFile(fileLong,line);
                }
            }
        }
    }

    public static void searchShort(){
        System.out.println("Nhập id muốn tìm");
        int checkId = Maincontrol.getScan().nextInt();
        for (int i = 0; i < moneyTimeList.size(); i++){
            if(checkId == moneyTimeList.get(i).getId()){
                moneyTimeList.get(i).showInfo();
            }
        }
    }
    public static void showShortTerm(){
        List<String[]> listShort = FileWriteRead.readFile(fileShort);
        moneyTimeList.clear();
        for (String[] cus : listShort) {
            SavingMoneyTime cus1 = new SavingMoneyTime(Integer.parseInt(cus[0]), cus[1], cus[2], cus[3], cus[4], cus[5], cus[6]
                    , cus[7]);
            moneyTimeList.add(cus1);
        }
        for (SavingMoneyTime s : moneyTimeList) {
            System.out.println(s.showInfo());
        }

    }

    public static void showLongTerm(){
        List<String[]> listLong = FileWriteRead.readFile(fileLong);
        moneyNotTimeList.clear();
        for (String[] cus : listLong) {
            SavingMoneyNotTime cus1 = new SavingMoneyNotTime(Integer.parseInt(cus[0]), cus[1], cus[2], cus[3], cus[4]
                    , cus[5], cus[6]);
            moneyNotTimeList.add(cus1);
        }
        for (SavingMoneyNotTime s : moneyNotTimeList) {
            System.out.println(s.showInfo());
        }
    }
    public static String codeName(){
        System.out.println("Nhập mã khách hàng");
        return Maincontrol.getScan().nextLine();
    }

    public static String inputStartRentDay(){
        System.out.println("Nhập ngày mở sổ");
        return Maincontrol.getScan().nextLine();
    }
    public static String inputTimeToSaving(){
        System.out.println("Nhập thời gian bắt đầu gửi");
        return Maincontrol.getScan().nextLine();
    }

    public static String inputMoneySaving(){
        System.out.println("Nhập số tiền gửi");
        return Maincontrol.getScan().nextLine();
    }

    public static String inputRentDay(){
        System.out.println("Nhập kỳ hạn");
        return Maincontrol.getScan().nextLine();
    }

    public static String inputMoneyDeposits(){
        System.out.println("Nhập lãi suất");
        return Maincontrol.getScan().nextLine();
    }

    public static String inputGift(){
        System.out.println("Nhập quà");
        return Maincontrol.getScan().nextLine();
    }
}
