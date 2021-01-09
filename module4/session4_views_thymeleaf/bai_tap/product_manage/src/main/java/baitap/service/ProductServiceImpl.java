package baitap.service;

import baitap.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"IphoneX","12.000.000","https://taoviet.net/wp-content/uploads/2019/06/Iphone-X-Like-New.jpg","2"));
        products.put(2,new Product(2,"IphoneXs","15.000.000","https://cdn.tgdd.vn/Products/Images/42/190321/iphone-xs-max-gold-600x600.jpg","2"));
        products.put(3,new Product(3,"SamSung Note 9","11.000.000","https://baoquocte.vn/stores/news_dataimages/nguyennga/052018/11/15/155012_Samsung_GalaxyNote9_Vietnamplus.jpg","2"));
        products.put(4,new Product(4,"SamSung Note 10","16.000.000","https://cellphones.com.vn/sforum/wp-content/uploads/2019/07/Samsung-Galaxy-Note-10-render.jpg","2"));
        products.put(5,new Product(5,"Xiaomi Note 9","8.000.000","https://fdn2.gsmarena.com/vv/pics/xiaomi/xiaomi-mi-cc9-pro-1.jpg","2"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getIdProduct(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
