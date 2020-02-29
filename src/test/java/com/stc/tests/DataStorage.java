package com.stc.tests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataStorage {
    private List<List<String>> toSum;
    private List<List<String>> toDifference;
    private List<List<String>> toMultiplication;
    private List<List<String>> toDivision;
    public DataStorage(String filePath)
    {
        toSum=new ArrayList<>();
        toDifference=new ArrayList<>();
        toMultiplication=new ArrayList<>();
        toDivision=new ArrayList<>();
        try {
            List<String> allLines = Files.readAllLines(Paths.get(filePath));
            List<List<String>> tempSum=new LinkedList<>();
            List<List<String>> tempDifference=new LinkedList<>();
            List<List<String>> tempDivision=new LinkedList<>();
            List<List<String>> tempMultiplication=new LinkedList<>();
            for (String line : allLines) {
                String[] str=line.split("\\s");
                List<String> temp=new LinkedList<>();
                try {
                    switch (str[2]) {
                        case "sum":
                            temp.add(str[0]);
                            temp.add(str[1]);
                            temp.add(str[3]);
                            tempSum.add(temp);
                            break;
                        case "difference":
                            temp.add(str[0]);
                            temp.add(str[1]);
                            temp.add(str[3]);
                            tempDifference.add(temp);
                            break;
                        case "multiplication":
                            temp.add(str[0]);
                            temp.add(str[1]);
                            temp.add(str[3]);
                            tempMultiplication.add(temp);
                            break;
                        case "division":
                            temp.add(str[0]);
                            temp.add(str[1]);
                            temp.add(str[3]);
                            tempDivision.add(temp);
                            break;
                        default:
                            System.err.print(str[2]);
                            System.err.println(" method does not exist");
                    }
                }catch(IndexOutOfBoundsException ex) {
                    System.err.println("Check input data!");
                    ex.printStackTrace();
                }
            }
            toSum.addAll(tempSum);
            toDivision.addAll(tempDivision);
            toDifference.addAll(tempDifference);
            toMultiplication.addAll(tempMultiplication);
        } catch (IOException e) {
            System.err.print(filePath);
            System.err.println(" incorrect path or file does not exist");
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

    public List<String> getSum(int k) {
        return this.toSum.get(k);
    }

    public List<String> getDifference(int k){
        return this.toDifference.get(k);
    }

    public List<String> getMultiplication(int k){
        return this.toMultiplication.get(k);
    }

    public List<String> getDivision(int k){
        return this.toDivision.get(k);
    }
}
