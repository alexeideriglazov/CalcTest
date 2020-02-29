package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.Vector;

public class IterationTest {
    private Calculator calc;
    private int number;
    Vector<Double> data;
    double eps;

    @BeforeSuite
    public void setUp() {
        number = 100;
        eps=1e-15;
        calc = new Calculator();
        data=new Vector<>(number);
        Random r=new Random();
        for (int i = 0 ;i<number;i ++){
            data.add(i,r.nextDouble()*100*Math.pow(-1,i));
        }
    }

    @DataProvider
    public Object[][] iterationSum() {
        Object[][] R=new Double[1][2];
        Double temp1=0.;
        Double temp2=0.;
        for(int i=0 ; i<number; i++) {
            temp1=calc.sum(String.valueOf(temp1),String.valueOf(data.get(i)));
            temp2=calc.sum(String.valueOf(temp2),String.valueOf(data.get(number-1-i)));
        }
        R[0][0]=temp1;
        R[0][1]=temp2;
        return R;
    }

    @DataProvider
    public Object[][] iterationMultiplication() {
        Object[][] R=new Double[1][2];
        Double temp1=1.;
        Double temp2=1.;
        for(int i=0 ; i<number; i++) {
            temp1=calc.multiplication(String.valueOf(temp1),String.valueOf(data.get(i)));
            temp2=calc.multiplication(String.valueOf(temp2),String.valueOf(data.get(number-1-i)));
        }
        R[0][0]=temp1;
        R[0][1]=temp2;
        return R;
    }

    @DataProvider
    public Object[][] sumOfOnes() {
        Double a = 1.;
        Double temp = 0.;
        Object[][] R = new Double[1][2];
        for (int i = 0; i < number; i++) {
            temp = calc.sum(String.valueOf(temp), String.valueOf(a));
        }
        R[0][0] = temp;
        R[0][1] = calc.multiplication(String.valueOf(a),String.valueOf(number));
        return R;
    }

    @DataProvider
    public Object[][] multiplicationOfOnes() {
        Double a = 1.+1e-18;
        Double temp = 1.;
        Object[][] R = new Double[1][2];
        for (int i = 0; i < number; i++) {
            temp = calc.multiplication(String.valueOf(temp), String.valueOf(a));
        }
        R[0][0] = temp;
        R[0][1] = a;
        return R;
    }

    @DataProvider
    public Object[][] multiplicationOfZeros() {
        Double a = 1e-18;
        Double temp = 1e-18;
        Object[][] R = new Double[1][2];
        for (int i = 0; i < number; i++) {
            temp = calc.multiplication(String.valueOf(temp), String.valueOf(a));
        }
        R[0][0] = temp;
        R[0][1] = 0.;
        return R;
    }

    @DataProvider
    public Object[][] sumOfZeros() {
        Double a = 1e-18;
        Double temp = 0.;
        Object[][] R = new Double[1][2];
        for (int i = 0; i < number; i++) {
            temp = calc.sum(String.valueOf(temp), String.valueOf(a));
        }
        R[0][0] = temp;
        R[0][1] = calc.multiplication(String.valueOf(a),String.valueOf(number));
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
