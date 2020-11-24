package case_study.libs;

import case_study.commos.ReadWriteFile;
import case_study.commos.Validate;
import case_study.controllers.MainController;
import case_study.models.House;
import case_study.models.Room;
import case_study.models.Villa;

import java.util.*;

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
        ReadWriteFile.writeFile(fileVilla, villa.getId() + "," + villa.getNameService() + "," +
                villa.getAreaUsed() + "," + villa.getRentsCost() + "," + villa.getMaxPeople() + "," +
                villa.getRentType() + "," + villa.getStandardRoomVilla() + "," + villa.getDescribeOtherVilla()
                + "," + villa.getNumberFloorVilla() + "," + villa.getAreaPool());
    }

    //Phương thức add House
    public void addNewHouse() {
        House house = new House(inputIdHouse(), inputNameServices(), inputAreaServices(), inputCostServices(), inputQuantityIncluded(),
                inputRentalType(), inputStandardHouse(), inputComfortableDescriptionHouse(), inputFloorHouse());
        servicesHouseList.add(house);
        ReadWriteFile.writeFile(fileHouse, house.getId() + "," + house.getNameService()
                + "," + house.getAreaUsed() + "," + house.getRentsCost()
                + "," + house.getMaxPeople() + "," + house.getRentType()
                + "," + house.getStandardRoomHouse() + "," + house.getDescribeOtherHouse()
                + "," + house.getNumberFloorHouse());
    }

    //Phương thức add Room
    public void addNewRoom() {
        Room room = new Room(inputIdRoom(), inputNameServices(), inputAreaServices(), inputCostServices(), inputQuantityIncluded(),
                inputRentalType(), inputAccompaniedService());
        servicesRoomList.add(room);
        ReadWriteFile.writeFile(fileRoom, room.getId() + "," + room.getNameService()
                + "," + room.getAreaUsed() + "," + room.getRentsCost()
                + "," + room.getMaxPeople() + "," + room.getRentType()
                + "," + room.getFreeService());
    }

    //Phương thức hiện ra các Services
    public List<Villa> showVilla() {
        List<String[]> listVilla = ReadWriteFile.readFile(fileVilla);
        servicesVillaList.clear();
        for (String[] villa1 : listVilla) {
            Villa villa = new Villa(villa1[0], villa1[1], villa1[2], villa1[3], villa1[4], villa1[5], villa1[6],
                    villa1[7], villa1[8], villa1[9]);
            servicesVillaList.add(villa);
        }
        for (Villa villa : servicesVillaList) {
            System.out.println(villa.showInfor());
        }
        return servicesVillaList;
    }

    public List<House> showHouse() {
        List<String[]> listHouse = ReadWriteFile.readFile(fileHouse);
        servicesHouseList.clear();
        for (String[] house : listHouse) {
            House house1 = new House(house[0], house[1], house[2], house[3], house[4], house[5], house[6], house[7], house[8]);
            servicesHouseList.add(house1);
        }
        for (House house : servicesHouseList) {
            System.out.println(house.showInfor());
        }
        return servicesHouseList;
    }

    public List<Room> showRoom() {
        List<String[]> listRoom = ReadWriteFile.readFile(fileRoom);
        servicesRoomList.clear();
        for (String[] room : listRoom) {
            Room room1 = new Room(room[0], room[1], room[2], room[3], room[4], room[5], room[6]);
            servicesRoomList.add(room1);
        }
        for (Room room : servicesRoomList) {
            System.out.println(room.showInfor());
        }
        return servicesRoomList;
    }

    //Hiện Services không trùng lặp và theo tên
    public void showVillaNotDuplicate() {
        List<String[]> listVilla = ReadWriteFile.readFile(fileVilla);
        Set<String> villaTreeSet = new TreeSet<>();
        for (String[] villa : listVilla) {
            villaTreeSet.add(villa[1]);
        }
        System.out.println(villaTreeSet);
    }

    public void showHouseNotDuplicate() {
        List<String[]> listHouse = ReadWriteFile.readFile(fileHouse);
        Set<String> houseTreeSet = new TreeSet<>();
        for (String[] house : listHouse) {
            houseTreeSet.add(house[1]);
        }
        System.out.println(houseTreeSet);
    }

    public void showRoomNotDuplicate() {
        List<String[]> listRoom = ReadWriteFile.readFile(fileRoom);
        Set<String> roomTreeSet = new TreeSet<>();
        for (String[] room : listRoom) {
            roomTreeSet.add(room[1]);
        }
        System.out.println(roomTreeSet);
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

    private String inputIdVilla() {
        System.out.println("Input Id services (SVVL-XXXX):  ");
        return Validate.isCheck(getScan().nextLine(), VILLA_REGEX);
    }

    private String inputIdHouse() {
        System.out.println("Input Id services (SVHO-XXXX) :  ");
        return Validate.isCheck(getScan().nextLine(), HOUSE_REGEX);
    }

    private String inputIdRoom() {
        System.out.println("Input Id services (SVRO-XXXX) :  ");
        return Validate.isCheck(getScan().nextLine(), ROOM_REGEX);
    }

    private String inputNameServices() {
        System.out.println("Input name services (Abc):  ");
        return Validate.isCheck(getScan().nextLine(), CHECK_NAME);
    }

    private String inputAreaServices() {
        System.out.println("Input area services (Area > 30) :  ");
        return Validate.isCheck(getScan().nextLine(), AREA);
    }

    private String inputCostServices() {
        System.out.println("Input cost services (Rental Cost > 0) :  ");
        return Validate.isCheck(getScan().nextLine(), RENTAL_COST);
    }

    private String inputQuantityIncluded() {
        System.out.println("Input quantity included (0 < People < 20):  ");
        return Validate.isCheck(getScan().nextLine(), MAX_PEOPLE);
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
        return Validate.isCheck(getScan().nextLine(), ACCOMPANIED_SERVICE);
    }

    private String inputComfortableDescriptionVilla() {
        System.out.println("Input comfortable description villa:  ");
        return getScan().nextLine();
    }

    private String inputFloorVilla() {
        System.out.println("Input floor of villa (Floor > 0) : ");
        return Validate.isCheck(getScan().nextLine(), FLOOR_NUMBER);
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
        return Validate.isCheck(getScan().nextLine(), FLOOR_NUMBER);
    }

    private String inputAreaPoolVilla() {
        System.out.println("Input pool villa (Pool > 30):  ");
        return Validate.isCheck(getScan().nextLine(), AREA);
    }

    public static Scanner getScan() {
        Scanner input = new Scanner(System.in);
        return input;
    }
}
