package _00.validate;

import _00.Main.Main;

public class Validate {
    public static String regexStr(String temp, String regex, String error){
        boolean check = true;
        do {
            if (temp.matches(regex)){
                check = false;
            } else {
                System.err.println(error);
                temp = Main.enter().nextLine();
            }
        } while (check);
        return temp;
    }
}
