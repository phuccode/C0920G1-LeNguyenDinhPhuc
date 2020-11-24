package case_study.libs;


import case_study.commos.ReadWriteFile;
import case_study.commos.Validate;
import case_study.models.Customer;

import java.util.*;

public class CustomerManage {
    public List<Customer> customerList = new ArrayList<>();
    String fileCustomer = "src/case_study/data/Customer.csv";

    //Customer
    //Phương thức add customer
    public void addNewCustomer() {
        Customer customer = new Customer(inputNameCustomer(), inputBirth(), inputGender(), inputCmnd()
                , inputPhoneNumber(), inputEmail(), inputAddress());
        customerList.add(customer);
        ReadWriteFile.writeFile(fileCustomer, customer.getCustomerName() + "," + customer.getBirthday()
                + "," + customer.getGender() + "," + customer.getNumID() + "," + customer.getNumPhone()
                + "," + customer.getEmail() + "," + customer.getAddress());
    }

    //Phương thức hiện danh sách customer đã lưu
    public List<Customer> showInformationCustomers() {
        List<String[]> listCus = ReadWriteFile.readFile(fileCustomer);
        customerList.clear();
        for (String[] cus : listCus) {
            Customer cus1 = new Customer(cus[0], cus[1], cus[2], cus[3], cus[4], cus[5], cus[6]);
            customerList.add(cus1);
        }
        Collections.sort(customerList);
        for (Customer customer : customerList) {
            System.out.println(customer.showInfor());
        }
        return customerList;
    }

    public void deleteCustomer() {
        customerList = showInformationCustomers();
        System.out.println("Input your name you want remove: ");
        String input = getScan().nextLine();
        ReadWriteFile.removeFile(fileCustomer);
        for (int i = 0; i < customerList.size(); i++) {
            if (input.equals(customerList.get(i).getCustomerName())) {
                customerList.remove(i);
                i--;
            }
        }
        for (Customer customer : customerList) {
            ReadWriteFile.writeFile(fileCustomer, customer.getCustomerName() + "," + customer.getBirthday()
                    + "," + customer.getGender() + "," + customer.getNumID() + "," + customer.getNumPhone()
                    + "," + customer.getEmail() + "," + customer.getAddress());
        }
    }

    public static int count = 1;

    public void buyTicket() {
        String temp = "Ticket Number " + count;
        if (count <= 2) {
            System.out.println("You buy movie ticket , ticket number " + count);
        } else {
            System.out.println("Sold out, see you next time :D ");
            System.out.println("List customer buy ticket !");
            showTicket();
        }
        count++;
        Customer customer = new Customer(inputNameCustomer(), inputBirth(), inputCmnd(), inputPhoneNumber(),
                inputEmail(), inputAddress(), temp);
        listTicket.add(customer);
        customerList.add(customer);
        ReadWriteFile.writeFile(fileCustomer, customer.getCustomerName() + "," + customer.getBirthday() + ","
                + customer.getNumID() + "," + customer.getNumPhone() + ","
                + customer.getEmail() + "," + customer.getAddress() + "," + temp);
    }


    public static Queue<Customer> listTicket = new LinkedList<>();

    public void showTicket() {
        for (Customer customers : listTicket) {
            System.out.println(customers.getCustomerName() +
                    "\n ----------------");
        }
    }

    //Đọc file csv Customer
//    public void readDataCus(){
//        try {
//            BufferedReader bufferedReaderCus = new BufferedReader(new FileReader(fileCustomer));
//            String line;
//            while ((line = bufferedReaderCus.readLine()) != null){
//                String[] cusSplit;
//                cusSplit = line.split(",");
//                Customer customer = new Customer(cusSplit[0],cusSplit[1],cusSplit[2],cusSplit[3],cusSplit[4],
//                        cusSplit[5],cusSplit[6]);
//                customerList.add(customer);
//            }
//            bufferedReaderCus.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    //Cus
    private static final String NAME_REGEX = "^([A-Z][a-z]+\\s)+(|[A-Z][a-z]+)$";
    private static final String BIRTHDAY_REGEX = "^(((0[1-9]|[12][0-9]|30)[-\\/](0[13-9]|1[012])|31[-\\/](0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-\\/]02)" +
            "[-\\/](19[0-9]{2}|200[012])|29[-\\/]02[-\\/]" +
            "([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$";
    private static final String GENDER_REGEX = "^[mM][aA][lL][eE]|[fF][eE][mM][aA][lL][eE]|[uU][nN][kK][nN][oO][wW]$";
    private static final String CMND_REGEX = "[0-9]{9}";
    private static final String PHONE_NUMBER = "^0([0-9]{9})$";
    private static final String EMAIL_REGEX = "^[a-z0-9_]+[a-z0-9]@([a-z0-9]+\\.)[a-z]+(|\\.[a-z]+)$";
    public static final String REGEX_STR = "[A-Z][a-z]*";

    private String inputNameCustomer() {
        System.out.println("Input name customer (Abc Abc):  ");
        return Validate.isCheckCus(getScan().nextLine(), NAME_REGEX);
    }

    private String inputBirth() {
        System.out.println("Input birthday (XX/YY/MMMM):  ");
        return Validate.isCheckCus(getScan().nextLine(), BIRTHDAY_REGEX);
    }

    private String inputGender() {
        System.out.println("Input gender (male/ female / unknow ):  ");
        return Validate.isCheckCus(getScan().nextLine(), GENDER_REGEX);
    }

    private String inputCmnd() {
        System.out.println("Input CMND (9 number):  ");
        return Validate.isCheckCus(getScan().nextLine(), CMND_REGEX);
    }

    private String inputPhoneNumber() {
        System.out.println("Input phone number (0XXXXXXXXX):  ");
        return Validate.isCheckCus(getScan().nextLine(), PHONE_NUMBER);
    }

    private String inputEmail() {
        System.out.println("Input email ( abc@.abc.abc ):  ");
        return Validate.isCheckCus(getScan().nextLine(), EMAIL_REGEX);
    }

    private String inputAddress() {
        System.out.println("Input address (Abc):  ");
        return Validate.isCheckCus(getScan().nextLine(), REGEX_STR);
    }
    //--------------------------------

    //Phương thức getScan để sử dụng Scanner cho dễ
    public static Scanner getScan() {
        Scanner input = new Scanner(System.in);
        return input;
    }
}
