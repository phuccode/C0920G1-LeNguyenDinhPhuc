package on_tap.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReadWrite {
    public static void writeFile(String filePath, String line) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeFile(String filePath) {
        try {
            new FileWriter(filePath, false).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> readFile(String filePath) {
        List<String[]> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                String[] elementLine = line.split(",");
                list.add(elementLine);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
