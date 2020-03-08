package helpers.operands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OperandsStorage {
    private List<SimpleData> data;

    public OperandsStorage(String filePath) {
        try {
            data = new ArrayList<>();
            List<String> allLines = Files.readAllLines(Paths.get(filePath));
            for (String line : allLines) {
                String[] str = line.split("\\s");
                SimpleData temp = new SimpleData(str);
                data.add(temp);
            }
        } catch (IOException e) {
            System.err.println(filePath + " incorrect path or file does not exist");
            e.printStackTrace();
        }
    }

    public int number() {
        return data.size();
    }

    public SimpleData getElem(int k) {
        return data.get(k);
    }
}
