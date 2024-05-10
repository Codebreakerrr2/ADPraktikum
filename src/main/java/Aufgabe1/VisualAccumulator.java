package Aufgabe1;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class VisualAccumulator extends SimpleAccumulator implements Accumulator{

    public VisualAccumulator(double max, int trials) {
        StdDraw.setXscale(0,trials);
        StdDraw.setYscale(0,max);
        StdDraw.setPenRadius(0.005);
    }


    @Override
    public void addDataValue(double data) {
        super.addDataValue(data);
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.point(N,data);
        StdDraw.setPenColor(Color.RED);
        StdDraw.point(N,total/N);
    }
}
