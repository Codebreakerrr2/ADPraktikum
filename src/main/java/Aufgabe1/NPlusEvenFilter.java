package Aufgabe1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class NPlusEvenFilter {
    public static void main(String[] args) {
        while(!StdIn.isEmpty()){

            double number=StdIn.readDouble();
            if(number%2==0 && number>0) StdOut.print(number+" ");
        }
    }
}
