package test;

public class SavingMoneyTime extends SavingMoney {

    public SavingMoneyTime(int id, String codeCustomer, String startRentDay, String startRentTime, String timeToSaving, String moneySaving, String moneyDeposits, String gift) {
        super(id, codeCustomer, startRentDay, startRentTime, timeToSaving, moneySaving, moneyDeposits, gift);
    }

    public String showInfo(){
        System.out.println(toString());
        return toString();
    }
    @Override
    public String toString() {
        return "SavingMoneyTime{" +
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
