package service;

import model.Product;

import java.util.*;

public class ProductServicelmpl implements ProductService{
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1,new Product(1,"Samsung Note10","12.000.000","5","Samsung"));
        productMap.put(2,new Product(2,"Samsung A10","12.000.000","51","Samsung"));
        productMap.put(3,new Product(3,"Iphone 10","12.000.000","52","Iphone"));
        productMap.put(4,new Product(4,"Xiaomi Note11","12.000.000","15","Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public Product findByName(String name) {
       for(Map.Entry<Integer, Product> entry : productMap.entrySet()){
           if( entry.getValue().getName().equals(name)){
               return entry.getValue();
           }
       }
       return null;
    }
//    public Product findByName(String name) {
//        return null;
//    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }


}
