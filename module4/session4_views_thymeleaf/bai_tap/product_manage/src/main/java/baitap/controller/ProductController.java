package baitap.controller;

import baitap.model.Product;
import baitap.service.ProductService;
import baitap.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService = new ProductServiceImpl();

    @GetMapping("/")
    public String index(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "/index";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/product/save")
    public String save(Product product) {
        product.setIdProduct((int)(Math.random() * 10000));
        productService.save(product);
        return "redirect:/";
    }
}
