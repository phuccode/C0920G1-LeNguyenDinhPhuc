package on_tap.model;

public class ExportProduct extends Product{
    public String priceExport;
    public String nationalImported;

    public ExportProduct(String idProduct, String codeProduct,String nameProduct, String priceProduct, String amountProduct,
                         String producerProduct, String priceExport, String nationalImported) {
        super(idProduct, codeProduct,nameProduct, priceProduct, amountProduct, producerProduct);
        this.priceExport = priceExport;
        this.nationalImported = nationalImported;
    }

    public ExportProduct(){}

    public String getPriceExport() {
        return priceExport;
    }

    public void setPriceExport(String priceExport) {
        this.priceExport = priceExport;
    }

    public String getNationalImported() {
        return nationalImported;
    }

    public void setNationalImported(String nationalImported) {
        this.nationalImported = nationalImported;
    }


    @Override
    public String showInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return "Export Product: " + "\n" + super.toString() + "\n" +
                "priceExport: '" + priceExport + '\n' +
                "nationalImported='" + nationalImported + '\n'
                + "--------------------------------";
    }
}
