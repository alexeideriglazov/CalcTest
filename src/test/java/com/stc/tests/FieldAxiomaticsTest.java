package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.Vector;

public class FieldAxiomaticsTest {
    private Calculator calc1;
    private int number;
    private Vector<Vector<Double>> data;
    private double eps;

    @BeforeSuite
    public void setUp()
    {
        calc1=new Calculator();
        number=100;
        data=new Vector<>();
        eps=1e-15;
        Random r1=new Random();
        for(int i=0; i<number; i++)
        {
            Vector<Double> h= new Vector<>();
            h.add(r1.nextDouble());
            h.add(r1.nextDouble());
            h.add(r1.nextDouble());
            data.add(h);
        }
    }

    @DataProvider
    public Object[][] distributionData()
    {
        Object [][] R=new Double [number][2];
        for(int i =0; i<number; i++) {
            String a= String.valueOf(data.get(i).get(0));
            String b=String.valueOf(data.get(i).get(1));
            String c=String.valueOf(data.get(i).get(1));
            String aAndC=String.valueOf(calc1.multiplication(a,c));
            String bAndC=String.valueOf(calc1.multiplication(b,c));
            String aPlusB=String.valueOf(calc1.sum(a,b));
            R[i][0]=calc1.multiplication(aPlusB,c);
            R[i][1]=calc1.sum(aAndC,bAndC);
        }
        return R;
    }

    @DataProvider
    public Object[][] neutralSum()
    {
        Object [][] R=new Double [number][2];
        for(int i =0; i<number; i++) {
            String a= String.valueOf(data.get(i).get(0));
            String b=String.valueOf(0.0);
            R[i][0]=calc1.sum(a,b);
            R[i][1]=Double.parseDouble(a);
        }
        return R;
    }

    @DataProvider
    public Object[][] neutralMultiplication()
    {
        Object [][] R=new Double [number][2];
        for(int i =0; i<number; i++) {
            String a= String.valueOf(data.get(i).get(0));
            String b=String.valueOf(1);
            R[i][0]=calc1.multiplication(a,b);
            R[i][1]=Double.parseDouble(a);
        }
        return R;
    }

    @DataProvider
    public Object[][] commutativeSum()
    {
        Object [][] R=new Double [number][2];
        for(int i =0; i<number; i++) {
            String a= String.valueOf(data.get(i).get(0));
            String b=String.valueOf(data.get(i).get(1));
            R[i][0]=calc1.sum(a,b);
            R[i][1]=calc1.sum(b,a);
        }
        return R;
    }

    @DataProvider
    public Object[][] commutativeMultiplication() {
        Object[][] R = new Double[number][2];
        for (int i = 0; i < number; i++) {
            String a = String.valueOf(data.get(i).get(0));
            String b = String.valueOf(data.get(i).get(1));
            R[i][0] = calc1.multiplication(a, b);
            R[i][1] = calc1.multiplication(b, a);
        }
        return R;
    }

    @DataProvider
    public Object[][] inverseSum() {
        Object[][] R = new Double[number][2];
        for (int i = 0; i < number; i++) {
            String a = String.valueOf(data.get(i).get(0));
            String b = String.valueOf(0.0);
            String r1=String.valueOf(calc1.difference(b,a));
            R[i][0] = calc1.sum(a, r1);
            R[i][1] = 0.0;
        }
        return R;
    }

    @DataProvider
    public Object[][] inverseMultiplication() {
        Object[][] R = new Double[number][2];
        for (int i = 0; i < number; i++) {
            String a = String.valueOf(data.get(i).get(0));
            String b = String.valueOf(calc1.division(String.valueOf(1.0),a));
            R[i][0] = calc1.multiplication(a,b);
            R[i][1] = 1.0;
        }
        return R;
    }

    @DataProvider
    public Object[][] associativeSum() {
        Object[][] R = new Double[number][2];
        for (int i = 0; i < number; i++){
            String a=String.valueOf(data.get(i).get(0));
            String b=String.valueOf(data.get(i).get(1));
            String c=String.valueOf(data.get(i).get(2));
            String aPlusB=String.valueOf(calc1.sum(a,b));
            R[i][0]=calc1.sum(aPlusB,c);
            String bPlucC=String.valueOf(calc1.sum(b,c));
            R[i][1]=calc1.sum(a,bPlucC);
        }
        return R;
    }

    @DataProvider
    public Object[][] associativeMultiplication() {
        Object[][] R = new Double[number][2];
        for (int i = 0; i < number; i++){
            String a=String.valueOf(data.get(i).get(0));
            String b=String.valueOf(data.get(i).get(1));
            String c=String.valueOf(data.get(i).get(2));
            String aMultB=String.valueOf(calc1.multiplication(a,b));
            R[i][0]=calc1.multiplication(aMultB,c);
            String bMultC=String.valueOf(calc1.multiplication(b,c));
            R[i][1]=calc1.multiplication(a,bMultC);
        }
        return R;
    }

    @Test(dataProvider = "associativeMultiplication")
    public void associativeMultiplicationTest(Double first, Double second){
        assert(Math.abs(first-second)<=eps);
    }

    @Test(dataProvider = "associativeSum")
    public void associativeSumTest(Double first, Double second){
        assert(Math.abs(first-second)<=eps);
    }

    @Test(dataProvider = "inverseMultiplication")
    public void inverseMultiplicationTest(Double first, Double second)
    {
        assert(Math.abs(first-second)<=eps);
    }

    @Test(dataProvider = "inverseSum")
    public void inverseSumTest(Double first, Double second)
    {
        Assert.assertEquals(first,second);
    }

    @Test(dataProvider = "commutativeSum")
    public void commutativeSumTest(Double first, Double second){
        Assert.assertEquals(first,second);
    }

    @Test(dataProvider = "commutativeMultiplication")
    public void commutativeMultiplicationTest(Double first, Double second){
        Assert.assertEquals(first,second);
    }


    @Test(dataProvider = "distributionData")
    public void distributionTest(Double first, Double second) {
        assert(Math.abs(first-second)<=eps);
    }

    @Test(dataProvider = "neutralSum")
    public void neutralSumTest(Double first, Double second) {
        assert(Math.abs(first-second)<=eps);
    }

    @Test(dataProvider = "neutralMultiplication")
    public void neutralMultiplicationTest(Double first, Double second) { Assert.assertEquals(first,second);
    }

     /*
    TODO
    @AfterSuite
    public void killAll()
    {
        calc1=null;
    }
    */
}