package com.stc.tests;

import calc.Calculator;
import helpers.Constants;
import helpers.random.RandomData;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IterationTest {
    private Calculator calc;
    private RandomData data;
    private double zero1=0;
    private double zero2=0;
    private double one1=1.;
    private double one2=1.;

    @BeforeSuite
    public void setUp(){
        calc=new Calculator();
        data=new RandomData();

    }

    @DataProvider
    public Object[][] inputData()
    {
        Object [][] R=new Object [Constants.NUMBER][2];
        for(int i =0; i<Constants.NUMBER; i++) {
            R[i][0]=data.randData.get(i);
            R[i][1]=data.randData.get(Constants.NUMBER-i-1);
        }
        return R;
    }

    @Test(dataProvider = "inputData")
    public void testMult(String first, String second){
        one1=calc.multiplication(first,String.valueOf(one1));
        one2=calc.multiplication(second,String.valueOf(one2));
    }

    @Test(dataProvider = "inputData")
    public void testSum(String first, String second){
        zero1=calc.sum(first,String.valueOf(zero1));
        zero2=calc.sum(second,String.valueOf(zero2));
    }

    @AfterClass
    public void isCorrect(){
        if(zero1==zero2)
            System.out.println("Iteration test for sum is passed");
        else
            System.err.println("Iteration test for sum is failed");
        if(one1==one2)
            System.out.println("Iteration test for multiplication is passed");
        else
            System.err.println("Iteration test for multiplication is failed");
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
