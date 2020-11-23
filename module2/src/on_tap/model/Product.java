package on_tap.model;

public abstract class Product {
    public String idProduct;
    public String codeProduct;
    public String nameProduct;
    public String priceProduct;
    public String amountProduct;
    public String producerProduct;

    public Product(String idProduct, String codeProduct, String nameProduct, String priceProduct, String amountProduct, String producerProduct) {
        this.idProduct = idProduct;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.amountProduct = amountProduct;
        this.producerProduct = producerProduct;
    }

    public Product(){}

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getProducerProduct() {
        return producerProduct;
    }

    public void setProducerProduct(String producerProduct) {
        this.producerProduct = producerProduct;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(String amountProduct) {
        this.amountProduct = amountProduct;
    }

    public abstract String showInfo();

    @Override
    public String toString() {
        return "Product: " +
                "idProduct: " + idProduct + '\n' +
                "nameProduct: " + nameProduct + "\n" +
                "codeProduct: '" + codeProduct + '\n'+
                "priceProduct='" + priceProduct + '\n' +
                "amountProduct='" + amountProduct + '\n' +
                "producerProduct='" + producerProduct + '\n';
    }
}
