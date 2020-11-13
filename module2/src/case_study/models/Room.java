package case_study.models;

public class Room extends Services {
    String freeService = "Free";

    public Room(int id, String nameService, String areaUsed, String rentsCost, String maxPeople, String rentType, String freeService) {
        super(id, nameService, areaUsed, rentsCost, maxPeople, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String showInfor() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Room: " + "\n" + super.toString() +
                "freeService: " + freeService + "\n" +
        "---------------------------------------";
    }
}
