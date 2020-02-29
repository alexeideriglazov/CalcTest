package com.stc.tests;

import calc.Calculator;
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
        data=new DataStorage("src/test/java/com/stc/tests/numbers");
    }

    @DataProvider
    public Object[][] sumFileData()
    {
        Object [][] R=new Double [data.numberOfSum()][2];
        for(int i =0; i<data.numberOfSum(); i++) {
            R[i][0]=calc.sum(data.getSum(i).get(0),data.getSum(i).get(1));
            R[i][1]=Double.parseDouble(data.getSum(i).get(2));
        }
        return R;
    }

    @DataProvider
    public Object[][] differenceFileData()
    {
        Object [][] R=new Double [data.numberOfDifference()][2];
        for(int i =0; i<data.numberOfDifference(); i++) {
            R[i][0]=calc.difference(data.getDifference(i).get(0),data.getDifference(i).get(1));
            R[i][1]=Double.parseDouble(data.getDifference(i).get(2));
        }
        return R;
    }

    @DataProvider
    public Object[][] divisionFileData()
    {
        Object [][] R=new Double [data.numberOfDivision()][2];
        for(int i =0; i<data.numberOfDivision(); i++) {
            R[i][0]=calc.division(data.getDivision(i).get(0),data.getDivision(i).get(1));
            R[i][1]=Double.parseDouble(data.getDivision(i).get(2));
        }
        return R;
    }

    @DataProvider
    public Object[][] multiplicationFileData()
    {
        Object [][] R=new Double [data.numberOfMultiplication()][2];
        for(int i =0; i<data.numberOfMultiplication(); i++) {
            R[i][0]=calc.multiplication(data.getMultiplication(i).get(0),data.getMultiplication(i).get(1));
            R[i][1]=Double.parseDouble(data.getMultiplication(i).get(2));
        }
        return R;
    }

    @Test(dataProvider = "sumFileData")
    public void sumTest(Double actual, Double expected) {
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "differenceFileData")
    public void differenceTest(Double actual, Double expected) {
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "divisionFileData")
    public void divisionTest(Double actual, Double expected) {
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "multiplicationFileData")
    public void multiplicationTest(Double actual, Double expected) {
        Assert.assertEquals(actual,expected);
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
