package on_tap.manage;

import case_study.commos.ReadWriteFile;
import case_study.models.House;
import case_study.models.Room;
import case_study.models.Villa;
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
    String fileImport = "src/on_tap/data/Imported.csv";
    String fileExport = "src/on_tap/data/Export.csv";

    public void addNewImported() {
        ImportedProduct importedProduct = new ImportedProduct(inputId(),inputCode(),inputName(),inputPriceProduct(),
                inputAmountProduct(),inputProducer(),inputPriceImported(),inputProvince(),inputTaxt());
        importedProductList.add(importedProduct);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileImport, true));
            for (ImportedProduct importedProduct1 : importedProductList) {
                writer.write(importedProduct1.getIdProduct() + "," + importedProduct1.getCodeProduct() + "," +
                        importedProduct1.getNameProduct() + "," + importedProduct1.getPriceProduct() + "," +
                        importedProduct1.getAmountProduct() + "," + importedProduct1.getProducerProduct() + "," +
                        importedProduct1.getPriceImported() + "," + importedProduct1.getProvince() + "," +
                        importedProduct1.getTax());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewExport() {
        ExportProduct exportProduct = new ExportProduct(inputId(),inputCode(),inputName(),inputPriceProduct(),
                inputAmountProduct(),inputProducer(),inputPriceExport(),inputNational());
        exportProductList.add(exportProduct);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileExport, true));
            for (ExportProduct exportProduct1 : exportProductList) {
                writer.write(exportProduct1.getIdProduct() + "," + exportProduct1.getCodeProduct() + "," +
                        exportProduct1.getNameProduct() + "," + exportProduct1.getPriceProduct() + "," +
                        exportProduct1.getAmountProduct() + "," + exportProduct1.getProducerProduct() + "," +
                        exportProduct1.getPriceExport() + "," + exportProduct1.getNationalImported());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDataImported() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileImport));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] countLine;
                countLine = line.split(",");
                ImportedProduct importedProduct = new ImportedProduct(countLine[0], countLine[1], countLine[2], countLine[3],
                        countLine[4], countLine[5], countLine[6], countLine[7], countLine[8]);
                importedProductList.add(importedProduct);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDataExport() {
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(fileExport));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] countLine;
//                countLine = line.split(",");
//                ExportProduct exportProduct = new ExportProduct(countLine[0], countLine[1], countLine[2], countLine[3],
//                        countLine[4], countLine[5], countLine[6], countLine[7]);
//                exportProductList.add(exportProduct);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void showImported() {
        for (ImportedProduct importedProduct : importedProductList) {
            System.out.println(importedProduct.showInfo());
        }
    }

    public void showExport() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileExport));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] countLine;
                countLine = line.split(",");
                ExportProduct exportProduct = new ExportProduct(countLine[0], countLine[1], countLine[2], countLine[3],
                        countLine[4], countLine[5], countLine[6], countLine[7]);
                List<ExportProduct> list = new ArrayList<>();
                list.clear();
                System.out.println(list);
                list.add(exportProduct);
                for (ExportProduct s : list) {
                    System.out.println(s.showInfo());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
