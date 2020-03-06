package com.stc.tests;

import calc.Calculator;
import helpers.Constants;
import helpers.random.RandomData;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MatchingTest {
    private Calculator calc1;
    private Calculator calc2;
    private RandomData data1;
    private RandomData data2;

    @BeforeSuite
    public void setUp()
    {
        calc1=new Calculator();
        calc2=new Calculator();
        data1=new RandomData();
        data2=new RandomData();
    }

    @DataProvider
    public Object[][] inputData()
    {
        Object [][] R=new Object [Constants.NUMBER][2];
        for(int i =0; i<Constants.NUMBER; i++) {
            R[i][0]=data1.randData.get(i);
            R[i][1]=data2.randData.get(i);
        }
        return R;
    }

    @Test(dataProvider = "inputData")
    public void sumTest(String first, String second) {
        Assert.assertEquals(calc1.sum(first,second),calc2.sum(first,second));
    }

    @Test(dataProvider = "inputData")
    public void differenceTest(String first, String second) {
        Assert.assertEquals(calc1.difference(first,second),calc2.difference(first,second));
    }

    @Test(dataProvider = "inputData")
    public void divisionTest(String first, String second) {
        Assert.assertEquals(calc1.division(first,second),calc2.division(first,second));
    }

    @Test(dataProvider = "inputData")
    public void multiplicationTest(String first, String second) {
        Assert.assertEquals(calc1.multiplication(first,second),calc2.multiplication(first,second));
    }

     /*
    TODO
    @AfterSuite
    public void killAll()
    {
        calc1=null;
        calc2=null;
    }
    */
}
