package com.stc.tests;

import calc.Calculator;
import helpers.operands.SimpleData;
import helpers.Constants;
import helpers.operands.OperandsStorage;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FieldAxiomaticsTest {
    private Calculator calc;
    private OperandsStorage data;

    @BeforeSuite
    public void setUp() {
        calc = new Calculator();
        data = new OperandsStorage("src/test/resources/AxiomaticsData");
    }

    @DataProvider
    public Object[][] numbers() {
        Object[][] providerData = new Object[data.number()][1];
        for (int i = 0; i < data.number(); i++) {
            providerData[i][0] = data.getElem(i);
        }
        return providerData;
    }

    @Test(dataProvider = "numbers")
    public void associativeMultiplicationTest(SimpleData input) {
        System.out.println("associativeMultiplicationTest is starting with input data: " + input.operands.get(0) + " , " + input.operands.get(1) + " , " + input.operands.get(2));
        double value1 = calc.multiplication(input.operands.get(0), String.valueOf(calc.multiplication(input.operands.get(1), input.operands.get(2))));
        double value2 = calc.multiplication(String.valueOf(calc.multiplication(input.operands.get(0), input.operands.get(1))), input.operands.get(2));
        double difference = Math.abs(value1 - value2);
        Assert.assertEquals(value1, value2, "Difference is: " + difference);
    }

    @Test(dataProvider = "numbers")
    public void associativeSumTest(SimpleData input) {
        System.out.println("associativeSumTest is starting with input data: " + input.operands.get(0) + " , " + input.operands.get(1) + " , " + input.operands.get(2));
        double value1 = calc.sum(input.operands.get(0), String.valueOf(calc.sum(input.operands.get(1), input.operands.get(2))));
        double value2 = calc.sum(String.valueOf(calc.sum(input.operands.get(0), input.operands.get(1))), input.operands.get(2));
        double difference = Math.abs(value1 - value2);
        Assert.assertEquals(value1, value2, "Difference is: " + difference);
    }

    @Test(dataProvider = "numbers")
    public void distributionTest(SimpleData input) {
        System.out.println("distributionTest is starting with input data: " + input.operands.get(0) + " , " + input.operands.get(1) + " , " + input.operands.get(2));
        double value1 = calc.multiplication(input.operands.get(0), String.valueOf(calc.sum(input.operands.get(1), input.operands.get(2))));
        double value2 = calc.sum(String.valueOf(calc.multiplication(input.operands.get(0), input.operands.get(2))), String.valueOf(calc.multiplication(input.operands.get(0), input.operands.get(1))));
        double difference = calc.multiplication(input.operands.get(0), String.valueOf(calc.sum(input.operands.get(1), input.operands.get(2)))) - calc.sum(String.valueOf(calc.multiplication(input.operands.get(0), input.operands.get(2))), String.valueOf(calc.multiplication(input.operands.get(0), input.operands.get(1))));
        Assert.assertEquals(value1, value2, "Difference is: " + difference);
    }

    @Test(dataProvider = "numbers")
    public void commutativeSumTest(SimpleData input) {
        System.out.println("commutativeSumTest is starting with input data: " + input.operands.get(0) + " , " + input.operands.get(1));
        double value1 = calc.sum(input.operands.get(0), input.operands.get(1));
        double value2 = calc.sum(input.operands.get(1), input.operands.get(0));
        double difference = Math.abs(value1 - value2);
        Assert.assertEquals(value1, value2, "Difference is: " + difference);
    }

    @Test(dataProvider = "numbers")
    public void commutativeMultiplicationTest(SimpleData input) {
        System.out.println("commutativeMultiplicationTest is starting with input data: " + input.operands.get(0) + " , " + input.operands.get(1));
        double value1 = calc.multiplication(input.operands.get(0), input.operands.get(1));
        double value2 = calc.multiplication(input.operands.get(1), input.operands.get(0));
        double difference = Math.abs(value1 - value2);
        Assert.assertEquals(value1, value2, "Difference is: " + difference);
    }

    @Test(dataProvider = "numbers")
    public void neutralSumTest(SimpleData input) {
        System.out.println("neutralSumTestTest is starting with input data: " + input.operands.get(0));
        double value1 = calc.sum(input.operands.get(0), "0");
        double value2 = Double.parseDouble(input.operands.get(0));
        double difference = Math.abs(value1 - value2);
        Assert.assertEquals(value1, value2, "Difference is: " + difference);
    }

    @Test(dataProvider = "numbers")
    public void neutralMultiplicationTest(SimpleData input) {
        System.out.println("neutralMultiplicationTestTest is starting with input data: " + input.operands.get(0));
        double value1 = calc.multiplication(input.operands.get(0), "1");
        double value2 = Double.parseDouble(input.operands.get(0));
        double difference = Math.abs(value1 - value2);
        Assert.assertEquals(value1, value2, "Difference is: " + difference);
    }

    @Test(dataProvider = "numbers")
    public void inverseMultiplicationTest(SimpleData input) {
        System.out.println("inverseMultiplicationTestTest is starting with input data: " + input.operands.get(0));
        assert (Math.abs(calc.multiplication(input.operands.get(0), String.valueOf(calc.division("1", input.operands.get(0)))) - 1.) <= Constants.EPS)
                : "Difference is more than: " + Constants.EPS;

    }

    @Test(dataProvider = "numbers")
    public void inverseSumTest(SimpleData input) {
        System.out.println("inverseMultiplicationTestTest is starting with input data: " + input.operands.get(0));
        double difference = Math.abs(calc.sum(input.operands.get(0), String.valueOf(calc.difference("0", input.operands.get(0)))));
        Assert.assertEquals(difference, 0., "Difference is: " + difference);
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