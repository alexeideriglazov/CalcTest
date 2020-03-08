package com.stc.tests;

import calc.Calculator;
import helpers.operands.OperandsStorage;
import helpers.operands.SimpleData;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MatchingTest {
    private Calculator calc1;
    private Calculator calc2;
    private OperandsStorage data;

    @BeforeSuite
    public void setUp() {
        calc1 = new Calculator();
        calc2 = new Calculator();
        data = new OperandsStorage("src/test/resources/MatchingData");
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
    public void sumTest(SimpleData input) {
        System.out.println("sumTest is starting with input data: " + input.operands.get(0) + " and " + input.operands.get(1));
        double difference = Math.abs(calc1.sum(input.operands.get(0), input.operands.get(1)) - calc2.sum(input.operands.get(0), input.operands.get(1)));
        Assert.assertEquals(calc1.sum(input.operands.get(0), input.operands.get(1)), calc2.sum(input.operands.get(0), input.operands.get(1)), "Difference is: " + difference);
    }

    @Test(dataProvider = "inputData")
    public void differenceTest(SimpleData input) {
        System.out.println("differenceTest is starting with input data: " + input.operands.get(0) + " and " + input.operands.get(1));
        double difference = Math.abs(calc1.difference(input.operands.get(0), input.operands.get(1)) - calc2.difference(input.operands.get(0), input.operands.get(1)));
        Assert.assertEquals(calc1.difference(input.operands.get(0), input.operands.get(1)), calc2.difference(input.operands.get(0), input.operands.get(1)),
                "Difference is: " + difference);
    }

    @Test(dataProvider = "inputData")
    public void divisionTest(SimpleData input) {
        System.out.println("divisionTest is starting with input data: " + input.operands.get(0) + " and " + input.operands.get(1));
        double difference = Math.abs(calc1.division(input.operands.get(0), input.operands.get(1)) - calc2.division(input.operands.get(0), input.operands.get(1)));
        Assert.assertEquals(calc1.division(input.operands.get(0), input.operands.get(1)), calc2.division(input.operands.get(0), input.operands.get(1)), "Difference is: " + difference);
    }

    @Test(dataProvider = "inputData")
    public void multiplicationTest(SimpleData input) {
        System.out.println("multiplicationTest is starting with input data: " + input.operands.get(0) + " and " + input.operands.get(1));
        double difference = Math.abs(calc1.multiplication(input.operands.get(0), input.operands.get(1)) - calc2.multiplication(input.operands.get(0), input.operands.get(1)));
        Assert.assertEquals(calc1.multiplication(input.operands.get(0), input.operands.get(1)), calc2.multiplication(input.operands.get(0), input.operands.get(1)), "Difference is: " + difference);
    }

     /*
    TODO
    @AfterSuite
    public void killAll()
    {
        calc1=null;
        calc2=null;
        data1=null;
        data2=null;
    }
    */
}
