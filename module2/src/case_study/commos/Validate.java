package case_study.commos;

import case_study.controllers.MainController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static String isCheck(String input, String regex){
        boolean check = false;
        do {
            if(input.matches(regex)){
                check = true;
            }else {
                System.err.println("Input wrong format please try again");
                input = MainController.getScan().nextLine();
            }
        }while (!check);
        return input;
    }

    public static String isCheckCus(String input ,String regex){
        boolean check = true;
        do {
            try{
                if (input.matches(regex)){
                    check = false;
                } else {
                    throw new NameException("Input wrong format please try again");
                }
            }catch (NameException e ){
                System.err.println(e.getMessage());
                input = MainController.getScan().nextLine();
            }
        } while (check);
        return input;
    }

}
