package _19_string_va_regex.bai_tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNum {
    private static final String CLASS_REGEX = "[(](84)[)][-][(][0-9]+[)]";
    ValidatePhoneNum(){
    }

    public boolean validate(String regex){
        Pattern pattern = Pattern .compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    private static ValidatePhoneNum validatePhoneNum;

    public static final String[] validAccount = new String[] {"(84)-(0978489648)"};
    public static final String[] invalidAccount = new String[] {"(a8)-(22222222)"};
    public static void main(String[] args) {
        validatePhoneNum = new ValidatePhoneNum();
        for (String account : validAccount) {
            boolean isvalid = validatePhoneNum.validate(account);
            System.out.println("Account is " + account +" is valid: "+ isvalid);
        }
        for (String account : invalidAccount) {
            boolean isvalid = validatePhoneNum.validate(account);
            System.out.println("Account is " + account +" is valid: "+ isvalid);
        }
    }
}
