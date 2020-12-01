package test;

public abstract class SavingMoney {
    int id;
    protected String codeCustomer;
    protected String startRentDay;
    protected String startRentTime;
    protected String timeToSaving;
    protected String moneySaving;
    protected String moneyDeposits;
    protected String gift;


    public SavingMoney(int id, String codeCustomer, String startRentDay, String startRentTime, String timeToSaving, String moneySaving, String moneyDeposits, String gift) {
        this.id = id;
        this.codeCustomer = codeCustomer;
        this.startRentDay = startRentDay;
        this.startRentTime = startRentTime;
        this.timeToSaving = timeToSaving;
        this.moneySaving = moneySaving;
        this.moneyDeposits = moneyDeposits;
        this.gift = gift;
    }


    public SavingMoney(int id, String codeCustomer, String startRentDay, String startRentTime, String moneySaving, String moneyDeposits, String gift) {
        this.id = id;
        this.codeCustomer = codeCustomer;
        this.startRentDay = startRentDay;
        this.startRentTime = startRentTime;
        this.moneySaving = moneySaving;
        this.moneyDeposits = moneyDeposits;
        this.gift = gift;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getStartRentDay() {
        return startRentDay;
    }

    public void setStartRentDay(String startRentDay) {
        this.startRentDay = startRentDay;
    }

    public String getStartRentTime() {
        return startRentTime;
    }

    public void setStartRentTime(String startRentTime) {
        this.startRentTime = startRentTime;
    }

    public String getTimeToSaving() {
        return timeToSaving;
    }

    public void setTimeToSaving(String timeToSaving) {
        this.timeToSaving = timeToSaving;
    }

    public String getMoneySaving() {
        return moneySaving;
    }

    public void setMoneySaving(String moneySaving) {
        this.moneySaving = moneySaving;
    }

    public String getMoneyDeposits() {
        return moneyDeposits;
    }

    public void setMoneyDeposits(String moneyDeposits) {
        this.moneyDeposits = moneyDeposits;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public String showInfo(){
        System.out.println(toString());
        return toString();
    }

    @Override
    public String toString() {
        return "SavingMoney{" +
                "id=" + id +
                ", codeCustomer='" + codeCustomer + '\'' +
                ", startRentDay='" + startRentDay + '\'' +
                ", startRentTime='" + startRentTime + '\'' +
                ", timeToSaving='" + timeToSaving + '\'' +
                ", moneySaving='" + moneySaving + '\'' +
                ", moneyDeposits='" + moneyDeposits + '\'' +
                ", gift='" + gift + '\'' +
                '}';
    }
}
