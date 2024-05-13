package Aufgabe2;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.List;


public class doublingTest {


    public static void main(String[] args) {
        System.err.println("N       time        ratio");
        List<Integer> dList = new DoublyLinkedList<>();
        int N = 1000;
        double previousTime=trialTime(dList);
        for (int i = 0; i < 100; i++) {
            for (int j = dList.size(); j < N; j++) {
                dList.add(j);
            }

            double currentTime=trialTime(dList);
            StdOut.printf("%6d %7.3f %5.3f\n", N, currentTime, currentTime/previousTime);
            previousTime=currentTime;
            N *= 2;
        }
    }

    private static double trialTime(List<Integer> dList) {
        Stopwatch timer= new Stopwatch();
        for(int i=0;i<dList.size();i++){
            dList.get(i);
        }
        double d= timer.elapsedTime();
        return d;
    }
}
