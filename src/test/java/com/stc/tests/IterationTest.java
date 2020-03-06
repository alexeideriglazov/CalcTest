package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import helpers.axiomatics.DataStorage;

public class IterationTest {
    private Calculator calc;
    public static double EPS=1e-15;
    private DataStorage data;

    @BeforeSuite
    public void setUp() {
        calc = new Calculator();
        data=new DataStorage("/src/test/java/data/AxiomaticsData");
    }

    @DataProvider
    public Object[][] threeNumbers()
    {
        Object [][] R=new Object [data.number()][3];
        for(int i =0; i<data.number(); i++) {
            R[i][0]=data.getElem(i).first;
            R[i][1]=data.getElem(i).second;
            R[i][2]=data.getElem(i).third;
        }
        return R;
    }

    @DataProvider
    public Object[][] twoNumbers()
    {
        Object [][] R=new Object [data.number()][2];
        for(int i =0; i<data.number(); i++) {
            R[i][0]=data.getElem(i).first;
            R[i][1]=data.getElem(i).second;
        }
        return R;
    }

    @DataProvider
    public Object[][] oneNumber()
    {
        Object [][] R=new Object [data.number()][1];
        for(int i =0; i<data.number(); i++) {
            R[i][0]=data.getElem(i).first;
        }
        return R;
    }

    @Test(dataProvider = "iterationSum")
    public void testIterationSum(Double first,Double second){
        assert(Math.abs(first-second)<=eps);
    }

    @Test(dataProvider = "iterationMultiplication")
    public void testIterationMultiplication(Double first,Double second){
        assert(Math.abs(first-second)<=eps);
    }

    @Test(dataProvider = "multiplicationOfOnes")
    public void testMultiplicationOfOnes(Double actual, Double expected)
    {
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "sumOfOnes")
    public void testSumOfOnes(Double actual, Double expected)
    {
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "multiplicationOfZeros")
    public void testMultiplicationOfZeros(Double actual, Double expected)
    {
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "sumOfZeros")
    public void testSumOfZeros(Double actual, Double expected)
    {
        assert(Math.abs(actual-expected)<=eps);
    }

     /*
    TODO
    @AfterSuite
    public void killAll()
    {
        calc=null;
    }
    */
}
