package com.stc.tests;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class KeyboardInputTest {
    private Calculator calc;
    List<List<String>> sumData;
    List<List<String>> differenceData;
    List<List<String>> divisionData;
    List<List<String>> multiplicationData;
    double eps;

    @BeforeSuite
    public void setUp() {
        sumData=new ArrayList<>();
        differenceData=new ArrayList<>();
        divisionData=new ArrayList<>();
        multiplicationData=new ArrayList<>();
       Scanner in=new Scanner(System.in);
       System.out.println("Now, we're going to test out calculator");
       System.out.println("Please, input two numbers, name of method and expected result ");
       System.out.println("Calculator can realise next methods: 'sum', 'difference', 'division', 'multiplication'");
       System.out.println("For example: 1.2 -1.1 sum 0.1");
       System.out.println("To stop reading data and start tests please write 'Lets test'");
       while(true)
       {
           List<List<String>> tempSum=new LinkedList<>();
           List<List<String>> tempDifference=new LinkedList<>();
           List<List<String>> tempDivision=new LinkedList<>();
           List<List<String>> tempMultiplication=new LinkedList<>();
           String temp=in.nextLine();
           if(temp.equals("Lets test")|| temp.equals("lets test"))
               break;
           String[] str=temp.split("\\s");
           List<String> temporary=new LinkedList<>();
           try {
               switch (str[2]) {
                   case "sum":
                       temporary.add(str[0]);
                       temporary.add(str[1]);
                       temporary.add(str[3]);
                       tempSum.add(temporary);
                       break;
                   case "difference":
                       temporary.add(str[0]);
                       temporary.add(str[1]);
                       temporary.add(str[3]);
                       tempDifference.add(temporary);
                       break;
                   case "multiplication":
                       temporary.add(str[0]);
                       temporary.add(str[1]);
                       temporary.add(str[3]);
                       tempMultiplication.add(temporary);
                       break;
                   case "division":
                       temporary.add(str[0]);
                       temporary.add(str[1]);
                       temporary.add(str[3]);
                       tempDivision.add(temporary);
                       break;
                   default:
                       System.err.print(str[2]);
                       System.err.println(" method does not exist");
               }
           }catch(IndexOutOfBoundsException ex) {
               System.err.println("Check input data!");
               ex.printStackTrace();
           }
       }
       in.close();
    }

    @DataProvider
    public Object[][] sumKeyboardData()
    {
        Object [][] R=new Double [sumData.size()][2];
        for(int i =0; i<sumData.size(); i++) {
            R[i][0]=calc.difference(sumData.get(i).get(0),sumData.get(i).get(1));
            R[i][1]=Double.parseDouble(sumData.get(i).get(2));
        }
        return R;
    }

    @DataProvider
    public Object[][] differenceKeyboardData()
    {
        Object [][] R=new Double [sumData.size()][2];
        for(int i =0; i<sumData.size(); i++) {
            R[i][0]=calc.difference(sumData.get(i).get(0),sumData.get(i).get(1));
            R[i][1]=Double.parseDouble(sumData.get(i).get(2));
        }
        return R;
    }

    @DataProvider
    public Object[][] divisionKeyboardData()
    {
        Object [][] R=new Double [divisionData.size()][2];
        for(int i =0; i<divisionData.size(); i++) {
            R[i][0]=calc.division(divisionData.get(i).get(0),divisionData.get(i).get(1));
            R[i][1]=Double.parseDouble(divisionData.get(i).get(2));
        }
        return R;
    }

    @DataProvider
    public Object[][] multiplicationKeyboardData()
    {
        Object [][] R=new Double [multiplicationData.size()][2];
        for(int i =0; i<multiplicationData.size(); i++) {
            R[i][0]=calc.multiplication(multiplicationData.get(i).get(0),multiplicationData.get(i).get(1));
            R[i][1]=Double.parseDouble(multiplicationData.get(i).get(2));
        }
        return R;
    }

    @Test(dataProvider = "sumKeyboardData")
    public void sumTest(Double actual, Double expected) {
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "differenceKeyboardData")
    public void differenceTest(Double actual, Double expected) {
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "divisionKeyboardData")
    public void divisionTest(Double actual, Double expected) {
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "multiplicationKeyboardData")
    public void multiplicationTest(Double actual, Double expected) {
        Assert.assertEquals(actual,expected);
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

