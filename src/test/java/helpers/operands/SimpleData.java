package helpers.operands;

import java.util.ArrayList;
import java.util.List;

public class SimpleData {
    public List<String> operands;

    public SimpleData(String[] args) {
        operands = new ArrayList<>();
        int n = args.length;
        for (int i = 0; i < n; i++) {
            operands.add(args[i]);
        }
    }
}
