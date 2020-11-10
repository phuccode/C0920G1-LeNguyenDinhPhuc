package _12_java_collection_framework.bai_tap.quan_ly_san_pham;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ProductManager extends Product {
    List<ProductManager> product = new ArrayList<>();
    int count = 1;
       public ProductManager(int id, String name, double price) {
           super(id, name, price);
       }
       ProductManager(){
       }
       public String inputName(){
           System.out.println("Nhập tên sản phẩm");
           return Test.getScan().nextLine();
       }

//       public int inputId(){
//           System.out.println("Nhập ID cho sản phẩm");
//           return Test.getScan().nextInt();
//       }

        public double inputPrice(){
            System.out.println("Nhập giá cho sản phẩm");
            return Test.getScan().nextDouble();
        }

        //Thêm sản phẩm
       public void addProduct(){
           setId(count++);
           setName(inputName());
           setPrice(inputPrice());
           ProductManager product1 = new ProductManager(getId(), getName(), getPrice());
           product.add(product1);
       }

       //Hiển thị sản phẩm
       public void disPlay(){
           //Dùng comparator để sắp xếp sả phẩm tăng dần theo giá
           Collections.sort(product, new Comparator<ProductManager>() {
               @Override
               public int compare(ProductManager o1, ProductManager o2) {
                   return o1.getPrice() > o2.getPrice()?1:-1;
               }
           });
           for (ProductManager s: product) {
               System.out.println("ID: " + s.getId()
                       + "\nTên: " + s.getName() + "\nGiá: " + s.getPrice()
                       );
               System.out.println("-------------------------------------");
           }
       }

       //Xóa sản phẩm theo ID
        public void removeProduct(){
            System.out.println("Vui lòng nhập ID sản phẩm bạn muốn xóa: ");
            boolean check = false;
            int id = Test.getScan().nextInt();

            for(int i = 0; i < product.size(); i++){
                if( id == product.get(i).getId()){
                    product.remove(i);
                    System.out.println("Sản phẩm có ID " + getId() + " đã bị xóa");
                    check = true;
                }
            }
            if( !check ){
                System.out.println("ID này không có trong danh sách");
            }
        }

        //Tìm theo sản phẩm theo Tên
        public void findProduct(){
            System.out.println("Vui lòng nhập tên sản phẩm bạn muốn tìm");
            String name = Test.getScan().nextLine();
            boolean check = false;

            for (int i = 0; i < product.size(); i++){
                if(name.equals(product.get(i).getName())){
                    System.out.println("ID: " + product.get(i).getId());
                    System.out.println("Tên: " + product.get(i).getName());
                    System.out.println("Giá: " + product.get(i).getPrice());
                    System.out.println("----------------------------------");
                    check = true;
                }
            }
            if(!check){
                System.out.println("Tên bạn nhập không có trong danh sách");
            }
        }
        //Sửa thông tin sản phẩm theo ID
        public void editProduct(){
            System.out.println("Nhập ID sản phẩm bạn muốn sửa");
            int id = Test.getScan().nextInt();
            boolean check = false;

            for(ProductManager s: product){
                if( id == s.getId()){
                    System.out.println("Nhập 1 để sửa ID");
                    System.out.println("Nhập 2 để sửa tên");
                    System.out.println("Nhập 3 để sửa giá sản phẩm");
                    switch (Test.getScan().nextInt()){
                        case 1:{
                            System.out.println("Sửa ID");
                            s.setId(Test.getScan().nextInt());
                            break;
                        }
                        case 2:{
                            System.out.println("Sửa tên");
                            s.setName(Test.getScan().nextLine());
                            break;
                        }
                        case 3:{
                            System.out.println("Sửa giá tiền");
                            s.setPrice(Test.getScan().nextDouble());
                            break;
                        }
                    }
                    check = true;
                }
                if( !check){
                    System.out.println("ID này không có trong danh sách");
                }
            }
        }
}
