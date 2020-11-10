package _12_java_collection_framework.thuc_hanh.quan_ly_sinh_vien;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {

    public static void main(String[] args) {
        //Lưu danh sách sinh viên
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);
        System.out.println("Hiển thị các mục trong HashMap");
        System.out.println(hashMap + "\n");

        //Lưu key theo thứ tự giảm dần
        //Theo TreeMap sẽ chọn key để tăng dần
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Hiển thị các mục theo thứ tự tăng dần");
        System.out.println(treeMap);

        //Lưu danh sách sinh viên và hiển thị kiểu dữ liệu
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println("\nTuổi của " + "Lewis là " + linkedHashMap.get("Lewis"));

    }

}
