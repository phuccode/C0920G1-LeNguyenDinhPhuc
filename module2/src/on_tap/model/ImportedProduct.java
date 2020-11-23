package on_tap.model;

public class ImportedProduct extends Product {
    public String priceImported;
    public String province;
    public String tax;

    public ImportedProduct(String idProduct, String codeProduct,String nameProduct, String priceProduct,
                           String amountProduct, String producerProduct, String priceImported,
                           String province, String tax) {
        super(idProduct, codeProduct,nameProduct, priceProduct, amountProduct, producerProduct);
        this.priceImported = priceImported;
        this.province = province;
        this.tax = tax;
    }
    public ImportedProduct(){}

    public String getPriceImported() {
        return priceImported;
    }

    public void setPriceImported(String priceImported) {
        this.priceImported = priceImported;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }


    @Override
    public String showInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return "Imported Product" + "\n" + super.toString() + "\n" +
                "priceImported: '" + priceImported + '\n' +
                "province: '" + province + '\n' +
                "tax: '" + tax + '\n' +
                "--------------------------------";
    }
}
