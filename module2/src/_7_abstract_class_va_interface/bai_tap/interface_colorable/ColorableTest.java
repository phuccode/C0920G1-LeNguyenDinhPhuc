package _7_abstract_class_va_interface.bai_tap.interface_colorable;

public class ColorableTest {
    public static void main(String[] args) {
        //Tạo mảng Rectangle vì Rectangle là mảng cha chứa Square.
        Rectangle[] rectangle = new Rectangle[3];
        //Đưa phần tử vào mảng
        rectangle[0] = new Square(3, 3, "red");
        rectangle[1] = new Rectangle(1, 2);
        rectangle[2] = new Square(2, 2, "blue");
        //Bây giờ object Square đang mang thuộc tính và phương thức của Rectangle.
        //Test lớp rectangle[0] đang mang những kiếu gì
        //1.Kiểu Square
        //((Square) rectangle[0]).howToColor();
        //2.Kiểu Rectangle
        //((Rectangle) rectangle[0]).getArea();
        //3.Kiểu Interface Colorable
        //((Colorable) rectangle[0]).howToColor();
        //Hiện nguyên bản của mảng đã tạo để so sánh.
        for (Rectangle rectangle1 : rectangle) {
            System.out.println(rectangle1);
        }

        //Bây giờ Square đang mang 2 kiểu là Rectangle và Square
        //Ép kiểu để nó về kiểu Square vì chứa phương thức howtoColor() của Interface Colorable.
        for(Rectangle rectangle1 : rectangle){
            //Dùng instanceof để xem nếu đối tượng có mang kiểu Square
            if ( rectangle1 instanceof Square){
                /*Test nếu để lớp con là Interface Colorable vẫn được
                vì ta dùng phương thức override nên sẽ hiểu là dùng phương thức
                howtoColor() lớp con.
                 */
                //((Colorable) rectangle1).howToColor();
                System.out.println("Add Colorable: " + rectangle1);
                ((Square) rectangle1).howToColor();
            }
            else {
                System.out.println("No Colorable: " + rectangle1);
            }
        }
    }
}
