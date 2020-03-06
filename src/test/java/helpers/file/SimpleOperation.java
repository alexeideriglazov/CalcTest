package helpers.file;

public class SimpleOperation {
    public String left;
    public String right;
    public Operations operation;
    public String excepted;
    SimpleOperation(String left, String right, String operation, String expected){
        this.excepted=expected;
        this.left=left;
        this.right=right;
        try {
            this.operation = Operations.valueOf(operation);
        }catch(IllegalArgumentException e) {
            System.err.println(operation+" method does not exist!");
            e.printStackTrace();
        }
    }
}
