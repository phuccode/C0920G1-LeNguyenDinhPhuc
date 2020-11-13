package _15_xu_li_ngoai_le_debug.bai_tap;

public class ExceptionTriangle extends Exception {
   public ExceptionTriangle(String msg){
       super(msg);
   }

   public ExceptionTriangle(){
       super("Tổng hai cạnh phải lớn hơn cạnh còn lại");
   }
}
