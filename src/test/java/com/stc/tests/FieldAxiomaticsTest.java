package com.stc.tests;

import calc.Calculator;
import helpers.axiomatics.DataStorage;
import helpers.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FieldAxiomaticsTest {
    private Calculator calc;
    private DataStorage data;

    @BeforeSuite
    public void setUp() {
        calc = new Calculator();
        data=new DataStorage("src/test/java/data/AxiomaticsData");
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

    @Test(dataProvider = "threeNumbers")
    public void associativeMultiplicationTest(String first, String second, String third){
        Assert.assertEquals(calc.multiplication(first,String.valueOf(calc.multiplication(second,third))),
                calc.multiplication(String.valueOf(calc.multiplication(first,second)),third));
    }

    @Test(dataProvider = "threeNumbers")
    public void associativeSumTest(String first, String second, String third){
        Assert.assertEquals(calc.sum(first,String.valueOf(calc.sum(second,third))),
                calc.sum(String.valueOf(calc.sum(first,second)),third));
    }

    @Test(dataProvider = "threeNumbers")
    public void distributionTest(String first, String second, String third) {
        Assert.assertEquals(calc.multiplication(first, String.valueOf(calc.sum(second,third))),
                calc.sum(String.valueOf(calc.multiplication(first,third)),String.valueOf(calc.multiplication(first,second))));
    }

    @Test(dataProvider = "twoNumbers")
    public void commutativeSumTest(String first, String second){
        Assert.assertEquals(calc.sum(first,second),calc.sum(second,first));
    }

    @Test(dataProvider = "twoNumbers")
    public void commutativeMultiplicationTest(String first, String second){
        Assert.assertEquals(calc.multiplication(first,second),calc.multiplication(second,first));
    }

    @Test(dataProvider = "oneNumber")
    public void neutralSumTest(String first) {
        Assert.assertEquals(calc.sum(first,"0"),Double.parseDouble(first));
    }

    @Test(dataProvider = "oneNumber")
    public void neutralMultiplicationTest(String first) {
        Assert.assertEquals(calc.multiplication(first,"1"),Double.parseDouble(first));
    }

    @Test(dataProvider = "oneNumber")
    public void inverseMultiplicationTest(String first)
    {
        assert(Math.abs(calc.multiplication(first,String.valueOf(calc.division("1",first)))-1.)<=Constants.EPS);
    }

    @Test(dataProvider = "oneNumber")
    public void inverseSumTest(String first)
    {
        Assert.assertEquals(calc.sum(first,String.valueOf(calc.difference("0",first))),0.);
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