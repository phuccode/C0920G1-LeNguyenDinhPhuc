package _16_text_file.bai_tap;

import java.io.*;

public class CoppyTest {
    public static void main(String[] args) throws IOException {
        //Tạo file txt
//        File myObj = new File("newFile.txt");
//        try {
//            if(myObj.createNewFile()){
//                System.out.println("File " + myObj.getName() + " đã được tạo");
//            }
//            else {
//                System.out.println("Tập tin đã tồn tại");
//            }
//        } catch (IOException e) {
//            System.out.println("Có lỗi");
//            e.printStackTrace();
//        }
        //Ghi file
//            try {
//                FileWriter myFileWrite = new FileWriter("newFile.txt", true);
//                BufferedWriter newWrite = new BufferedWriter(myFileWrite);
//                newWrite.write("Phúc");
//                newWrite.newLine();
//                System.out.println("Đã ghi vào file");
//                newWrite.close();
//            } catch (IOException e) {
//                System.out.println("Lỗi");
//                e.printStackTrace();
//            }
        //Copy file txt(copy đè)
//        InputStream inStream = null;
//        OutputStream outStream = null;
//
//        try {
//            inStream = new FileInputStream(new File("newFile.txt"));
//            outStream = new FileOutputStream(new File("C:\\Users\\PC\\Desktop\\New Text Document.txt"));
//
//            int length;
//            byte[] buffer = new byte[1];
//
//            // copy the file content in bytes
//            while ((length = inStream.read(buffer)) > 0) {
//                outStream.write(buffer, 0, length);
//            }
//            System.out.println("File is copied successful!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            inStream.close();
//            outStream.close();
//        }
        //Copy file
        BufferedReader fileCopy = new BufferedReader(new FileReader("newFile.txt"));
        BufferedWriter filePaste =
                new BufferedWriter(new FileWriter("C:\\Users\\PC\\Desktop\\bla.txt",true));
        String line = null;
        while ((line = fileCopy.readLine()) != null){
            filePaste.write(line);
            filePaste.newLine();
        }
        filePaste.close();
        filePaste.close();
    }
}
