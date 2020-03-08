package com.stc.tests;

import calc.Calculator;
import helpers.file.FileStorage;
import helpers.file.SimpleTest;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileTest {
    private Calculator calc;
    private FileStorage data;

    @BeforeSuite
    public void setUp() {
        calc = new Calculator();
        data = new FileStorage("src/test/resources/FileData");
    }

    @DataProvider
    public Object[][] sumFileData() {
        Object[][] providerData = new Object[data.numberOfSum()][1];
        for (int i = 0; i < data.numberOfSum(); i++) {
            providerData[i][0] = data.getSum(i);
        }
        return providerData;
    }

    @DataProvider
    public Object[][] differenceFileData() {
        Object[][] providerData = new Object[data.numberOfDifference()][1];
        for (int i = 0; i < data.numberOfDifference(); i++) {
            providerData[i][0] = data.getDifference(i);
        }
        return providerData;
    }

    @DataProvider
    public Object[][] divisionFileData() {
        Object[][] providerData = new Object[data.numberOfDivision()][1];
        for (int i = 0; i < data.numberOfDivision(); i++) {
            providerData[i][0] = data.getDivision(i);
        }
        return providerData;
    }

    @DataProvider
    public Object[][] multiplicationFileData() {
        Object[][] providerData = new Object[data.numberOfMultiplication()][1];
        for (int i = 0; i < data.numberOfMultiplication(); i++) {
            providerData[i][0] = data.getMultiplication(i);
        }
        return providerData;
    }

    @Test(dataProvider = "sumFileData")
    public void sumTest(SimpleTest input) {
        System.out.println("sumTest is starting with input data: " + input.leftOperand + " and " + input.rightOperand);
        double actual = calc.sum(input.leftOperand, input.rightOperand);
        double difference = Math.abs(actual - input.expectedResult);
        Assert.assertEquals(actual, input.expectedResult, "Difference is: " + difference
        );
    }

    @Test(dataProvider = "differenceFileData")
    public void differenceTest(SimpleTest input) {
        System.out.println("differenceTest is starting with input data: " + input.leftOperand + " and " + input.rightOperand);
        double actual = calc.difference(input.leftOperand, input.rightOperand);
        double difference = Math.abs(actual - input.expectedResult);
        Assert.assertEquals(actual, input.expectedResult, "Difference is: " + difference);
    }

    @Test(dataProvider = "divisionFileData")
    public void divisionTest(SimpleTest input) {
        System.out.println("divisionTest is starting with input data: " + input.leftOperand + " and " + input.rightOperand);
        double actual = calc.division(input.leftOperand, input.rightOperand);
        double difference = Math.abs(actual - input.expectedResult);
        Assert.assertEquals(actual, input.expectedResult, "Difference is: " + difference);
    }

    @Test(dataProvider = "multiplicationFileData")
    public void multiplicationTest(SimpleTest input) {
        System.out.println("multiplicationTest is starting with input data: " + input.leftOperand + " and " + input.rightOperand);
        double actual = calc.multiplication(input.leftOperand, input.rightOperand);
        double difference = Math.abs(actual - input.expectedResult);
        Assert.assertEquals(actual, input.expectedResult, "Difference is: " + difference);
    }

    /*
    TODO
    @AfterSuite
    public void killAll()
    {
        calc=null;
        data=null;
        printWriter.close();
    }
    */
}
