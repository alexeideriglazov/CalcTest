package helpers.file;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileStorage {
    private List<SimpleTest> toSum;
    private List<SimpleTest> toDifference;
    private List<SimpleTest> toMultiplication;
    private List<SimpleTest> toDivision;

    public FileStorage(String filePath) {
        toSum = new ArrayList<>();
        toDifference = new ArrayList<>();
        toMultiplication = new ArrayList<>();
        toDivision = new ArrayList<>();
        try {
            List<String> allLines = Files.readAllLines(Paths.get(filePath));
            for (String line : allLines) {
                String[] str = line.split("\\s");
                SimpleOperation temp = new SimpleOperation(str[0], str[1], str[2], str[3]);
                SimpleTest t = new SimpleTest(temp);
                switch (temp.operation) {
                    case sum:
                        toSum.add(t);
                        break;
                    case diff:
                        toDifference.add(t);
                        break;
                    case mult:
                        toMultiplication.add(t);
                        break;
                    case div:
                        toDivision.add(t);
                        break;
                    default:
                        System.err.println("Operation skipped");
                }

            }
        } catch (IOException e) {
            System.err.println(filePath + " incorrect path or file does not exist");
            e.printStackTrace();
        }
    }

    public int numberOfSum() {
        return this.toSum.size();
    }

    public int numberOfDifference() {
        return this.toDifference.size();
    }

    public int numberOfMultiplication() {
        return this.toMultiplication.size();
    }

    public int numberOfDivision() {
        return this.toDivision.size();
    }

    public SimpleTest getSum(int k) {
        return this.toSum.get(k);
    }

    public SimpleTest getDifference(int k) {
        return this.toDifference.get(k);
    }

    public SimpleTest getMultiplication(int k) {
        return this.toMultiplication.get(k);
    }

    public SimpleTest getDivision(int k) {
        return this.toDivision.get(k);
    }
}
