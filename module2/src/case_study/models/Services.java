package case_study.models;

public abstract class Services {
    String id;
    String nameService;
    String areaUsed;
    String rentsCost;
    String maxPeople;
    String rentType;

    public Services(String id, String nameService, String areaUsed, String rentsCost, String maxPeople, String rentType) {
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

    public Services(String nameService) {
        this.nameService = nameService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return "ID service: " + id + "\n" +
                "Name Service: " + nameService + "\n" +
                "Area Used: " + areaUsed + "\n" +
                "Rents Cost: " + rentsCost + "\n" +
                "Max People: " + maxPeople + "\n" +
                "Rent Type: " + rentType + "\n";
    }
}
