package test;

public class SavingMoneyNotTime extends SavingMoney {

    public SavingMoneyNotTime(int id, String codeCustomer, String startRentDay, String startRentTime, String moneySaving, String moneyDeposits, String gift) {
        super(id, codeCustomer, startRentDay, startRentTime, moneySaving, moneyDeposits, gift);
    }

    public String showInfo(){
        System.out.println(toString());
        return toString();
    }
    @Override
    public String toString() {
        return "SavingMoneyNotTime{" +
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
