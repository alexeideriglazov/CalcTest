package com.stc.tests;

import calc.Calculator;
import helpers.file.DataStorage;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileTest {
    private Calculator calc;
    private DataStorage data;

    @BeforeSuite
    public void setUp()
    {
        calc=new Calculator();
        data=new DataStorage("src/test/java/data/FileData");
    }

    @DataProvider
    public Object[][] sumFileData()
    {
        Object [][] R=new Object [data.numberOfSum()][3];
        for(int i =0; i<data.numberOfSum(); i++) {
            R[i][0]=data.getSum(i).left;
            R[i][1]=data.getSum(i).right;
            R[i][2]=data.getSum(i).excepted;
        }
        return R;
    }

    @DataProvider
    public Object[][] differenceFileData()
    {
        Object [][] R=new Object [data.numberOfDifference()][3];
        for(int i =0; i<data.numberOfDifference(); i++) {
            R[i][0]=data.getDifference(i).left;
            R[i][1]=data.getDifference(i).right;
            R[i][2]=data.getDifference(i).excepted;
        }
        return R;
    }

    @DataProvider
    public Object[][] divisionFileData()
    {
        Object [][] R=new Object [data.numberOfDivision()][3];
        for(int i =0; i<data.numberOfDivision(); i++) {
            R[i][0]=data.getDivision(i).left;
            R[i][1]=data.getDivision(i).right;
            R[i][2]=data.getDivision(i).excepted;
        }
        return R;
    }

    @DataProvider
    public Object[][] multiplicationFileData()
    {
        Object [][] R=new Object [data.numberOfMultiplication()][3];
        for(int i =0; i<data.numberOfMultiplication(); i++) {
            R[i][0]=data.getMultiplication(i).left;
            R[i][1]=data.getMultiplication(i).right;
            R[i][2]=data.getMultiplication(i).excepted;
        }
        return R;
    }

    @Test(dataProvider = "sumFileData")
    public void sumTest(String left, String right, Double expected) {
        Assert.assertEquals(calc.sum(left,right),expected);
    }

    @Test(dataProvider = "differenceFileData")
    public void differenceTest(String left, String right, Double expected) {
        Assert.assertEquals(calc.difference(left,right),expected);
    }

    @Test(dataProvider = "divisionFileData")
    public void divisionTest(String left, String right, Double expected) {
        Assert.assertEquals(calc.division(left,right),expected);
    }

    @Test(dataProvider = "multiplicationFileData")
    public void multiplicationTest(String left, String right, Double expected) {
        Assert.assertEquals(calc.multiplication(left,right),expected);
    }

    /*
    TODO
    @AfterSuite
    public void killAll()
    {
        calc=null;
        data=null;
    }
    */
}
