package helpers.axiomatics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private List<SimpleData> dataList;
    public DataStorage(String filePath){
        try {
            dataList=new ArrayList<>();
            List<String> allLines = Files.readAllLines(Paths.get(filePath));
            for (String line : allLines) {
                String[] str=line.split("\\s");
                SimpleData temp = new SimpleData(str[0], str[1], str[2]);
                dataList.add(temp);
            }
        } catch (IOException e) {
            System.err.println(filePath+ " incorrect path or file does not exist");
            e.printStackTrace();
        }
    }
    public int number(){
        return dataList.size();
    }
    public SimpleData getElem(int k){
        return dataList.get(k);
    }
}
