package case_study.models;

public class House extends Services {
    String standardRoomHouse;
    String describeOtherHouse;
    String numberFloorHouse;

    public House(String id, String nameService, String areaUsed, String rentsCost, String maxPeople, String rentType, String standardRoomHouse, String describeOtherHouse, String numberFloorHouse) {
        super(id, nameService, areaUsed, rentsCost, maxPeople, rentType);
        this.standardRoomHouse = standardRoomHouse;
        this.describeOtherHouse = describeOtherHouse;
        this.numberFloorHouse = numberFloorHouse;
    }

    public String getStandardRoomHouse() {
        return standardRoomHouse;
    }

    public void setStandardRoomHouse(String standardRoomHouse) {
        this.standardRoomHouse = standardRoomHouse;
    }

    public String getDescribeOtherHouse() {
        return describeOtherHouse;
    }

    public void setDescribeOtherHouse(String describeOtherHouse) {
        this.describeOtherHouse = describeOtherHouse;
    }

    public String getNumberFloorHouse() {
        return numberFloorHouse;
    }

    public void setNumberFloorHouse(String numberFloorHouse) {
        this.numberFloorHouse = numberFloorHouse;
    }

    @Override
    public String showInfor() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "House: " + "\n" + super.toString() +
                "Standard Room House: " + standardRoomHouse + "\n" +
                "Describe Other House: " + describeOtherHouse + "\n" +
                "Number Floor House: " + numberFloorHouse + "\n" +
        "---------------------------------------";
    }
}
