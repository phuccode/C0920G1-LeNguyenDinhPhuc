package baitap.model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private String priceProduct;
    private String imgProduct;
    private String quantity;

    public Product(int idProduct, String nameProduct, String priceProduct, String imgProduct, String quantity) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.imgProduct = imgProduct;
        this.quantity = quantity;
    }

    public Product() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
