package _15_xu_li_ngoai_le_debug.bai_tap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IllegalTriangleException{
    public static void main(String[] args) {
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Nhập cạnh a");
            int edgeA = input.nextInt();
            System.out.println("Nhập cạnh b");
            int edgeB = input.nextInt();
            System.out.println("Nhập cạnh c");
            int edgeC = input.nextInt();
            checkTriangle(edgeA,edgeB,edgeC);
        }
        catch (ExceptionTriangle e){
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Nhập số");
        }
    }

    public static void checkTriangle(int a , int b, int c) throws ExceptionTriangle{
        if(a + b < c){
            throw new ExceptionTriangle();
        }
        else {
            System.out.println("good");
        }
    }
}
