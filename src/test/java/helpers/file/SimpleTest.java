package helpers.file;

public class SimpleTest {
    public String left;
    public String right;
    public double excepted;
    SimpleTest(SimpleOperation operation){
        this.left=operation.left;
        this.right=operation.right;
        this.excepted=Double.parseDouble(operation.excepted);
    }
}
