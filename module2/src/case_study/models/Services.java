package case_study.models;

public abstract class Services {
    int id;
    String nameService;
    String areaUsed;
    String rentsCost;
    String maxPeople;
    String rentType;

    public Services(int id, String nameService, String areaUsed, String rentsCost, String maxPeople, String rentType) {
        this.id = id;
        this.nameService = nameService;
        this.areaUsed = areaUsed;
        this.rentsCost = rentsCost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
    }

    public Services(String nameService, String areaUsed, String rentsCost, String maxPeople, String rentType) {
        this.nameService = nameService;
        this.areaUsed = areaUsed;
        this.rentsCost = rentsCost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(String areaUsed) {
        this.areaUsed = areaUsed;
    }

    public String getRentsCost() {
        return rentsCost;
    }

    public void setRentsCost(String rentsCost) {
        this.rentsCost = rentsCost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public abstract String showInfor();

    @Override
    public String toString() {
        return "nameService: " + nameService + "\n" +
                "areaUsed: " + areaUsed + "\n" +
                "rentsCost: " + rentsCost + "\n" +
                "maxPeople: " + maxPeople + "\n" +
                "rentType: " + rentType + "\n";
    }
}
