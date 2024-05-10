package Aufgabe1;

import com.google.common.base.Preconditions;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Arrays;

public class AccumulatorClient {

    public static void main(String[] args) {
        double[] inputData= null;
        if(!StdIn.isEmpty()){
            inputData= StdIn.readAllDoubles();
        }
        //Preconditions.checkNotNull(inputData);

        double max= 0;
        for(double d: inputData){
            max=Math.max(max,d);
        }
        int trials= inputData.length;

        Accumulator accumulator= (Integer.parseInt(args[0])==0) ? new SimpleAccumulator(): new VisualAccumulator(max,trials);
        for(double zahl: inputData){
            accumulator.addDataValue(zahl);
        }
    }
}
