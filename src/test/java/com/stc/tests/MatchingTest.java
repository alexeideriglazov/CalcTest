package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.Vector;

public class MatchingTest {
    private Calculator calc1;
    private Calculator calc2;
    private int number;
    private Vector<Vector<Double>> data;

    @BeforeSuite
    public void setUp()
    {
        calc1=new Calculator();
        calc2=new Calculator();
        number=100;
        data=new Vector<>();
        Random r1=new Random();
        for(int i=0; i<number; i++)
        {
            Vector<Double> h=new Vector<>();
            h.add(r1.nextDouble());
            h.add(r1.nextDouble());
            data.add(h);
        }
    }

    @DataProvider
    public Object[][] sumFileData()
    {
        Object [][] R=new Double [number][2];
        for(int i =0; i<number; i++) {
            String a= String.valueOf(data.get(i).get(0));
            String b=String.valueOf(data.get(i).get(1));
            R[i][0]=calc1.sum(a,b);
            R[i][1]=calc2.sum(a,b);
        }
        return R;
    }

    @DataProvider
    public Object[][] multiplicationFileData()
    {
        Object [][] R=new Double [number][2];
        for(int i =0; i<number; i++) {
            String a= String.valueOf(data.get(i).get(0));
            String b=String.valueOf(data.get(i).get(1));
            R[i][0]=calc1.multiplication(a,b);
            R[i][1]=calc2.multiplication(a,b);
        }
        return R;
    }

    @DataProvider
    public Object[][] differenceFileData()
    {
        Object [][] R=new Double [number][2];
        for(int i =0; i<number; i++) {
            String a= String.valueOf(data.get(i).get(0));
            String b=String.valueOf(data.get(i).get(1));
            R[i][0]=calc1.difference(a,b);
            R[i][1]=calc2.difference(a,b);
        }
        return R;
    }

    @DataProvider
    public Object[][] divisionFileData()
    {
        Object [][] R=new Double [number][2];
        for(int i =0; i<number; i++) {
            String a= String.valueOf(data.get(i).get(0));
            String b=String.valueOf(data.get(i).get(1));
            R[i][0]=calc1.division(a,b);
            R[i][1]=calc2.division(a,b);
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
        calc1=null;
        calc2=null;
    }
    */
}
