package helpers.random;

import helpers.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomData {
    public List<String> randData;
    public RandomData(){
        Random r=new Random();
        randData=new ArrayList<>();
        for (int i=0; i< Constants.NUMBER; i++){
            double k=(r.nextInt((int) 10)+1)*Math.pow(-1,r.nextInt(10)+1);
            randData.add(String.valueOf(k));
        }
    }
}
