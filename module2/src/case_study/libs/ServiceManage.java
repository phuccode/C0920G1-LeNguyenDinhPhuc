package case_study.libs;

import case_study.commos.Validate;
import case_study.controllers.MainController;
import case_study.models.House;
import case_study.models.Room;
import case_study.models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceManage {
    public List<Villa> servicesVillaList = new ArrayList<>();
    public List<House> servicesHouseList = new ArrayList<>();
    public List<Room> servicesRoomList = new ArrayList<>();
    String fileVilla = "src/case_study/data/Villa.csv";
    String fileHouse = "src/case_study/data/House.csv";
    String fileRoom = "src/case_study/data/Room.csv";

    //Phương thức add Villa
    public void addNewVilla() {
        Villa villa = new Villa(inputIdVilla(), inputNameServices(), inputAreaServices(), inputCostServices(),
                inputQuantityIncluded(), inputRentalType(), inputStandardVilla(), inputComfortableDescriptionVilla(),
                inputFloorVilla(), inputAreaPoolVilla());
        servicesVillaList.add(villa);
        try {
            BufferedWriter writerVilla = new BufferedWriter(new FileWriter(fileVilla, true));
            for (Villa villa1 : servicesVillaList) {
                writerVilla.write(villa1.getId() + "," + villa1.getNameService()
                        + "," + villa1.getAreaUsed() + "," + villa1.getRentsCost()
                        + "," + villa1.getMaxPeople() + "," + villa1.getRentType()
                        + "," + villa1.getStandardRoomVilla() + "," + villa1.getDescribeOtherVilla()
                        + "," + villa1.getAreaPool() + "," + villa1.getNumberFloorVilla());
                writerVilla.newLine();
            }
            writerVilla.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Phương thức add House
    public void addNewHouse() {
        House house = new House(inputIdHouse(), inputNameServices(), inputAreaServices(), inputCostServices(), inputQuantityIncluded(),
                inputRentalType(), inputStandardHouse(), inputComfortableDescriptionHouse(), inputFloorHouse());
        servicesHouseList.add(house);
        try {
            BufferedWriter writerHouse = new BufferedWriter(new FileWriter(fileHouse, true));
            for (House house1 : servicesHouseList) {
                writerHouse.write(house1.getId() + "," + house1.getNameService()
                        + "," + house1.getAreaUsed() + "," + house1.getRentsCost()
                        + "," + house1.getMaxPeople() + "," + house1.getRentType()
                        + "," + house1.getStandardRoomHouse() + "," + house1.getDescribeOtherHouse()
                        + "," + house1.getNumberFloorHouse());
                writerHouse.newLine();
            }
            writerHouse.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Phương thức add Room
    public void addNewRoom() {
        Room room = new Room(inputIdRoom(), inputNameServices(), inputAreaServices(), inputCostServices(), inputQuantityIncluded(),
                inputRentalType(), inputAccompaniedService());
        servicesRoomList.add(room);
        try {
            BufferedWriter writerRoom = new BufferedWriter(new FileWriter(fileRoom, true));
            for (Room room1 : servicesRoomList) {
                writerRoom.write(room1.getId() + "," + room1.getNameService()
                        + "," + room1.getAreaUsed() + "," + room1.getRentsCost()
                        + "," + room1.getMaxPeople() + "," + room1.getRentType()
                        + "," + room1.getFreeService());
                writerRoom.newLine();
            }
            writerRoom.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Đọc file csv khi tắt chương trình arraylist sẽ không lưu và phương thức này giúp đọc lại file csv
    public void readDataVilla() {
        try {
            BufferedReader readerVilla = new BufferedReader(new FileReader(fileVilla));
            String line;
            while ((line = readerVilla.readLine()) != null) {
                String[] countLine;
                countLine = line.split(",");
                Villa villa = new Villa(countLine[0], countLine[1], countLine[2], countLine[3],
                        countLine[4], countLine[5], countLine[6], countLine[7], countLine[8], countLine[9]);
                servicesVillaList.add(villa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDataHouse() {
        try {
            BufferedReader readerHouse = new BufferedReader(new FileReader(fileHouse));
            String line;
            while ((line = readerHouse.readLine()) != null) {
                String[] countLine;
                countLine = line.split(",");
                House house = new House(countLine[0], countLine[1], countLine[2], countLine[3],
                        countLine[4], countLine[5], countLine[6], countLine[7], countLine[8]);
                servicesHouseList.add(house);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDataRoom() {
        try {
            BufferedReader readerRoom = new BufferedReader(new FileReader(fileRoom));
            String line;
            while ((line = readerRoom.readLine()) != null) {
                String[] countLine;
                countLine = line.split(",");
                Room room = new Room(countLine[0], countLine[1], countLine[2], countLine[3],
                        countLine[4], countLine[5], countLine[6]);
                servicesRoomList.add(room);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Phương thức hiện ra các Services
    public void showVilla() {
        for (Villa villa : servicesVillaList) {
            System.out.println(villa.showInfor());
        }
    }

    public void showHouse() {
        for (House house : servicesHouseList) {
            System.out.println(house.showInfor());
        }
    }

    public void showRoom() {
        for (Room room : servicesRoomList) {
            System.out.println(room.showInfor());
        }
    }

    //Các phương thức để nhập vào
    //Regex
    //ID Villa,Room,House
    private static final String VILLA_REGEX = "SVVL-[0-9]{4}";
    private static final String HOUSE_REGEX = "SVHO-[0-9]{4}";
    private static final String ROOM_REGEX = "SVRO-[0-9]{4}";
    //Check name
    private static final String CHECK_NAME = "[A-Z][a-z1-9]+";
    //Diện tích hồ bơi
    private static final String AREA = "([1-9][0-9][0-9])|([3][1-9])|([4-9][0-9])|[.][0-9]+";
    //Chi phí thuê
    private static final String RENTAL_COST = "[1-9]+";
    //Số lượng người đi tối đa
    private static final String MAX_PEOPLE = "[1-9]|[1][0-9]|(20)";
    //Dịch vụ đi kèm
    private static final String ACCOMPANIED_SERVICE = "(massage)|(karaoke)|(food)|(drink)|(car)";
    //Số tầng
    private static final String FLOOR_NUMBER = "[1-9]+";
    //Ngày sinh
    private static final String BIRTHDAY = "^(((0[1-9]|[12][0-9]|30)[-\\/](0[13-9]|1[012])|31[-\\/](0[13578]|1[02])" +
            "|(0[1-9]|1[0-9]|2[0-8])[-\\/]02)" +
            "[-\\/](19[0-9]{2}|200[012])|29[-\\/]02[-\\/]" +
            "([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$";

    private String inputIdVilla() {
        System.out.println("Input Id services (SVVL-XXXX):  ");
        return Validate.isCheck(MainController.getScan().nextLine(), VILLA_REGEX);
    }

    private String inputIdHouse() {
        System.out.println("Input Id services (SVHO-XXXX) :  ");
        return Validate.isCheck(MainController.getScan().nextLine(), HOUSE_REGEX);
    }

    private String inputIdRoom() {
        System.out.println("Input Id services (SVRO-XXXX) :  ");
        return Validate.isCheck(MainController.getScan().nextLine(), ROOM_REGEX);
    }

    private String inputNameServices() {
        System.out.println("Input name services (Abc):  ");
        return Validate.isCheck(MainController.getScan().nextLine(), CHECK_NAME);
    }

    private String inputAreaServices() {
        System.out.println("Input area services (Area > 30) :  ");
        return Validate.isCheck(MainController.getScan().nextLine(), AREA);
    }

    private String inputCostServices() {
        System.out.println("Input cost services (Rental Cost > 0) :  ");
        return Validate.isCheck(MainController.getScan().nextLine(), RENTAL_COST);
    }

    private String inputQuantityIncluded() {
        System.out.println("Input quantity included (0 < People < 20):  ");
        return Validate.isCheck(MainController.getScan().nextLine(), MAX_PEOPLE);
    }

    private String inputRentalType() {
        System.out.println("Input rental type (Abc) :  ");
        return Validate.isCheck(getScan().nextLine(), CHECK_NAME);
    }

    private String inputStandardVilla() {
        System.out.println("Input standard villa (Abc):  ");
        return Validate.isCheck(getScan().nextLine(), CHECK_NAME);
    }

    private String inputAccompaniedService() {
        System.out.println("Input accompanied service (massage, karaoke, food, drink, car):  ");
        return Validate.isCheck(MainController.getScan().nextLine(), ACCOMPANIED_SERVICE);
    }

    private String inputComfortableDescriptionVilla() {
        System.out.println("Input comfortable description villa:  ");
        return getScan().nextLine();
    }

    private String inputFloorVilla() {
        System.out.println("Input floor of villa (Floor > 0) : ");
        return Validate.isCheck(getScan().nextLine(),FLOOR_NUMBER);
    }

    private String inputStandardHouse() {
        System.out.println("Input standard house :  ");
        return getScan().nextLine();
    }

    private String inputComfortableDescriptionHouse() {
        System.out.println("Input comfortable description house :  ");
        return getScan().nextLine();
    }

    private String inputFloorHouse() {
        System.out.println("Input floor house (Floor > 0) :  ");
        return Validate.isCheck(getScan().nextLine(),FLOOR_NUMBER);
    }

    private String inputAreaPoolVilla() {
        System.out.println("Input pool villa (Pool > 30):  ");
        return Validate.isCheck(MainController.getScan().nextLine(), AREA);
    }

    public static Scanner getScan() {
        Scanner input = new Scanner(System.in);
        return input;
    }
}
