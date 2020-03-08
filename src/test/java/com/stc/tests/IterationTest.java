package com.stc.tests;

import calc.Calculator;
import helpers.operands.OperandsStorage;
import helpers.operands.SimpleData;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IterationTest {
    private Calculator calc;
    private OperandsStorage data;

    @BeforeSuite
    public void setUp() {
        calc = new Calculator();
        data = new OperandsStorage("src/test/resources/IterationData");

    }

    @DataProvider
    public Object[][] inputData() {
        Object[][] providerData = new Object[data.number()][1];
        for (int i = 0; i < data.number(); i++) {
            providerData[i][0] = data.getElem(i);
        }
        return providerData;
    }

    @Test(dataProvider = "inputData")
    public void testMult(SimpleData input) {
        double multResult1 = 1.;
        double multResult2 = 1.;
        System.out.println("testMult is starting with input data: ");
        for (String operand : input.operands)
            System.out.print(operand + ", ");
        for (int i = 0; i < input.operands.size(); i++) {
            multResult1 = calc.multiplication(input.operands.get(i), String.valueOf(multResult1));
            multResult2 = calc.multiplication(input.operands.get(input.operands.size() - i - 1), String.valueOf(multResult2));
        }
        double difference = Math.abs(multResult1 - multResult2);
        Assert.assertEquals(multResult1, multResult2, "Difference is: " + difference);
    }

    @Test(dataProvider = "inputData")
    public void testSum(SimpleData input) {
        double sumResult1 = 0.;
        double sumResult2 = 0.;
        System.out.println("testSum is starting with input data: ");
        for (String operand : input.operands)
            System.out.print(operand + ", ");
        for (int i = 0; i < input.operands.size(); i++) {
            sumResult1 = calc.sum(input.operands.get(i), String.valueOf(sumResult1));
            sumResult2 = calc.sum(input.operands.get(input.operands.size() - i - 1), String.valueOf(sumResult2));
        }
        double difference = Math.abs(sumResult1 - sumResult2);
        Assert.assertEquals(sumResult1, sumResult2, "Difference is: " + difference);
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
