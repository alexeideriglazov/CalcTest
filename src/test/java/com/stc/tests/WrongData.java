package com.stc.tests;

import calc.Calculator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WrongData {
    private Calculator calc;

    @BeforeSuite
    public void setUp() {
        calc = new Calculator();
    }

    @DataProvider
    public Object[][] formatException() {
        return new Object[][]{
                {"", ""},
                {"zero", "1.0"},
                {"o", "2.1"},
                {"0.1", "string"},
                {"0,1", "0.1"},
        };
    }

    @DataProvider
    public Object[][] nullException() {
        return new Object[][]{
                {"1", null},
                {null, "1"},
                {null, null},
        };
    }

    @Test(dataProvider = "formatException", expectedExceptions = NumberFormatException.class)
    public void testSum(String first, String second) {
        calc.sum(first, second);
    }

    @Test(dataProvider = "formatException", expectedExceptions = NumberFormatException.class)
    public void testDifference(String first, String second) {
        calc.difference(first, second);
    }

    @Test(dataProvider = "formatException", expectedExceptions = NumberFormatException.class)
    public void testMultiplication(String first, String second) {
        calc.multiplication(first, second);
    }

    @Test(dataProvider = "formatException", expectedExceptions = NumberFormatException.class)
    public void testDivision(String first, String second) {
        calc.division(first, second);
    }

    @Test(dataProvider = "nullException", expectedExceptions = NullPointerException.class)
    public void nullSum(String first, String second) {
        calc.sum(first, second);
    }

    @Test(dataProvider = "nullException", expectedExceptions = NullPointerException.class)
    public void nullDifference(String first, String second) {
        calc.difference(first, second);
    }

    @Test(dataProvider = "nullException", expectedExceptions = NullPointerException.class)
    public void nullMultiplication(String first, String second) {
        calc.multiplication(first, second);
    }

    @Test(dataProvider = "nullException", expectedExceptions = NullPointerException.class)
    public void nullDivision(String first, String second) {
        calc.division(first, second);
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