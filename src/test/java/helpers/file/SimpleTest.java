package helpers.file;

public class SimpleTest {
    public String leftOperand;
    public String rightOperand;
    public double expectedResult;

    SimpleTest(SimpleOperation operation) {
        this.leftOperand = operation.left;
        this.rightOperand = operation.right;
        this.expectedResult = Double.parseDouble(operation.excepted);
    }
}
