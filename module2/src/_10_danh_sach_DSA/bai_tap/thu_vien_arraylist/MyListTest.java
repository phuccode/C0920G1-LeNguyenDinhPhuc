package _10_danh_sach_DSA.bai_tap.thu_vien_arraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(2,3);
        myList.remove(2);
       myList.disPlay();
    }
}
