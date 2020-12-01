package on_tap.manage;

import case_study.commos.ReadWriteFile;
import case_study.models.House;
import case_study.models.Room;
import case_study.models.Villa;
import on_tap.controller.FileReadWrite;
import on_tap.model.ExportProduct;
import on_tap.model.ImportedProduct;
import on_tap.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManage {
    public static List<ImportedProduct> importedProductList = new ArrayList<>();
    List<ExportProduct> exportProductList = new ArrayList<>();
    String fileProduct = "src/on_tap/data/products.csv";

    public void addNewProduct() {
        int id = (importedProductList.size() > 0 ) ? (importedProductList.size() + 1) : 1;
        System.out.println("ID :" + id);
        ImportedProduct importedProduct = new ImportedProduct(id,inputCode(),inputName(),inputPriceProduct(),
                inputAmountProduct(),inputProducer(),inputPriceImported(),inputProvince(),inputTaxt());
        importedProductList.add(importedProduct);
        FileReadWrite.writeFile(fileProduct,importedProduct.getIdProduct() + "," + importedProduct.getCodeProduct() + "," +
                        importedProduct.getNameProduct() + "," + importedProduct.getPriceProduct() + "," +
                        importedProduct.getAmountProduct() + "," + importedProduct.getProducerProduct() + "," +
                        importedProduct.getPriceImported() + "," + importedProduct.getProvince() + "," +
                        importedProduct.getTax());
    }

    public void addNewExport() {
        int id = (importedProductList.size() > 0) ? (importedProductList.size() + 1) : 1;
        System.out.println("ID :" + id);
        ExportProduct exportProduct = new ExportProduct(id, inputCode(), inputName(), inputPriceProduct(),
                inputAmountProduct(), inputProducer(), inputPriceExport(), inputNational());
        exportProductList.add(exportProduct);
        FileReadWrite.writeFile(fileProduct, exportProduct.getIdProduct() + "," + exportProduct.getCodeProduct() + "," +
                exportProduct.getNameProduct() + "," + exportProduct.getPriceProduct() + "," +
                exportProduct.getAmountProduct() + "," + exportProduct.getProducerProduct() + "," +
                exportProduct.getPriceExport() + "," + exportProduct.getNationalImported());
    }

    public void showImported() {
        for (ImportedProduct importedProduct : importedProductList) {
            System.out.println(importedProduct.showInfo());
        }
    }

    public void deleteImported(){
        String delete = getScan().nextLine();
        for (Product i : importedProductList){
            if(delete == i.getNameProduct()){
                importedProductList.remove(i);
            }
        }
    }
    public String inputId(){
        System.out.println("Nhập Id sản phẩm");
        return getScan().nextLine();
    }
       public String inputCode(){
        System.out.println("Nhập mã sản phẩm");
        return getScan().nextLine();
    }

    public String inputName(){
        System.out.println("Nhập tên sản phẩm");
        return getScan().nextLine();
    }


    public String inputPriceProduct(){
        System.out.println("Nhập giá sản phẩm");
        return getScan().nextLine();
    }

    public String inputAmountProduct(){
        System.out.println("Nhập số lượng sản phẩm");
        return getScan().nextLine();
    }

    public String inputProducer(){
        System.out.println("Nhập nhà sản xuất sản phẩm");
        return getScan().nextLine();
    }

    public String inputPriceImported(){
        System.out.println("Nhập giá nhập khẩu");
        return getScan().nextLine();
    }

    public String inputProvince(){
        System.out.println("Nhập tỉnh thành nhập khẩu sản phẩm");
        return getScan().nextLine();
    }

    public String inputTaxt(){
        System.out.println("Nhập thuế nhập khẩu sản phẩm");
        return getScan().nextLine();
    }

    public String inputPriceExport(){
        System.out.println("Nhập giá xuất khẩu sản phẩm");
        return getScan().nextLine();
    }

    public String inputNational(){
        System.out.println("Nhập quốc gia nhập khẩu sản phẩm");
        return getScan().nextLine();
    }
    public Scanner getScan(){
        Scanner input = new Scanner(System.in);
        return input;
    }
}
