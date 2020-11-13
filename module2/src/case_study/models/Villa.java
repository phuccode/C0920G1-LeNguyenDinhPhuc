package case_study.models;

public class Villa extends Services {
    String standardRoomVilla;
    String describeOtherVilla;
    String areaPool;
    String numberFloorVilla;

    public Villa(int id, String nameService, String areaUsed, String rentsCost, String maxPeople, String rentType, String standardRoomVilla, String describeOtherVilla, String areaPool, String numberFloorVilla) {
        super(id, nameService, areaUsed, rentsCost, maxPeople, rentType);
        this.standardRoomVilla = standardRoomVilla;
        this.describeOtherVilla = describeOtherVilla;
        this.areaPool = areaPool;
        this.numberFloorVilla = numberFloorVilla;
    }

    public String getStandardRoomVilla() {
        return standardRoomVilla;
    }

    public void setStandardRoomVilla(String standardRoomVilla) {
        this.standardRoomVilla = standardRoomVilla;
    }

    public String getDescribeOtherVilla() {
        return describeOtherVilla;
    }

    public void setDescribeOtherVilla(String describeOtherVilla) {
        this.describeOtherVilla = describeOtherVilla;
    }

    public String getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(String areaPool) {
        this.areaPool = areaPool;
    }

    public String getNumberFloorVilla() {
        return numberFloorVilla;
    }

    public void setNumberFloorVilla(String numberFloorVilla) {
        this.numberFloorVilla = numberFloorVilla;
    }

    @Override
    public String showInfor() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Villa: " + "\n" + super.toString() +
                "standardRoomVilla: " + standardRoomVilla + "\n" +
                "DescribeOtherVilla: " + describeOtherVilla + "\n" +
                "AreaPool: " + areaPool + "\n" +
                "NumberFloorVilla: " + numberFloorVilla + "\n" +
                "---------------------------------------";
    }
}
