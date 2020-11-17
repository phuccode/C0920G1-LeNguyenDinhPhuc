package _19_string_va_regex.bai_tap;

import _19_string_va_regex.thuc_hanh.AccountExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNameClass {
    private static final String CLASS_REGEX = "[CAP][0-9]{4}[GHIKLM]";
    ValidateNameClass(){
    }

    public boolean validate(String regex){
        Pattern pattern = Pattern .compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    private static ValidateNameClass validateNameClass;

    public static final String[] validAccount = new String[] {"C0318G"};
    public static final String[] invalidAccount = new String[] {"M0318G","P0323A"};
    public static void main(String[] args) {
        validateNameClass = new ValidateNameClass();
        for (String account : validAccount) {
            boolean isvalid = validateNameClass.validate(account);
            System.out.println("Account is " + account +" is valid: "+ isvalid);
        }
        for (String account : invalidAccount) {
            boolean isvalid = validateNameClass.validate(account);
            System.out.println("Account is " + account +" is valid: "+ isvalid);
        }
    }
}
