package case_study.commos;

import case_study.controllers.MainController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static String note = "You entered incorrectly.Please re-enter";
    private static final String VILLA_REGEX = "SVVL-[0-9]{4}";
    private static final String HOUSE_REGEX = "SVHO-[0-9]{4}";
    private static final String ROOM_REGEX = "SVRO-[0-9]{4}";
    private static final String NAME_SERVICES ="[A-Z][a-z]+";
    private static final String ACCOMPANIED_SERVICES = "(massage)|(karaoke)|(food)|(drink)|(car rental)";
    //Diện tích hồ bơi
    private static final String AREA = "([1-9][0-9][0-9])|([3-9][0-9])|[.][0-9]+";
    //Chi phí thuê
    private static final String RENTAL_COST = "[1-9]+";
    //Số lượng người đi tối đa
    private static final String MAX_PEOPLE = "[1-9]|[1][0-9]|(20)";
    private static final String RENTAL_TYPE = "[A-Z][a-z]+";
    private static final String STANDARD_ROOM = "[A-Z][a-z]+";
    private static final String BIRTHDAY_REGEX = "^(((0[1-9]|[12][0-9]|30)[-\\/](0[13-9]|1[012])|31[-\\/](0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-\\/]02)" +
            "[-\\/](19[0-9]{2}|200[012])|29[-\\/]02[-\\/]" +
            "([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$";
    private static final String NAME_REGEX ="^([A-Z][a-z]+\\s)+(|[A-Z][a-z]+)$";
    private static final String EMAIL_REGEX ="^[a-z0-9_]+[a-z0-9]@([a-z0-9]+\\.)[a-z]+(|\\.[a-z]+)$";
    private static final String GENDER_REGEX = "^[mM][aA][lL][eE]|[fF][eE][mM][aA][lL][eE]|[uU][nN][kK][nN][oO][wW]$";
    private static final String ID_CARD = "^[0-9]{9}$";
    private static Matcher matcher;
    private static Pattern pattern;

    public static String isCheck(String input, String regex){
        boolean check = false;
        do {
            if(input.matches(regex)){
                check = true;
            }else {
                System.err.println("Error please input again");
                input = MainController.getScan().nextLine();
            }
        }while (!check);
        return input;
    }
}
